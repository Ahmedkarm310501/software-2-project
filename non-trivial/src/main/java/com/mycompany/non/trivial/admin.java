package com.mycompany.non.trivial;

import java.util.ArrayList;

public class admin {

    private String ID;
    private String password;
    private ArrayList<driver> pending_drivers = new ArrayList();
//    private ArrayList<person> person = new ArrayList();
    private ArrayList<person> suspended_users = new ArrayList();

    public ArrayList<person> getSuspended_users() {
        return suspended_users;
    }

    public void setSuspended_users(ArrayList<person> suspended_users) {
        this.suspended_users = suspended_users;
    }

    //private menu menu;
    private system system;

    public system getSystem() {
        return system;
    }

    public void setSystem(system system) {
        this.system = system;
    }

    public admin() {
        this.ID = "111";
        this.password = "111";
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<driver> getPending_drivers() {
        return pending_drivers;
    }

    public void setPending_drivers(ArrayList<driver> pending_drivers) {
        this.pending_drivers = pending_drivers;
    }

//    public ArrayList<person> getPerson() {
//        return person;
//    }
//
//    public void setPerson(ArrayList<person> person) {
//        this.person = person;
//    }

    public void suspend_driver(driver person) {
        person.setStatus(false);
        this.pending_drivers.add(person);
    }

    public void list_suspended_drivers() {
        int counter = 1;
        for (driver driver : pending_drivers) {
            System.out.println("User " + counter + "-->" + driver.getEmail());
            counter++;
        }
        this.system.getMenu().admin_panal();

    }

    public void activate_driver(String email) {
        for (driver driver : pending_drivers) {
            if (driver.getEmail().equals(email)) {
                driver.setStatus(true);
                this.pending_drivers.remove(driver);
                System.out.println("User activated");
                this.system.getMenu().admin_panal();
            }
        }
        System.out.println("wrong email");
        this.system.getMenu().admin_panal();
    }

    public void suspend_person(String email) {
        for (user user :system.getUsers() ){
            if(user.getEmail().equals(email)){
                this.suspended_users.add(user);
                user.setStatus(false);
                System.out.println("User Suspended");
                system.getMenu().admin_panal();
            }
        }
        for (driver driver :system.getDrivers() ){
            if(driver.getEmail().equals(email)){
                this.suspended_users.add(driver);
                driver.setStatus(false);
                System.out.println("User Suspended");
                system.getMenu().admin_panal();
            }
        }
        System.out.println("User not found");
        system.getMenu().admin_panal();
    }

    public void list_suspended_users() {
        int counter = 1;
        for (person person : suspended_users) {
            System.out.println("User " + counter + "-->" + person.getEmail());
            counter++;
        }
        system.getMenu().admin_panal();

    }

    public void activate_user(String email) {
        for (person person : suspended_users) {
            if (person.getEmail().equals(email)) {
                person.setStatus(true);
                this.suspended_users.remove(person);
                System.out.println("User activated");
                this.system.getMenu().admin_panal();
            }
        }
        System.out.println("wrong email");
        this.system.getMenu().admin_panal();
    }
}
