package com.codeup.blog.controllers;

import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repos.PostRepository;
import com.codeup.blog.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {

        this.postDao = postDao;
        this.userDao = userDao;
    }

    @GetMapping("/posts")
    public String index(Model model) {
        model.addAttribute("posts", postDao.findAll());
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String showPost(@PathVariable long id, Model model) {
        model.addAttribute("post", postDao.getOne(id));
        Post post = postDao.getOne(id);
        String email = post.getOwner().getEmail();
        model.addAttribute("email", email);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm() {
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String submitPost(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body) {
        User user = userDao.getOne(1L);
        Post post = new Post();
        post.setTitle(title);
        post.setBody(body);
        post.setOwner(user);
        postDao.save(post);

        Post dbPost = postDao.save(post);
        return "redirect:/posts/" + dbPost.getId();
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }

    @GetMapping("/posts/{id}/edit")
    public String showEditForm(@PathVariable long id, Model viewModel) {
        viewModel.addAttribute("post", postDao.getOne(id));
        return "posts/edit";
    }

    @PostMapping("/posts/{id}/edit")
    public String editPost(
            @PathVariable long id,
            @RequestParam(name = "title") String title,
            @RequestParam(name = "body") String body
    ) {
        Post dbPost = postDao.getOne(id);
        dbPost.setTitle(title);
        dbPost.setBody(body);
        postDao.save(dbPost);
        return "redirect:/posts/" + dbPost.getId();
    }
}
