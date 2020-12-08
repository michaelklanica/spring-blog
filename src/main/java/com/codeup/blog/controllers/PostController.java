package com.codeup.blog.controllers;

import com.codeup.blog.services.EmailService;
import com.codeup.blog.models.Post;
import com.codeup.blog.models.User;
import com.codeup.blog.repos.PostRepository;
import com.codeup.blog.repos.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    private final PostRepository postDao;
    private final UserRepository userDao;
    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {

        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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
        String username = post.getOwner().getUsername();
        model.addAttribute("username", username);
        return "posts/show";
    }

    @GetMapping("/posts/create")
    public String showCreateForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }

    @PostMapping("/posts/create")
    public String submitPost(@ModelAttribute Post postToBeSaved) {
        User userDb = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postToBeSaved.setOwner(userDb);
        // THIS IS A GOOD PLACE TO ADD ANY RELATED DATA
        Post dbPost = postDao.save(postToBeSaved);
        emailService.prepareAndSend(dbPost, "Post has been created", "You have successfully sent an email.");
        return "redirect:/posts/" + dbPost.getId() ;
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
    public String editPost(Post postToBeSaved) {
        User userDb = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        postToBeSaved.setOwner(userDb);
        postDao.save(postToBeSaved);
        return "redirect:/posts";
    }

}
