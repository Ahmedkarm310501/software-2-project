package Entites;


import java.util.ArrayList;

public class user extends person {


    ride ride;
    private ArrayList<ride> rides=new ArrayList();


     private String birthday;


    public user() {
    }

    public user(String username, String password, String number, String email, String birthday,Account system) {
        super(username, password, number, email, system);
        this.birthday=birthday;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public ArrayList<ride> getRides() {
        return rides;
    }

    public void setRides(ArrayList<ride> rides) {
        this.rides = rides;
    }
    public ride getRide() {
        return ride;
    }

    public void setRide(ride ride) {
        this.ride = ride;
    }

    @Override
    public String toString() {
        return "user{" + '}';
    }

    
    
    
    

    

}