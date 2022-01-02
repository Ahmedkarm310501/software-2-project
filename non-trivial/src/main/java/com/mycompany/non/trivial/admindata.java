package com.mycompany.non.trivial;

import java.util.ArrayList;

public class admindata {

    private ArrayList<driver> pending_drivers = new ArrayList();
    private ArrayList<person> suspended_users = new ArrayList();
    private ArrayList<ride> all_rides = new ArrayList();
    private ArrayList<String> admin_discount_areas = new ArrayList();
    private ArrayList<String> public_holiday = new ArrayList();

    public ArrayList<String> getPublic_holiday() {
        return public_holiday;
    }

    public void setPublic_holiday(ArrayList<String> public_holiday) {
        this.public_holiday = public_holiday;
    }
//     public driver get_suspended_users(String email) {
//        for (person person : pending_drivers) {
//            if (== email) {
//                return person;
//            }
//
//        }
//        return null;
//
//    }
       public driver get_all_rides(String source) {
        for (driver driver : pending_drivers) {
            if (driver.getEmail() == source) {
                return driver;
            }

        }
        return null;
    }
    
    public driver get_pending_divers(String email) {
        for (driver driver : pending_drivers) {
            if (driver.getEmail() == email) {
                return driver;
            }

        }
        return null;

    }
    public void add_pending_drivers(driver driver)
    {
        this.pending_drivers.add(driver);
    
    }

    public ArrayList<String> getAdmin_discount_areas() {
        return admin_discount_areas;
    }

    public void setAdmin_discount_areas(ArrayList<String> admin_discount_areas) {
        this.admin_discount_areas = admin_discount_areas;
    }

    public ArrayList<ride> getAll_rides() {
        return all_rides;
    }

    public void setAll_rides(ArrayList<ride> all_rides) {
        this.all_rides = all_rides;
    }

    public ArrayList<driver> getPending_drivers() {
        return pending_drivers;
    }

    public void setPending_drivers(ArrayList<driver> pending_drivers) {
        this.pending_drivers = pending_drivers;
    }

    public ArrayList<person> getSuspended_users() {
        return suspended_users;
    }

    public void setSuspended_users(ArrayList<person> suspended_users) {
        this.suspended_users = suspended_users;
    }

    public admindata() {
    }

}
