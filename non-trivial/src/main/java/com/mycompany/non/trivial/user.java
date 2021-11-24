package com.mycompany.non.trivial;

import java.util.Scanner;

public class user extends person  implements Iuser{

    ride ride;

    public user() {
    }

    public user(String username, String password, String number, String email, system system) {
        super(username, password, number, email, system);
    }

    @Override
    public void request_aride(String source, String destination) {

        ride = new ride(source, destination);
        ride.setUser(this);
        for (driver driver : this.system.getData().getDrivers()) {/////////////////////////////////////////////////////
            driver.add_requset(ride);
            if (driver.getDriverdata().getFavourite_areas().contains(source)) {
                driver.getDriverdata().getRequests_in_favourites().add(ride);///////new
                String message = " you have a request for one of your favourite areas (" + source + ")";
                driver.getNotifications().getNotification().add(message);
            }
        }
        System.out.println("request added please wait any driver to accept your request");
    }

    @Override
    public void show_offers() {
        if (!this.ride.getOffers().isEmpty()) {
            int counter = 1;
            for (offer offer : this.ride.getOffers()) {
                System.out.println("===============================================");
                System.out.println("offer " + counter + " by driver " + offer.getDriver().getUsername());
                System.out.println("suggested price is " + offer.getSuggested_price() + "L.E");
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
                int choic = input.nextInt();
                accept_offer(choic);

            } else if (choice.equals("2")) {
                system.getMenu().user_menu(this);
            } else {
                System.out.println("wrong choice");
                system.getMenu().user_menu(this);
            }
        } else {
            System.out.println("you have no offers");
            system.getMenu().user_menu(this);
        }

    }

    @Override
    public void accept_offer(int offer_number) {
        this.ride.setDriver(this.ride.getOffers().get(offer_number - 1).getDriver());
        this.ride.getDriver().getDriverdata().getAccepted_offers().add(ride);
        this.ride.setStatus(true);/////////delete
        this.ride.setPrice(this.ride.getOffers().get(offer_number - 1).getSuggested_price());
        for (driver driver : this.system.getData().getDrivers()) {/////////////////////////////////////////////////////
            driver.getDriverdata().getAll_requests().remove(this.ride);
            if (driver.getDriverdata().getRequests_in_favourites().contains(this.ride)) {
                driver.getDriverdata().getRequests_in_favourites().remove(this.ride);
            }
        }
        this.ride.getOffers().clear();
        this.getNotifications().getNotification().clear();
        String message = "Your offer from " + this.getUsername() + " accepted ";
        this.ride.getDriver().notifications.getNotification().add(message);
        System.out.println("thank you for choosen us please rate the driver");
        rate_driver(this.ride.getDriver());
    }

    @Override
    public void rate_driver(driver driver) {
        System.out.println("choose rate the driver from 1 to 5 star");
        Scanner in = new Scanner(System.in);
        float rating = in.nextInt();
        if (!(rating == 1 || rating == 2 || rating == 3 || rating == 4 || rating == 5)) {
            rate_driver(driver);
        }
        //this.ride.getDriver().getUsers_rating().add(rating);
        this.ride.setRate(rating);
        system.getMenu().user_menu(this);
    }
}
