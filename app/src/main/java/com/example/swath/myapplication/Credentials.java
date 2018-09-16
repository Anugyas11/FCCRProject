package com.example.swath.myapplication;

import java.io.Serializable;

public class Credentials implements Serializable{
    private String username;
    private String password;

    //Singleton information: tutorialspoint.com

    private static Credentials instance = null;

    private Credentials() {
        this.username = "Admin";
        this.password = "1234";
    }

    public static Credentials getInstance() {
        if (instance == null) { //if it doesnt exist, create it
            instance = new Credentials();
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
