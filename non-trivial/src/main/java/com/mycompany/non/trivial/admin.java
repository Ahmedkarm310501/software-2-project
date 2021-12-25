package com.mycompany.non.trivial;

public class admin {
    private admindata admindata=new admindata();

    public admindata getAdmindata() {
        return admindata;
    }

    public void setAdmindata(admindata admindata) {
        this.admindata = admindata;
    }
    private String ID;
    private String password;
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



    public void suspend_driver(driver person) {
        person.setStatus(false);
        this.admindata.getPending_drivers().add(person);
    }

    

    public boolean activate_driver(String email) {
        for (driver driver : this.admindata.getPending_drivers()) {
            if (driver.getEmail().equals(email)) {
                driver.setStatus(true);
                this.admindata.getPending_drivers().remove(driver);
                return true;
//                this.system.getMenu().admin_panal();
            }
        }
        return false;
//        this.system.getMenu().admin_panal();
    }

    public boolean suspend_person(String email) {
        for (user user :system.getData().getUsers() ){/////////////////////////////////////////////////////
            if(user.getEmail().equals(email)){
                this.admindata.getSuspended_users().add(user);
                user.setStatus(false);
                return true;
            }
        }
        
        for (driver driver :system.getData().getDrivers() ){/////////////////////////////////////////////////////
            if(driver.getEmail().equals(email)){
                this.admindata.getSuspended_users().add(driver);
                driver.setStatus(false);
                return true;
            }
        }
        return false;
    }



    public boolean activate_user(String email) {
        for (person person : this.admindata.getSuspended_users()) {
            if (person.getEmail().equals(email)) {
                person.setStatus(true);
                this.admindata.getSuspended_users().remove(person);
                return true;
            }
        }
        return false;
    }
}
