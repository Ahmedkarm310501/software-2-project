package com.mycompany.non.trivial;

public class main {
    public static void main(String[]args){
        menu menu=new menu();
        admin admin = new admin();
        system system=new system(menu,admin);
        admin.setSystem(system);
        menu.setSystem(system);
        ////////////////////////////////////////
//        user user1=new user("a","a","a","a",system);
//        user user2=new user("b","b","b","b",system);
//        user user3=new user("c","c","c","c",system);
//        system.getUsers().add(user1);
//        system.getUsers().add(user2);
//        system.getUsers().add(user3);
//        driver driver1=new driver("s","s","s","s","s","s",system);
//        driver driver2=new driver("z","z","z","z","z","z",system);
//        driver driver3=new driver("x","x","x","x","x","x",system);
//        system.getDrivers().add(driver1);
//        system.getDrivers().add(driver2);
//        system.getDrivers().add(driver3);
        
        ////////////////////////////////////////
        menu.main_menu();
    }
}
