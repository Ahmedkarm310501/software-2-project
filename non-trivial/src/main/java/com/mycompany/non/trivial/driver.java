package com.mycompany.non.trivial;

import java.util.ArrayList;
import java.util.Scanner;

public class driver extends person {

    private String driving_licence;
    private String national_id;
    private ArrayList<ride> all_requests= new ArrayList(); 
    private ArrayList<ride> requests_in_favourites = new ArrayList();
    private ArrayList<String> favourite_areas = new ArrayList();
    private ArrayList<ride> accepted_offers = new ArrayList();
    private ArrayList<String> users_rating = new ArrayList();
    private ride ride;



    public ArrayList<ride> getAccepted_offers() {
        return accepted_offers;
    }

    public void setAccepted_offers(ArrayList<ride> accepted_offers) {
        this.accepted_offers = accepted_offers;
    }

//    private menu menu;

    public ArrayList<ride> getRequests_in_favourites() {
        return requests_in_favourites;
    }

    public void setRequests_in_favourites(ArrayList<ride> requests_in_favourites) {
        this.requests_in_favourites = requests_in_favourites;
    }

    public ArrayList<ride> getAll_requests() {
        return all_requests;
    }

    public void setAll_requests(ArrayList<ride> all_requests) {
        this.all_requests = all_requests;
    }
    private float rating;


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

    public ArrayList<String> getFavourite_areas() {
        return favourite_areas;
    }

    public void setFavourite_areas(ArrayList<String> favourite_areas) {
        this.favourite_areas = favourite_areas;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public ArrayList<String> getUsers_rating() {
        return users_rating;
    }

    public void setUsers_rating(ArrayList<String> users_rating) {
        this.users_rating = users_rating;
    }



    public void show_all_requests() {
        int counter = 1;
        //المفروض اضافت ممكن المشكله في الريكويست بتاع اليوزر 
        System.out.println("size of requsts in driver "+this.all_requests.size());
        for (ride ride : this.all_requests) {
            System.out.println("==============================================="
                    + "request " + counter + "from " + ride.getSource() + "----->" + ride.getDestenation()
                    + "========================================");
        }
        System.out.println("=======================================================");
        System.out.println("1-choose aride");
        System.out.println("2-go back");
        Scanner input = new Scanner(System.in);
        String choice = input.next();
        if (choice.equals("1")) {
            System.out.println("enter ride number ");
            int choic = input.nextInt();
            add_offer(choic);
        } else if (choice.equals("2")) {
            system.getMenu().driver_menu(this);
        } else {
            System.out.println("wrong choice");
            show_all_requests();
        }
    }

    public void create_offer(float price,ride ride) {
        offer new_offer = new offer(price,this,this.ride.getUser());
        ArrayList<offer> offers=this.ride.getOffers();
        offers.add(new_offer);
        this.ride.setOffers(offers);
    }

    public void add_offer(int ride_number) {
        ride = this.all_requests.get(ride_number - 1);
        System.out.println("Enter suggested price");
        Scanner input = new Scanner(System.in);
        float suggested_price = input.nextFloat();
        create_offer(suggested_price,ride);
        System.out.println("please wait user to accept your offer");
        system.getMenu().driver_menu(this);

    }
    public void add_requset(ride ride){
        this.all_requests.add(ride);
        System.out.println("size of requests in ride "+this.all_requests.size());//delete 
    }
    
    
}
