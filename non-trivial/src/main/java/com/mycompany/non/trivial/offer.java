package com.mycompany.non.trivial;

public class offer {
    private float suggested_price;
    private driver driver;
    private user user;

    public offer() {

    }

    public offer(float suggested_price, driver driver, user user) {
        this.suggested_price = suggested_price;
        this.driver = driver;
        this.user = user;
    }

    public float getSuggested_price() {
        return suggested_price;
    }

    public void setSuggested_price(float suggested_price) {
        this.suggested_price = suggested_price;
    }

    public driver getDriver() {
        return driver;
    }

    public void setDriver(driver driver) {
        this.driver = driver;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }



}
