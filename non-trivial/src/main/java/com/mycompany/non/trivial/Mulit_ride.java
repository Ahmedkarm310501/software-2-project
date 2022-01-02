/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.non.trivial;

import java.util.ArrayList;

/**
 *
 * @author lap
 */
public class Mulit_ride extends ride {

    public Mulit_ride(String source, String destenation) {
        super(source, destenation);
    }

    public Mulit_ride(String source, String destenation, int num) {
        super(source, destenation);
        this.passenger_num = num;
    }

    public Mulit_ride() {
        this.source = null;
        this.destenation = null;
    }

    @Override
    public boolean request_aride(String source, String destination, user user, int num) {
        boolean flag=true;
        ride r=null;
        for (ride ride : user.system.getAdminuser().getAdmindata().getAll_rides()) {
            if (ride.getSource().equals(source) && ride.getDestenation().equals(destination) && !ride.isStatus() && ride instanceof Mulit_ride) {
                r=ride;
                user.setRide(r);
                r.getUsers().add(user);
                flag=false;
                System.out.println("ana a7aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
                break;
               // return true;
            }
        }
        if(r==null)
        {
            r=this;
        
        }
        if(flag){
            r.passenger_num = num;
                r.getUsers().add(user);
        }
        // ride ride = new Mulit_ride(source, destination);

       
        int driver_count = 0;
        if(!user.system.getAdminuser().getAdmindata().getAll_rides().contains(r))
        {
            System.out.println("a7a2222222222222222222222222222222222222222222");
           user.system.getAdminuser().getAdmindata().getAll_rides().add(r);
        }
        System.out.println("this.getUsers().size()= " + r.getUsers().size());
        System.out.println("this.passenger_num " + r.passenger_num);
        if (r.getUsers().size() == r.passenger_num) {

            for (driver driver : user.system.getData().getDrivers()) {
                if (source.equals(driver.getCuurent_location()) && driver.isAvalibilty() == true) {
                    driver.add_requset(r);
                    if (driver.getDriverdata().getFavourite_areas().contains(source)) {
                        driver.getDriverdata().getRequests_in_favourites().add(r);
                        String message = " you have a request for one of your favourite areas (" + source + ")";
                        driver.getNotifications().getNotification().add(message);
                    }
                    driver_count++;
                }

            }
            if (driver_count == 0) {
                user.system.getAdminuser().getAdmindata().getAll_rides().remove(r);
                user.setRide(null);
                return false;
            }
        }
        return true;
    }

}
