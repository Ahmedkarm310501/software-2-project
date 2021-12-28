
package com.mycompany.non.trivial;

import java.util.ArrayList;

public class systemdata {
    private ArrayList<user> users = new ArrayList();
    private ArrayList<driver> drivers = new ArrayList();

    public systemdata() {
    }

    public ArrayList<user> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<user> users) {
        this.users = users;
    }

    public ArrayList<driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<driver> drivers) {
        this.drivers = drivers;
    }
    
}
