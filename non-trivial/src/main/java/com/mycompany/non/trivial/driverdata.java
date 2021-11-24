package com.mycompany.non.trivial;

import java.util.ArrayList;

public class driverdata implements database{

    private ArrayList<ride> all_requests = new ArrayList();
    private ArrayList<ride> requests_in_favourites = new ArrayList();
    private ArrayList<String> favourite_areas = new ArrayList();
    private ArrayList<ride> accepted_offers = new ArrayList();
    private ArrayList<Float> users_rating = new ArrayList();
    
    public ArrayList<ride> getAll_requests() {
        return all_requests;
    }

    public void setAll_requests(ArrayList<ride> all_requests) {
        this.all_requests = all_requests;
    }

    public ArrayList<ride> getRequests_in_favourites() {
        return requests_in_favourites;
    }

    public void setRequests_in_favourites(ArrayList<ride> requests_in_favourites) {
        this.requests_in_favourites = requests_in_favourites;
    }

    public ArrayList<String> getFavourite_areas() {
        return favourite_areas;
    }

    public void setFavourite_areas(ArrayList<String> favourite_areas) {
        this.favourite_areas = favourite_areas;
    }

    public ArrayList<ride> getAccepted_offers() {
        return accepted_offers;
    }

    public void setAccepted_offers(ArrayList<ride> accepted_offers) {
        this.accepted_offers = accepted_offers;
    }

    public ArrayList<Float> getUsers_rating() {
        return users_rating;
    }

    public void setUsers_rating(ArrayList<Float> users_rating) {
        this.users_rating = users_rating;
    }

}
