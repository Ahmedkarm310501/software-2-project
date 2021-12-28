
package com.mycompany.non.trivial;

public class event {
    private String name;
    private String time;
    private ride ride;
    private String driver_name;
    private String user_name;
    private float price;

    public String getDriver_name() {
        return driver_name;
    }

    public void setDriver_name(String driver_name) {
        this.driver_name = driver_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public event(String name, String time, ride ride, String driver_name, String user_name, float price) {
        this.name = name;
        this.time = time;
        this.ride = ride;
        this.driver_name = driver_name;
        this.user_name = user_name;
        this.price = price;
    }

    public event(String name, String time, String user_name) {
        this.name = name;
        this.time = time;
        this.user_name = user_name;
    }

    public event(String name, String time, String driver_name, String user_name) {
        this.name = name;
        this.time = time;
        this.driver_name = driver_name;
        this.user_name = user_name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public event() {
    }

    public ride getRide() {
        return ride;
    }

    public void setRide(ride ride) {
        this.ride = ride;
    }
    
}
