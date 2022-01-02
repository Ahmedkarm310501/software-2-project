package Entites;

import java.util.ArrayList;

public abstract class ride {
    public String source;
    public String destenation;
    private double price;

   
   private ArrayList<user> users = new ArrayList(); 
   private user user;

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }
    private boolean status=false;
    private float rate;
    private driver driver;
    private ArrayList<offer> offers = new ArrayList();
    private ArrayList<event> events = new ArrayList();
    public int passenger_num;

    public ArrayList<event> getEvents() {
        return events;
    }

    public ArrayList<user> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<user> users) {
        this.users = users;
    }

    public void setEvents(ArrayList<event> events) {
        this.events = events;
    }
    public ride() {
    }
    
    public ride(String source, String destenation) {
        this.source = source;
        this.destenation = destenation;
      
    }
    

    public int getPassenger_num() {
        return passenger_num;
    }

    public void setPassenger_num(int passenger_num) {
        this.passenger_num = passenger_num;
    }
        
    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



    public ArrayList<offer> getOffers() {
        return offers;
    }

    public void setOffers(ArrayList<offer> offers) {
        this.offers = offers;
    }



    public driver getDriver() {
        return driver;
    }

    public void setDriver(driver driver) {
        this.driver = driver;
    }



   

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

       abstract public boolean  request_aride(String source, String destination,user user,int passenger_num);
        

       @Override
       public String toString() {
           return "ride{" + "source=" + source + ", destenation=" + destenation + ", price=" + price + '}';
       }





   

}
