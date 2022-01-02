package com.mycompany.non.trivial;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    //system//
    admin admin;
    system system;

    public main() {
        admin = new admin();
        system = new system(admin);
        admin.setSystem(system);
    }

    public void register() {
        System.out.println("choose from the following");
        System.out.println("1-User");
        System.out.println("2-Driver");
        System.out.println("3-go back");
        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();
        if (choice == 1) {
            String username, password, number, email, birthday;
            System.out.println("enter username");
            username = input.next();
            System.out.println("enter password");
            password = input.next();
            System.out.println("enter number");
            number = input.next();
            System.out.println("enter email");
            email = input.next();
            System.out.println("enter Brithday in format dd-MM");
            birthday = input.next();

            for (user per : system.getData().getUsers()) {
                if (per.getEmail().equals(email)) {
                    System.out.println("this user already exist enter another email");
                    register();
                }
            }

            user User = new user(username, password, number, email, birthday, system);
            system.getData().getUsers().add(User);
            System.out.println("User added please login");
            main_menu();
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
            for (driver per : system.getData().getDrivers()) {
                if (per.getEmail().equals(email)) {
                    System.out.println("this user already exist enter another email");
                    register();
                }
            }

            driver driver = new driver(username, password, number, email, driving_licence, national_id, system);
            this.system.getAdminuser().suspend_driver(driver);
            system.getData().getDrivers().add(driver);
            System.out.println("registeration success please wait until admin activate you");
            main_menu();
        } else if (choice == 3) {
            main_menu();
        }

    }

    public void login() {
        Scanner input = new Scanner(System.in);
        System.out.println("choose from the following");
        System.out.println("1-Login as User");
        System.out.println("2-Login as Driver");
        String choice = input.next();
        if (!(choice.equals("1") || choice.equals("2"))) {
            System.out.println("wrong choice");
            main_menu();
        }
        String email, password;
        System.out.println("enter email");
        email = input.next();
        System.out.println("enter password");
        password = input.next();
        if (choice.equals("1")) {
            for (user user : system.getData().getUsers()) {
                if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                    if (user.isStatus()) {
                        user_menu(user);
                    } else {
                        System.out.println("you are susbended");
                        main_menu();
                    }

                }

            }
            System.out.println("wrong data");
            main_menu();
        } else if (choice.equals("2")) {
            for (driver driver : system.getData().getDrivers()) {
                if (driver.getEmail().equals(email) && driver.getPassword().equals(password)) {
                    if (driver.isStatus()) {
                        driver_menu(driver);
                    } else {
                        System.out.println("you are susbended");
                        main_menu();
                    }
                }
            }
            System.out.println("wrong data");
            main_menu();
        } else {
            System.out.println("wrong choice");
            main_menu();
        }
    }

    public void logout() {
        main_menu();

    }
    /////////

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
        System.out.println("4-deposit");
        System.out.println("5-check balance");
        System.out.println("6-request multiple_ride");
        Scanner input = new Scanner(System.in);
        String in = input.next();
        if (in.equals("1")) {
            logout();
        } else if (in.equals("2")) {
            System.out.println("enter Source");
            String source = input.next();
            System.out.println("enter destenation");
            String destenation = input.next();
//            System.out.println("enter Number of Passengers");
//            int passenger_num = input.nextInt();
            request_aride(source, destenation, user);
            user_menu(user);

        } else if (in.equals("3")) {
            show_offers(user);
            user_menu(user);
        } else if (in.equals("4")) {
            System.out.println("enter ammount ");
            float ammount = input.nextFloat();
            deposit(ammount, user);
            user_menu(user);
        } else if (in.equals("5")) {
            System.out.println("your balance is " + user.getBalance());
            user_menu(user);
        } else if (in.equals("6")) {
            System.out.println("enter Source");
            String source = input.next();
            System.out.println("enter destenation");
            String destenation = input.next();
            System.out.println("enter Number of Passengers");
            int passenger_num = input.nextInt();
            request_aride2(source, destenation, user, passenger_num);
            user_menu(user);

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
        System.out.println("7-deposit");
        System.out.println("8-check balance");
        System.out.println("9-set current location");
        System.out.println("10-set Available seats");
        Scanner input = new Scanner(System.in);
        String in = input.next();
        if (in.equals("1")) {
            logout();
        } else if (in.equals("2")) {
            show_all_requests("all", driver);
        } else if (in.equals("3")) {
            driver.getNotifications().show_noitifications();
            driver_menu(driver);
        } else if (in.equals("4")) {
            show_users_rating(driver);
            driver_menu(driver);
        } else if (in.equals("5")) {
            add_favourite_area(driver);
            driver_menu(driver);
        } else if (in.equals("6")) {
            show_all_requests("favourite", driver);
            driver_menu(driver);
        } else if (in.equals("7")) {
            System.out.println("enter ammount ");
            float ammount = input.nextFloat();
            deposit(ammount, driver);
            driver_menu(driver);
        } else if (in.equals("8")) {
            System.out.println("your balance is " + driver.getBalance());
            driver_menu(driver);
        } else if (in.equals("9")) {
            System.out.println("enter current location ");
            String location = input.next();
            setCurrent_location(location, driver);
            driver_menu(driver);
        } else if (in.equals("10")) {
            System.out.println("enter available seats ");
            int seats = input.nextInt();
            setAvailableSeats(seats, driver);
            driver_menu(driver);
        } else {
            System.out.println("wrong choice");
            driver_menu(driver);
        }
    }

    public void main_menu() {
        System.out.println("1-login");
        System.out.println("2-register");
        System.out.println("3-admin panel");

        Scanner input = new Scanner(System.in);
        String choice = input.next();
        if (choice.equals("2")) {
            register();
        } else if (choice.equals("1")) {
            login();
        } else if (choice.equals("3")) {
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
        System.out.println("7-Show all rides");
        System.out.println("8-show event on ride");
        System.out.println("9-add discount area ");
        System.out.println("10-show discount areas");
        System.out.println("11-add public holiday Date");
        System.out.println("12-show public holiday Date");
        Scanner input = new Scanner(System.in);
        String in = input.next();
        if (in.equals("1")) {
            logout();
        } else if (in.equals("2")) {
            list_suspended_drivers();
        } else if (in.equals("3")) {
            System.out.println("enter driver email");
            String email = input.next();
            activate_driver(email);
        } else if (in.equals("4")) {
            list_suspended_users();
        } else if (in.equals("5")) {
            System.out.println("enter user email");
            String email = input.next();
            suspend_person(email);
        } else if (in.equals("6")) {
            System.out.println("enter user email");
            String email = input.next();
            activate_user(email);
        } else if (in.equals("7")) {
            get_all_rides();

        } else if (in.equals("8")) {
            System.out.println("enter ride number");
            int ride_number = input.nextInt();
            show_events_on_ride(ride_number);
        } else if (in.equals("9")) {
            System.out.println("enter area");
            String area = input.next();
            add_discount_area(area);
        } else if (in.equals("10")) {
            show_discount_areas();
        } else if (in.equals("11")) {
            System.out.println("enter date");
            String date = input.next();
            add_discount_Holiday(date);
        } else if (in.equals("12")) {
            show_discount_Holiday();
        } else {
            System.out.println("wrong choice");
            admin_panal();
        }
    }

    ////////////////admin///////////////////
    public void list_suspended_drivers() {
        int counter = 1;
        for (driver driver : this.admin.getAdmindata().getPending_drivers()) {
            System.out.println("User " + counter + "-->" + driver.getEmail());
            counter++;
        }
        admin_panal();
    }

    public void activate_driver(String email) {
        boolean a = admin.activate_driver(email);

        if (a) {
            System.out.println("User activated");
        } else {
            System.out.println("wrong email");
        }
        admin_panal();
    }

    public void suspend_person(String email) {
        boolean a = admin.suspend_person(email);
        if (a) {
            System.out.println("User Suspended");
        } else {
            System.out.println("User not found");
        }
        admin_panal();
    }

    public void list_suspended_users() {
        int counter = 1;
        for (person person : this.admin.getAdmindata().getSuspended_users()) {
            System.out.println("User " + counter + "-->" + person.getEmail());
            counter++;
        }
        admin_panal();
    }

    public void activate_user(String email) {
        boolean a = admin.activate_user(email);
        if (a) {
            System.out.println("User activated");
        } else {
            System.out.println("wrong email");
        }
        admin_panal();
    }

    public void get_all_rides() {
        int counter = 1;
        for (ride ride : this.admin.getAdmindata().getAll_rides()) {
            if (ride instanceof Mulit_ride) {
                System.out.print("Ride " + counter + "by user " + ride.getUsers().get(0).getUsername());
            } else {
                System.out.print("Ride " + counter + "by user " + ride.getUser().getUsername());

            }

            if (ride.getDriver() != null) {
                System.out.print(" from driver " + ride.getDriver().getUsername());
            } else {
                System.out.print(" no driver until now ");
            }
            System.out.println(" from " + ride.getSource() + " to " + ride.getDestenation());
            counter++;
        }
        admin_panal();
    }

    public void show_events_on_ride(int ride_number) {
        int counter = 1;
        for (event event : this.admin.getAdmindata().getAll_rides().get(ride_number - 1).getEvents()) {
            if (event.getName().equals("Driver put a price")) {
                System.out.println("event " + counter + event.getName() + " event time " + event.getTime()
                        + " from driver " + event.getDriver_name() + " price " + event.getPrice());
            } else if (event.getName().equals("User accepts the driver price")) {
                System.out.println("event " + counter + event.getName() + " event time " + event.getTime()
                        + "User Name " + event.getUser_name());

            } else if (event.getName().equals("Captain arrived to user location")) {
                System.out.println("event " + counter + event.getName() + " event time " + event.getTime()
                        + " Driver " + event.getDriver_name() + " User name " + event.getUser_name());

            } else if (event.getName().equals("Captain arrived to user destination")) {
                System.out.println("event " + counter + event.getName() + " event time " + event.getTime()
                        + " Driver " + event.getDriver_name() + " User name " + event.getUser_name());
            }
            counter++;
        }
        admin_panal();
    }

    void add_discount_area(String area) {
        this.admin.getAdmindata().getAdmin_discount_areas().add(area);
        System.out.println(area + " is added to discounts areas ");
        admin_panal();
    }

    void show_discount_areas() {
        System.out.print("[ ");
        for (String area : admin.getAdmindata().getAdmin_discount_areas()) {
            System.out.print(area + " , ");
        }
        System.out.println("]");
        admin_panal();
    }

    void add_discount_Holiday(String date) {
        this.admin.getAdmindata().getPublic_holiday().add(date);
        System.out.println(date + " is added to discounts dates ");
        admin_panal();
    }

    void show_discount_Holiday() {
        System.out.print("[ ");
        for (String date : admin.getAdmindata().getPublic_holiday()) {
            System.out.print(date + " , ");
        }
        System.out.println("]");
        admin_panal();
    }

    //////////////////////////////////
    /////////driver/////////////////
    public void show_all_requests(String type, driver driver) {
        if (!driver.getDriverdata().getAll_requests().isEmpty()) {
            int counter = 1;
            if (type.equals("all")) {
                for (ride ride : driver.getDriverdata().getAll_requests()) {
                    System.out.println("===============================================");
                    if (ride instanceof Mulit_ride) {
                        System.out.println("request " + counter + " by user " + ride.getUsers().get(0).getUsername() + "number of user" + ride.getPassenger_num());
                    } else {
                        System.out.println("request " + counter + " by user " + ride.getUser().getUsername() + "number of user" + ride.getPassenger_num());

                    }

                    System.out.println(" from " + ride.getSource() + " to " + ride.getDestenation());
                    System.out.println("===============================================");
                    counter++;
                }
            } else if (type.equals("favourite")) {
                for (ride ride : driver.getDriverdata().getRequests_in_favourites()) {
                    if (driver.getDriverdata().getFavourite_areas().contains(ride.getSource())) {
                        System.out.println("===============================================");
                        if (ride instanceof Mulit_ride) {
                            System.out.println("request " + counter + " by user " + ride.getUsers().get(0).getUsername() + "number of user" + ride.getPassenger_num());
                        } else {
                            System.out.println("request " + counter + " by user " + ride.getUser().getUsername() + "number of user" + ride.getPassenger_num());

                        }
                        System.out.println(" from " + ride.getSource() + " to " + ride.getDestenation());
                        System.out.println("===============================================");
                        counter++;
                    }
                }
            }

            System.out.println("=======================================================");
            System.out.println("1-choose aride");
            System.out.println("2-go back");
            Scanner input = new Scanner(System.in);
            String choice = input.next();
            if (choice.equals("1")) {
                System.out.println("enter ride number ");
                try {
                    int choic = input.nextInt();
                    add_offer(choic, type, driver);
                } catch (InputMismatchException e) {
                    System.out.println("wrong choice");
                    show_all_requests(type, driver);

                }

            } else if (choice.equals("2")) {
                driver_menu(driver);
            } else {
                System.out.println("wrong choice");
                show_all_requests(type, driver);
            }
        } else {
            System.out.println("there id no requests");
            driver_menu(driver);
        }

    }

    public void add_offer(int ride_number, String type, driver driver) {
        if (ride_number > driver.getDriverdata().getAll_requests().size() || ride_number - 1 < 0) {//////////
            System.out.println("wrong choice ");
            show_all_requests(type, driver);///////////////////

        }
        if (type.equals("all")) {
            driver.setRide(driver.getDriverdata().getAll_requests().get(ride_number - 1));

        } else if (type.equals("favourite")) {
            driver.setRide(driver.getDriverdata().getRequests_in_favourites().get(ride_number - 1));
        }
        System.out.println("Enter suggested price");
        Scanner input = new Scanner(System.in);
        float suggested_price = input.nextFloat();
        /////////////////////////////////
        offer new_offer = null;
        if (driver.getRide() instanceof Mulit_ride) {
            new_offer = new offer(suggested_price, driver, driver.getRide().getUsers().get(0));
        } else {
            new_offer = new offer(suggested_price, driver, driver.getRide().getUser());

        }
        ArrayList<offer> offers = driver.getRide().getOffers();
        offers.add(new_offer);
        driver.getRide().setOffers(offers);
        driver.setAvalibilty(false);
        ////////////////////////////////////////////////////////////
        String event_name = "Driver put a price";
        String event_time = get_time();
        ride ride = driver.getDriverdata().getAll_requests().get(ride_number - 1);
        event event = null;
        if (driver.getRide() instanceof Mulit_ride) {
            event = new event(event_name, event_time, ride, driver.getUsername(), ride.getUsers().get(0).getUsername(), suggested_price);
        } else {
            event = new event(event_name, event_time, ride, driver.getUsername(), ride.getUser().getUsername(), suggested_price);

        }
        int index = system.getAdminuser().getAdmindata().getAll_rides().indexOf(ride);

        system.getAdminuser().getAdmindata().getAll_rides().get(index).getEvents().add(event);

        System.out.println("please wait user to accept your offer");
        String message = "You have new offers";
        if (driver.getRide() instanceof Mulit_ride) {
            for (user user : ride.getUsers()) {
                user.notifications.getNotification().add(message);
            }
        } else {
            driver.getRide().getUser().notifications.getNotification().add(message);
        }

        driver_menu(driver);
    }

    public void show_users_rating(driver driver) {

        for (ride rate : driver.getDriverdata().getAccepted_offers()) {
            if (driver.getRide() instanceof Mulit_ride) {
                System.out.println("User " + rate.getUsers().get(0).getUsername() + " rating : " + rate.getRate());
            } else {
                System.out.println("User " + rate.getUser().getUsername() + " rating : " + rate.getRate());
            }
        }
        driver_menu(driver);
    }

    public void add_favourite_area(driver driver) {
        System.out.println("enter area name");
        Scanner in = new Scanner(System.in);
        String name = in.next();
        driver.add_favourite_area(name);
    }

    public void deposit(float ammount, person person) {
        person.deposit(ammount);
        System.out.println("your balance now is " + person.getBalance());
    }

    public void setCurrent_location(String location, driver driver) {
        driver.setCuurent_location(location);

    }

    public void setAvailableSeats(int seats, driver driver) {
        driver.setAvailable_seats(seats);
    }

    ////////////////////////////////
    /////////user//////////////////
    public void request_aride(String source, String destination, user user) {
        user.ride = new Single_ride(source, destination);
        if (user.getRide().request_aride(source, destination, user, 1)) {
            System.out.println("request added please wait any driver to accept your request");
        } else {
            System.out.println("No driver in this source area");
        }
    }

    public void request_aride2(String source, String destination, user user, int num) {
        user.ride = new Mulit_ride(source, destination, num);
        if (user.getRide().request_aride(source, destination, user, num)) {
            System.out.println("request added please wait any driver to accept your request");
        } else {
            System.out.println("No driver in this source area");
        }
    }


    /* public void check_balance(user user, offer offer, double offer_num) {
        if (user.getBalance() >= offer.getSuggested_price()) {
            offer.setSuggested_price(offer.getSuggested_price() - offer.getSuggested_price() * offer_num);
            System.out.println("suggested price is " + offer.getSuggested_price() + "L.E");
        } else {
            offer.setSuggested_price(offer.getSuggested_price());
            System.out.println("suggested price is " + (offer.getSuggested_price() - offer.getSuggested_price() * offer_num) + "L.E");
            
        }

    }*/
    public double offer_cases(user user, offer offer) {
        double discount = 0;
        if (user.getRides().isEmpty()) {
            //check_balance(user, offer, 0.1);
            discount += 0.1;
            System.out.println("if  1");
        }
        if (user.getRide().getPassenger_num() == 2) {
            discount += 0.05;
            System.out.println("if  2");
        }
        if (date1().equals(user.getBirthday())) {
            //check_balance(user, offer, 0.05);\
            discount += 0.1;
            System.out.println("if  3");
        }
        if ((admin.getAdmindata().getPublic_holiday()).contains(date1())) {
            discount += 0.05;
            System.out.println("if  4");
        }///////////////////////////////////////////////////////////////////////////
        if (admin.getAdmindata().getAdmin_discount_areas().contains(user.getRide().getDestenation())) {
            discount += 0.1;
            System.out.println("if  5");

        }
        return discount * offer.getSuggested_price();
    }

    public void show_offers(user user) {
        if (!user.getRide().getOffers().isEmpty()) {
            int counter = 1;
            for (offer offer : user.getRide().getOffers()) {
                System.out.println("===============================================");
                System.out.println("offer " + counter + " by driver " + offer.getDriver().getUsername());
                double total_discount = offer_cases(user, offer);
                System.out.println("suggested price is " + (offer.getSuggested_price() - total_discount) + "L.E");

//                ride r = new ride(user.getRide().getSource(), user.getRide().getDestenation(), user.getRide().getPassenger_num());
//                if (user.getBalance() >= offer.getSuggested_price()) {
//                    user.getRides().add(r);
//                }
                System.out.println("driver rating is " + offer.getDriver().averege_rating());
                System.out.println("================================================");
                counter++;
            }
            System.out.println("=======================================================");
            System.out.println("1-choose offer");
            System.out.println("2-go back");
            Scanner input = new Scanner(System.in);
            String choice = input.next();
            if (choice.equals("1")) {
                System.out.println("choose offer number");
                try {
                    int choic = input.nextInt();
                    accept_offer(choic, user);
                } catch (InputMismatchException e) {
                    System.out.println("wrong choice");
                    show_offers(user);

                }

            } else if (choice.equals("2")) {
                user_menu(user);
            } else {
                System.out.println("wrong choice");
                user_menu(user);
            }
        } else {
            System.out.println("you have no offers");
            user_menu(user);
        }

    }

    public void accept_offer(int offer_number, user user) {
        if (offer_number > user.getRide().getOffers().size() || offer_number - 1 < 0) {
            System.out.println("wrong choice ");
            show_offers(user);
        }
        double discount = offer_cases(user, user.getRide().getOffers().get(offer_number - 1));
        double ride_price = (user.getRide().getOffers().get(offer_number - 1).getSuggested_price());
        double price_after_discount = user.getRide().getOffers().get(offer_number - 1).getSuggested_price() - discount;
        if (user.getBalance() < price_after_discount) {
            System.out.println("You don't have enough money please depodit first");
            user_menu(user);
        }

        user.getRide().setDriver(user.getRide().getOffers().get(offer_number - 1).getDriver());
        ////////////
        user.getRide().getOffers().get(offer_number - 1).getFlag().add(true);
        System.out.println(user.getRide().getOffers().get(offer_number - 1).getFlag().get(0));
        int counter = 0;
//        int index
//         if(user.getRide().getOffers().isEmpty())
//         {
//             System.out.println("offer is emptyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy");
//         }

        for (int i = 0; i < user.getRide().getPassenger_num(); i++) {
            offer offer=user.getRide().getOffers().get(offer_number - 1);
            if (offer.getFlag().get(i) == true) {
                counter++;
            }

        }
        if (counter == user.getRide().getPassenger_num()) {
            user.getRide().getDriver().getDriverdata().getAccepted_offers().add(user.getRide());
            user.getRide().setStatus(true);
            user.getRide().setPrice(user.getRide().getOffers().get(offer_number - 1).getSuggested_price());
            for (offer offer : user.getRide().getOffers()) {
                offer.getDriver().setAvalibilty(true);

            }
            user.getRide().getOffers().clear();
        }
        user.setBalance(user.getBalance() - price_after_discount);
        user.getRide().getDriver().setBalance(user.getRide().getDriver().getBalance() + ride_price);

        for (driver driver : this.system.getData().getDrivers()) {
            driver.getDriverdata().getAll_requests().remove(user.getRide());
            if (driver.getDriverdata().getRequests_in_favourites().contains(user.getRide())) {
                driver.getDriverdata().getRequests_in_favourites().remove(user.getRide());
            }
        }

        user.getNotifications().getNotification().clear();
        String message = "Your offer from " + user.getUsername() + " accepted ";
        user.getRide().getDriver().notifications.getNotification().add(message);
        System.out.println("thank you for choosen us please rate the driver");
        /////////////////
        String event_name1 = "User accepts the driver price";
        String time1 = get_time();
        event event1 = new event(event_name1, time1, user.getUsername());
        int index1 = system.getAdminuser().getAdmindata().getAll_rides().indexOf(user.getRide());
        system.getAdminuser().getAdmindata().getAll_rides().get(index1).getEvents().add(event1);
        //////////////////////
        String event_name2 = "Captain arrived to user location";
        String time2 = get_time();
        event event2 = new event(event_name2, time2, user.getRide().getDriver().getUsername(), user.getUsername());
        int index2 = system.getAdminuser().getAdmindata().getAll_rides().indexOf(user.getRide());
        system.getAdminuser().getAdmindata().getAll_rides().get(index2).getEvents().add(event2);
        ////////////////////////////////////////
        String event_name3 = "Captain arrived to user destination";
        String time3 = get_time1();
        event event3 = new event(event_name3, time3, user.getRide().getDriver().getUsername(), user.getUsername());
        int index3 = system.getAdminuser().getAdmindata().getAll_rides().indexOf(user.getRide());
        system.getAdminuser().getAdmindata().getAll_rides().get(index3).getEvents().add(event3);
        rate_driver(user.getRide().getDriver(), user);
    }

    public void rate_driver(driver driver, user user) {
        System.out.println("choose rate the driver from 1 to 5 star");
        Scanner in = new Scanner(System.in);
        float rating = in.nextInt();
        if (!(rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5)) {
            rate_driver(driver, user);
        }
        user.getRide().setRate(rating);
        user_menu(user);
    }

    ///////////////////////////////
    String get_time() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        Date date = (cal.getTime());
        String d = date.toString();
        return d;
    }

    String get_time1() {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.HOUR_OF_DAY, 1);
        Date date = (cal.getTime());
        String d = date.toString();
        return d;
    }

    String date1() {
        String date = new SimpleDateFormat("dd-MM").format(new Date());
        return date;

    }

    public static void main(String[] args) {
        
        main main = new main();
        user user1=new user("a","a","a","a","1-1",main.system);
        user user2=new user("q","q","q","q","1-1",main.system);
        user user3=new user("z","z","z","z","1-1",main.system);
        
        driver driver1=new driver("s","s","s","s","s","s",main.system);
        driver driver2=new driver("d","d","d","d","d","d",main.system);
        main.system.getData().getUsers().add(user1);
        main.system.getData().getUsers().add(user2);
        main.system.getData().getUsers().add(user3);
        main.system.getData().getDrivers().add(driver1);
        main.system.getData().getDrivers().add(driver2);
        
        
        main.main_menu();
    }

}
