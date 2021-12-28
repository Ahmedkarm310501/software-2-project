 package com.mycompany.non.trivial;

import java.util.ArrayList;



public class user extends person {

    ride ride=new ride();/////////////////
    private ArrayList<ride> rides=new ArrayList();
     private String birthday;


    public user() {
    }

    public user(String username, String password, String number, String email, String birthday,system system) {
        super(username, password, number, email, system);
        this.birthday=birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public ArrayList<ride> getRides() {
        return rides;
    }

    public void setRides(ArrayList<ride> rides) {
        this.rides = rides;
    }

    
    public void request_aride(String source, String destination,int number_passengers) {

        ride = new ride(source, destination,number_passengers);
        ride.setUser(this);
        system.getAdminuser().getAdmindata().getAll_rides().add(ride);
        for (driver driver : this.system.getData().getDrivers()) {
            driver.add_requset(ride);
            if (driver.getDriverdata().getFavourite_areas().contains(source)) {
                driver.getDriverdata().getRequests_in_favourites().add(ride);///////new
                String message = " you have a request for one of your favourite areas (" + source + ")";
                driver.getNotifications().getNotification().add(message);
            }
        }
    }

    public ride getRide() {
        return ride;
    }

    public void setRide(ride ride) {
        this.ride = ride;
    }

    
    

    

}
