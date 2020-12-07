package com.codeup.blog.models;


import javax.persistence.*;

@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "COMPOUND_TEXT")
    private String body;

    @OneToOne
    private User owner;

    public Post() {
    }

    // READ
    public Post(String title, String body){
        this.title = title;
        this.body = body;
    };

    // WRITE
    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return this.body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getId(){return id;}

    public void setId(long id) {
        this.id = id;
    }

    public void setOwner(User owner){
        this.owner = owner;
    }

    public User getOwner(){return this.owner;}


}
