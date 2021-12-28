
package com.mycompany.non.trivial;

import java.util.ArrayList;

public class ride {
    private String source;
    private String destenation;
    private float price;
    private user user;
    private boolean status=false;
    private float rate;
    private driver driver;
    private ArrayList<offer> offers = new ArrayList();
    private ArrayList<event> events = new ArrayList();

    public ArrayList<event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<event> events) {
        this.events = events;
    }
    public ride() {
    }
    
    public ride(String source, String destenation) {
        this.source = source;
        this.destenation = destenation;
    }
        
    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



    public ArrayList<offer> getOffers() {
        return offers;
    }

    public void setOffers(ArrayList<offer> offers) {
        this.offers = offers;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public driver getDriver() {
        return driver;
    }

    public void setDriver(driver driver) {
        this.driver = driver;
    }



   

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestenation() {
        return destenation;
    }

    public void setDestenation(String destenation) {
        this.destenation = destenation;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

//    public void request_aride(user user, String source, String destination) {
//
//        ride ride = new ride(source, destination);
//        ride.setUser(user);
//        for (driver driver : user.system.getData().getDrivers()) {
//            driver.add_requset(ride);
//            if (driver.getDriverdata().getFavourite_areas().contains(source)) {
//                driver.getDriverdata().getRequests_in_favourites().add(ride);///////new
//                String message = " you have a request for one of your favourite areas (" + source + ")";
//                driver.getNotifications().getNotification().add(message);
//            }
//        }
//        System.out.println("request added please wait any driver to accept your request");
//    }

}
