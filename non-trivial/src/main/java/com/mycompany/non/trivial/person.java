 package com.mycompany.non.trivial;

public abstract class person {
    private String username;
    private String password;
    private String number;
    private String email;
    protected boolean status=true;
    protected system system;
    protected notify notifications=new notify();///////////////////

    public notify getNotifications() {
        return notifications;
    }

    public void setNotifications(notify notifications) {
        this.notifications = notifications;
    }

    public person() {
    }

    public person(String username, String password, String number, String email, system system) {
        this.username = username;
        this.password = password;
        this.number = number;
        this.email = email;
        this.system = system;
    }
    public boolean isStatus() {
        return status;
    }
    
    public void setStatus(boolean status) {
        this.status = status;
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public system getSystem() {
        return system;
    }

    public void setSystem(system system) {
        this.system = system;
    }


}
