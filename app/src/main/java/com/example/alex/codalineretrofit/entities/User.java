package com.example.alex.codalineretrofit.entities;

import com.google.gson.annotations.SerializedName;

public class User {

    private String login;

    private int id;

    @SerializedName("avatar_url")
    private String avatarUrl;

    public User(String login, int id, String avatarUrl) {
        this.login = login;
        this.id = id;
        this.avatarUrl = avatarUrl;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }
}
