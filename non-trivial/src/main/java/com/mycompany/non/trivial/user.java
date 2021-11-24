package com.mycompany.non.trivial;

import java.util.Scanner;

public class user extends person {//implements notify

    ride ride;
    

    public user(String username, String password, String number, String email, system system) {
        super(username, password, number, email, system);
    }

    public void request_aride(String source, String destination) {
        
        ride = new ride(source, destination);
        ride.setUser(this);
        for(driver driver : this.system.getDrivers()){
            driver.add_requset(ride);
        }
        System.out.println("request added please wait any driver to accept your request");
    }

    public void show_offers() {
        int counter = 1;
        for(offer offer :this.ride.getOffers()){
            System.out.println("==============================================="
                    + "offer " + counter + "by driver " + offer.getDriver().getUsername() +
                    "suggested price is " + offer.getSuggested_price()+"L.E"
                    + "========================================");
            counter++;
        }
        System.out.println("=======================================================");  
        System.out.println("1-choose offer");
        System.out.println("2-go back");
        Scanner input = new Scanner(System.in);
        String choice = input.next();
        if(choice.equals("1")){
            System.out.println("choose offer number");
            int choic = input.nextInt();
            accept_offer(choic);
            
        }else if(choice.equals("2")){
            system.getMenu().user_menu(this);
        }else{
            System.out.println("wrong choice");
            system.getMenu().user_menu(this);
        }
    }

    public void accept_offer(int offer_number){
        this.ride.setDriver(this.ride.getOffers().get(offer_number-1).getDriver());
        this.ride.getDriver().getAccepted_offers().add(ride);
        String message="Your offer from "+this.getUsername()+" accepted ";
        this.notifications.getNotification().add(message);
        //this.ride.getDriver().getNotification().add(message);
        System.out.println("please wait driver to begin your ride");
    }

}
