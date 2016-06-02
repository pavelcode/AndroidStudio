package com.cblue.designpattern.mvc;

/**
 * Created by pavel on 16/5/25.
 */
public class UserBean {
    public UserBean() {
    }

    public UserBean(String name, String password) {
        this.name = name;
        this.password = password;
    }

    private String name;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String password;
}
