package com.example.pojo;

import java.io.Serializable;
import java.util.Date;

public class TestUser implements Serializable {
    private Integer id;

    private String username;

    private String password;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public TestUser(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
