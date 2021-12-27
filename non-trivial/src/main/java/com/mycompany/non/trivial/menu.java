package com.mycompany.non.trivial;

import java.util.Scanner;

public class menu {

    private system system;


    public menu() {
    }

    public system getSystem() {
        return system;
    }

    public void setSystem(system system) {
        this.system = system;
    }

    public menu(system system) {
        this.system = system;
    }

    public void user_menu(user user) {
        if (!user.getNotifications().getNotification().isEmpty()) {
            System.out.println("you have " + user.notifications.getNotification().size() + " offers");
        } else {
            System.out.println("you have no notify");
        }
        System.out.println("hello " + user.getUsername());
        System.out.println("user menu");
        System.out.println("1-logut");
        System.out.println("2-request aride");
        System.out.println("3-show offers ");
        Scanner input = new Scanner(System.in);
        String in = input.next();
        if (in.equals("1")) {
            system.logout();
        } else if (in.equals("2")) {
            System.out.println("enter Source");
            String source = input.next();
            System.out.println("enter destenation");
            String destenation = input.next();
            user.request_aride(source, destenation);
            user_menu(user);

        } else if (in.equals("3")) {
            user.show_offers();
            user_menu(user);//delete
        } else {
            System.out.println("wrong choice");
            user_menu(user);
        }
    }

    public void driver_menu(driver driver) {
        if (!driver.getNotifications().getNotification().isEmpty()) {
            System.out.println("you have " + driver.notifications.getNotification().size() + " notifications");
        } else {
            System.out.println("you have no notify");
        }
        System.out.println("hello " + driver.getUsername());
        System.out.println("driver menu");
        System.out.println("1-logut");
        System.out.println("2-show all requests");
        System.out.println("3-show notificatoins");
        System.out.println("4-show users rating");
        System.out.println("5-add favourite area");
        System.out.println("6-show all requests for favourite areas");
        Scanner input = new Scanner(System.in);
        String in = input.next();
        if (in.equals("1")) {
            system.logout();
        } else if (in.equals("2")) {
            driver.show_all_requests("all");
        } else if (in.equals("3")) {
            driver.getNotifications().show_noitifications();
            driver_menu(driver);
        }
        else if (in.equals("4")) {
            driver.show_users_rating();
            driver_menu(driver);
        }else if (in.equals("5")) {
            driver.add_favourite_area();
            driver_menu(driver);
        }else if (in.equals("6")) {
            driver.show_all_requests("favourite");
            driver_menu(driver);
        }
        else {
            System.out.println("wrong choice");
            driver_menu(driver);
        }
    }

    public void main_menu() {
        System.out.println("1-login");
        System.out.println("2-register");
        System.out.println("3-admin panel");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 2) {
            system.register();
        } else if (choice == 1) {
            system.login();
        } else if (choice == 3) {
            login_admin();
        } else {
            System.out.println("worng choice");
            main_menu();
        }
    }

    public void login_admin() {
        Scanner input = new Scanner(System.in);
        System.out.println("enter ID");
        String ID = input.next();
        System.out.println("enter password");
        String password = input.next();
        if (this.system.getAdminuser().getID().equals(ID) && this.system.getAdminuser().getPassword().equals(password)) {
            admin_panal();
        } else {
            System.out.println("wrong data");
            main_menu();
        }

    }

    public void admin_panal() {
        System.out.println("in admin panel");
        System.out.println("1-logut");
        System.out.println("2-list susbended drivers");
        System.out.println("3-Activate New drivers");
        System.out.println("4-list susbended users");
        System.out.println("5-Suspend user");
        System.out.println("6-Activate User");
        Scanner input = new Scanner(System.in);
        String in = input.next();
        if (in.equals("1")) {
            system.logout();
        } else if (in.equals("2")) {
            system.getAdminuser().list_suspended_drivers();
        } else if (in.equals("3")) {
            System.out.println("enter driver email");
            String email = input.next();
            system.getAdminuser().activate_driver(email);
        } else if (in.equals("4")) {
            system.getAdminuser().list_suspended_users();
        } else if (in.equals("5")) {
            System.out.println("enter user email");
            String email = input.next();
            system.getAdminuser().suspend_person(email);
        } else if (in.equals("6")) {
            System.out.println("enter user email");
            String email = input.next();
            system.getAdminuser().activate_user(email);
        } else {
            System.out.println("wrong choice");
            admin_panal();
        }
    }
}
