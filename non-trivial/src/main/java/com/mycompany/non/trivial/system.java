package com.mycompany.non.trivial;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lenovo
 */
public class system {

    private ArrayList<user> users = new ArrayList();
    private ArrayList<driver> drivers = new ArrayList();

    private menu menu;
//    private ArrayList<person> persons = new ArrayList();
    private admin adminuser;

    public system() {
    }

    public ArrayList<user> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<user> Users) {
        this.users = Users;
    }

    public ArrayList<driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<driver> drivers) {
        this.drivers = drivers;
    }

    public system(menu menu, admin adminuser) {
        this.menu = menu;
        this.adminuser = adminuser;
    }

    public menu getMenu() {
        return menu;
    }

    public void setMenu(menu menu) {
        this.menu = menu;
    }

    public admin getAdminuser() {
        return adminuser;
    }

    public void setAdminuser(admin adminuser) {
        this.adminuser = adminuser;
    }

    public void register() {
        System.out.println("choose from the following");
        System.out.println("1-User");
        System.out.println("2-Driver");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {
            String username, password, number, email;
            System.out.println("enter username");
            username = input.next();
            System.out.println("enter password");
            password = input.next();
            System.out.println("enter number");
            number = input.next();
            System.out.println("enter email");
            email = input.next();

            for (user per : users) {
                if (per.getEmail().equals(email)) {
                    System.out.println("this user already exist enter another email");
                    register();
                }
            }

            user User = new user(username, password, number, email, this);
            users.add(User);
            System.out.println("User added please login");
            menu.main_menu();
        } else if (choice == 2) {
            String username, password, number, email, driving_licence, national_id;
            System.out.println("enter username");
            username = input.next();
            System.out.println("enter password");
            password = input.next();
            System.out.println("enter number");
            number = input.next();
            System.out.println("enter email");
            email = input.next();
            System.out.println("enter driving_licence");
            driving_licence = input.next();
            System.out.println("enter national_id");
            national_id = input.next();
            for (driver per : drivers) {
                if (per.getEmail().equals(email)) {
                    System.out.println("this user already exist enter another email");
                    register();
                }
            }

            driver driver = new driver(username, password, number, email, driving_licence, national_id, this);
            this.adminuser.suspend_driver(driver);
            drivers.add(driver);
            System.out.println("registeration success please wait until admin activate you");
            menu.main_menu();
        }

    }

    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("choose from the following");
        System.out.println("1-Login as User");
        System.out.println("2-Login as Driver");
        String choice = input.next();
        String email, password;
        System.out.println("enter email");
        email = input.next();
        System.out.println("enter password");
        password = input.next();
        if (choice.equals("1")) {
            for (user user : users) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    if (user.isStatus()) {
                        menu.user_menu(user);
                    }else{
                        System.out.println("you are susbended");
                        menu.main_menu();
                    }

                }

            }
            System.out.println("wrong data");
            menu.main_menu();
        }else if(choice.equals("2")){
            for (driver driver : drivers) {
                if (driver.getEmail().equals(email) && driver.getPassword().equals(password)) {
                    if (driver.isStatus()) {
                        menu.driver_menu(driver);
                    }else{
                        System.out.println("you are susbended");
                        menu.main_menu();
                    }
                }
            }
            System.out.println("wrong data");
            menu.main_menu();
        }else{
            System.out.println("wrong choice");
            menu.main_menu();
        }
    }

    public void logout() {
        menu.main_menu();
    }
}
