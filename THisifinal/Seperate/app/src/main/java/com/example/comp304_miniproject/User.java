package com.example.comp304_miniproject;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String username;
    private String emailid;
    private String password;
    private String phoneno;

    public User(int id, String username, String emailid, String password, String phoneno) {
        this.id = id;
        this.username = username;
        this.emailid = emailid;
        this.password = password;
        this.phoneno = phoneno;
    }
    public User(){

    }



    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
