 package com.mycompany.non.trivial;

import java.util.ArrayList;



public class user extends person {

//    Single_ride Single_ride=new Single_ride();/////////////////
//    Mulit_ride Mulit_ride =new Mulit_ride();
    
    ride ride;
    private ArrayList<ride> rides=new ArrayList();
   // private ArrayList<Mulit_ride> m_rides=new ArrayList();

//    public ArrayList<Mulit_ride> getM_rides() {
//        return m_rides;
//    }
//
//    public void setM_rides(ArrayList<Mulit_ride> m_rides) {
//        this.m_rides = m_rides;
//    }

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

    
//    public boolean request_aride(String source, String destination) {
//
//        ride = new Single_ride(source, destination);
//        ride.getUsers().add(this);
//        system.getAdminuser().getAdmindata().getAll_rides().add(ride);
//        int driver_count=0;
//        for (driver driver : this.system.getData().getDrivers()) {
//            if(source.equals(driver.getCuurent_location())&&driver.isAvalibilty()==true){
//                driver.add_requset(ride);
//                if (driver.getDriverdata().getFavourite_areas().contains(source)) {
//                    driver.getDriverdata().getRequests_in_favourites().add(ride);
//                    String message = " you have a request for one of your favourite areas (" + source + ")";
//                    driver.getNotifications().getNotification().add(message);
//                }
//                driver_count++;
//            }
//        }
//        if(driver_count==0){
//            system.getAdminuser().getAdmindata().getAll_rides().remove(ride);
//            ride=null;
//            return false;
//        }
//        return true;
//    }
//    public boolean request_aride2(String source, String destination) {
//
//        ride = new Mulit_ride(source, destination);
//        ride.getUsers().add(this);
//        system.getAdminuser().getAdmindata().getAll_rides().add(ride);
//        int driver_count=0;
//        for (driver driver : this.system.getData().getDrivers()) {
//            if(source.equals(driver.getCuurent_location())&&driver.isAvalibilty()==true){
//                driver.add_requset(ride);
//                if (driver.getDriverdata().getFavourite_areas().contains(source)) {
//                    driver.getDriverdata().getRequests_in_favourites().add(ride);
//                    String message = " you have a request for one of your favourite areas (" + source + ")";
//                    driver.getNotifications().getNotification().add(message);
//                }
//                driver_count++;
//            }
//        }
//        if(driver_count==0){
//            system.getAdminuser().getAdmindata().getAll_rides().remove(ride);
//            ride=null;
//            return false;
//        }
//        return true;
//    }
    
    
    
    
    
    

    public ride getRide() {
        return ride;
    }

    public void setRide(ride ride) {
        this.ride = ride;
    }

    @Override
    public String toString() {
        return "user{" + '}';
    }

    
    
    

    

}
