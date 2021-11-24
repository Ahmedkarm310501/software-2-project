package com.mycompany.non.trivial;

import java.util.ArrayList;
import java.util.Scanner;

public class driver extends person {
    private driverdata driverdata=new driverdata();
    private String driving_licence;
    private String national_id;

    public driverdata getDriverdata() {
        return driverdata;
    }

    public void setDriverdata(driverdata driverdata) {
        this.driverdata = driverdata;
    }
//    private ArrayList<ride> all_requests = new ArrayList();
//    private ArrayList<ride> requests_in_favourites = new ArrayList();
//    private ArrayList<String> favourite_areas = new ArrayList();
//    private ArrayList<ride> accepted_offers = new ArrayList();
//    private ArrayList<Float> users_rating = new ArrayList();
    private ride ride;

//    public ArrayList<Float> getUsers_rating() {
//        return users_rating;
//    }
//
//    public void setUsers_rating(ArrayList<Float> users_rating) {
//        this.users_rating = users_rating;
//    }
//
//    public ArrayList<ride> getAccepted_offers() {
//        return accepted_offers;
//    }
//
//    public void setAccepted_offers(ArrayList<ride> accepted_offers) {
//        this.accepted_offers = accepted_offers;
//    }
//
//    public ArrayList<ride> getRequests_in_favourites() {
//        return requests_in_favourites;
//    }
//
//    public void setRequests_in_favourites(ArrayList<ride> requests_in_favourites) {
//        this.requests_in_favourites = requests_in_favourites;
//    }
//
//    public ArrayList<ride> getAll_requests() {
//        return all_requests;
//    }
//
//    public void setAll_requests(ArrayList<ride> all_requests) {
//        this.all_requests = all_requests;
//    }

    public driver(String driving_licence, String national_id, String username, String password, String number, String email, system system) {
        super(username, password, number, email, system);
        this.driving_licence = driving_licence;
        this.national_id = national_id;
    }

    public String getDriving_licence() {
        return driving_licence;
    }

    public void setDriving_licence(String driving_licence) {
        this.driving_licence = driving_licence;
    }

    public String getNational_id() {
        return national_id;
    }

    public void setNational_id(String national_id) {
        this.national_id = national_id;
    }
//
//    public ArrayList<String> getFavourite_areas() {
//        return favourite_areas;
//    }
//
//    public void setFavourite_areas(ArrayList<String> favourite_areas) {
//        this.favourite_areas = favourite_areas;
//    }

    public void show_all_requests(String type) {
        if (!this.driverdata.getAll_requests().isEmpty()) {
            int counter = 1;
            if (type.equals("all")) {
                for (ride ride : this.driverdata.getAll_requests()) {
                    System.out.println("===============================================");
                    System.out.println("request " + counter + " by user " + ride.getUser().getUsername());
                    System.out.println(" from " + ride.getSource() + " to " + ride.getDestenation());
                    System.out.println("===============================================");
                    counter++;
                }
            } else if (type.equals("favourite")) {
                for (ride ride : this.driverdata.getRequests_in_favourites()) {
                    if (this.driverdata.getFavourite_areas().contains(ride.getSource())) {
                        System.out.println("===============================================");
                        System.out.println("request " + counter + " by user " + ride.getUser().getUsername());
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
                int choic = input.nextInt();
                add_offer(choic,type);
            } else if (choice.equals("2")) {
                system.getMenu().driver_menu(this);
            } else {
                System.out.println("wrong choice");
                show_all_requests(type);
            }
        } else {
            System.out.println("there id no requests");
            system.getMenu().driver_menu(this);
        }

    }



    public void add_offer(int ride_number,String type) {
        if(type.equals("all")){
            ride = this.driverdata.getAll_requests().get(ride_number - 1);
        }else if(type.equals("favourite")){
            ride = this.driverdata.getRequests_in_favourites().get(ride_number - 1);
        }
        System.out.println("Enter suggested price");
        Scanner input = new Scanner(System.in);
        float suggested_price = input.nextFloat();
        /////////////////////////////////
        offer new_offer = new offer(suggested_price, this, this.ride.getUser());
        ArrayList<offer> offers = this.ride.getOffers();
        offers.add(new_offer);
        this.ride.setOffers(offers);

        System.out.println("please wait user to accept your offer");
        String message = "You have new offers";
        this.ride.getUser().notifications.getNotification().add(message);
        system.getMenu().driver_menu(this);

    }

    public void add_requset(ride ride) {
        this.driverdata.getAll_requests().add(ride);
    }

    public void show_users_rating() {
        for (ride rate : this.driverdata.getAccepted_offers()) {
            System.out.println("User " + rate.getUser().getUsername() + " rating : " + rate.getRate());
        }
        system.getMenu().driver_menu(this);
    }

    public float averege_rating() {
        float avg = 0;
        for (ride rate : this.driverdata.getAccepted_offers()) {
            avg += rate.getRate();
        }
        avg = avg / this.driverdata.getAccepted_offers().size();
        return avg;
    }

    public void add_favourite_area() {
        System.out.println("enter area name");
        Scanner in = new Scanner(System.in);
        String name = in.next();
        this.driverdata.getFavourite_areas().add(name);
    }

}
