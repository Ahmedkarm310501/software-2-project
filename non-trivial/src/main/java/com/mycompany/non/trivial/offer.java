package com.mycompany.non.trivial;

import java.util.ArrayList;

public class offer {
    private double suggested_price;
    private driver driver;
    private user user;
    private ride ride;
    

    public ride getRide() {
        return ride;
    }

    public void setRide(ride ride) {
        this.ride = ride;
    }

    public offer() {

    }

    public offer(float suggested_price, driver driver, user user) {
        this.suggested_price = suggested_price;
        this.driver = driver;
        this.user = user;
    }

    public double getSuggested_price() {

        return suggested_price;        
    }
    public void offer_cases(user user)
    {
         if(!this.ride.getOffers().contains(user.getRide().getOffers()))
        {
           suggested_price=suggested_price-suggested_price*0.1;
            System.out.println("suggested price is " + suggested_price + "L.E");
        
        }
         else
         {
            System.out.println("suggested price is " + suggested_price + "L.E");
         }
    
    }

    public void setSuggested_price(double suggested_price) {
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
