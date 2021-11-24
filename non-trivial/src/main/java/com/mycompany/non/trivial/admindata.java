package com.mycompany.non.trivial;

import java.util.ArrayList;

public class admindata implements database{
    private ArrayList<driver> pending_drivers = new ArrayList();
    private ArrayList<person> suspended_users = new ArrayList();

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
