package com.codeup.blog.models;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 100, unique = true)
    private String email;

    @Column(nullable = false, length = 100, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    public User(){}

    public User(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(long id, String email, String username, String password){
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        username = copy.username;
        password = copy.password;
    }

    public long getId(){
        return this.id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getUsername(){
        return this.username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return this.password;
    }

    public void setPassword(String password){
        this.password = password;
    }

}
