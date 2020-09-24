package com.example.chatroom.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class User {

    private Long id;
    @NotBlank
    @Size(max = 20)
    private String username;
    @NotBlank
    @Size(max = 120)
    private String password;
    @Size(max = 50)
    @Email
    private String email;

    private List<Friend> Friends;

    public User() {
    }

    public User(Long id, @NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 120) String password, @Size(max = 50) @Email String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Friend> getFriends() {
        return Friends;
    }

    public void setFriends(List<Friend> Friends) {
        this.Friends = Friends;
    }
}
