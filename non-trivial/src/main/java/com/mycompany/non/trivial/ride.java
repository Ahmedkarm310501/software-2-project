
package com.mycompany.non.trivial;

import java.util.ArrayList;

public class ride {
    private String source;
    private String destenation;
    private float price;
    private user user;
    private boolean status=false;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    private driver driver;//list of drivers
    private ArrayList<offer> offers = new ArrayList();
//    private ArrayList<ride> all_requests= new ArrayList(); 

//    private offer offer;

    public ArrayList<offer> getOffers() {
        return offers;
    }

    public void setOffers(ArrayList<offer> offers) {
        this.offers = offers;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public driver getDriver() {
        return driver;
    }

    public void setDriver(driver driver) {
        this.driver = driver;
    }

//    public ArrayList<ride> getAll_requests() {
//        return all_requests;
//    }
//
//    public void setAll_requests(ArrayList<ride> all_requests) {
//        this.all_requests = all_requests;
//    }

    //-rate:float

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestenation() {
        return destenation;
    }

    public void setDestenation(String destenation) {
        this.destenation = destenation;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public ride(String source, String destenation) {
        this.source = source;
        this.destenation = destenation;
    }
//    public void add_requset(ride ride){
//        this.all_requests.add(ride);
//        System.out.println("size of requests in ride "+this.all_requests.size());
//    }
    
//    public void add_offer(float price){
//        offer new_offer =new offer();
//        this.offers.add(new_offer);
//        new_offer.setSuggested_price(price);
//    }
}
