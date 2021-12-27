 package com.mycompany.non.trivial;



public class user extends person {

    ride ride=new ride();/////////////////

    public user() {
    }

    public user(String username, String password, String number, String email, system system) {
        super(username, password, number, email, system);
    }

    
    public void request_aride(String source, String destination) {

        ride = new ride(source, destination);
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
