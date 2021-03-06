package Entites;
import Models.driverdata;


public class driver extends person {
	
    private driverdata driverdata = new driverdata();
    private String driving_licence;
    private String national_id;
    private String cuurent_location;
    private boolean avalibilty=true;
    private int Available_seats=4;

    
    
    
    public driver() {
		
	}

	public int getAvailable_seats() {
        return Available_seats;
    }

    public void setAvailable_seats(int Available_seats) {
        this.Available_seats = Available_seats;
    }

    

    public boolean isAvalibilty() {
        return avalibilty;
    }

    public void setAvalibilty(boolean avalibilty) {
        this.avalibilty = avalibilty;
    }

    public String getCuurent_location() {
        return cuurent_location;
    }

    public void setCuurent_location(String cuurent_location) {
        this.cuurent_location = cuurent_location;
    }

   public driverdata getDriverdata() {
       return driverdata;
   }

   public void setDriverdata(driverdata driverdata) {
       this.driverdata = driverdata;
   }

    private ride ride;

    public ride getRide() {
        return ride;
    }

    public void setRide(ride ride) {
        this.ride = ride;
    }

    public driver(String driving_licence, String national_id, String username, String password, String number, String email, Account system) {
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


   public void add_requset(ride ride) {
       this.driverdata.getAll_requests().add(ride);
   }



   public float averege_rating() {
       float avg = 0;
       for (ride rate : this.driverdata.getAccepted_offers()) {
           avg += rate.getRate();
       }
       avg = avg / this.driverdata.getAccepted_offers().size();
       return avg;
   }

   public void add_favourite_area(String name) {
       this.driverdata.getFavourite_areas().add(name);
   }
   
   @Override
   public String toString() {
       return "driver{" + '}';
   }

}