package com.mycompany.non.trivial;

import java.util.ArrayList;
import java.util.Scanner;

public class system {
  
    private systemdata data=new systemdata();
    private menu menu;
    private admin adminuser;

    public system() {
    }


    public systemdata getData() {
        return data;
    }

    public void setData(systemdata data) {
        this.data = data;
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
        System.out.println("3-go back");
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

            for (user per : data.getUsers()) {
                if (per.getEmail().equals(email)) {
                    System.out.println("this user already exist enter another email");
                    register();
                }
            }

            user User = new user(username, password, number, email, this);
            data.getUsers().add(User);
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
            for (driver per : data.getDrivers()) {
                if (per.getEmail().equals(email)) {
                    System.out.println("this user already exist enter another email");
                    register();
                }
            }

            driver driver = new driver(username, password, number, email, driving_licence, national_id, this);
            this.adminuser.suspend_driver(driver);
            data.getDrivers().add(driver);
            System.out.println("registeration success please wait until admin activate you");
            menu.main_menu();
        }else if(choice == 3){
            menu.main_menu();
        }

    }

    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("choose from the following");
        System.out.println("1-Login as User");
        System.out.println("2-Login as Driver");
        String choice = input.next();
        if(!(choice.equals("1")||choice.equals("2"))){
            System.out.println("wrong choice");
            menu.main_menu();
        }
        String email, password;
        System.out.println("enter email");
        email = input.next();
        System.out.println("enter password");
        password = input.next();
        if (choice.equals("1")) {
            for (user user : data.getUsers()) {
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
            for (driver driver : data.getDrivers()) {
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
