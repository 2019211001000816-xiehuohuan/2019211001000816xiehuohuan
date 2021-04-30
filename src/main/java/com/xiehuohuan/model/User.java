package com.xiehuohuan.model;


import java.util.Date;

public class User {
    private int id;
    private String username;
    private String passward;
    private String email;
    private String genter;
    private Date birthDate;

    public User() {
    }

    public User(int id, String username, String passward, String email, String genter, Date birthDate) {
        this.id = id;
        this.username = username;
        this.passward = passward;
        this.email = email;
        this.genter = genter;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", passward='" + passward + '\'' +
                ", email='" + email + '\'' +
                ", genter='" + genter + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassward() {
        return passward;
    }

    public void setPassward(String passward) {
        this.passward = passward;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenter() {
        return genter;
    }

    public void setGenter(String genter) {
        this.genter = genter;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}