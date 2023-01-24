package com.backEndApiChallenge.model;

public class User {
    private String username;
    private String password;
    private String IpAddress;

    public User(){

    }

    public User(String username, String password, String IpAddress) {
        this.username = username;
        this.password = password;
        this.IpAddress = IpAddress;
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

    public String getIpAddress() {
        return IpAddress;
    }
    public void setIpAddress(String ipAddress) {
        IpAddress = ipAddress;
    }
}
