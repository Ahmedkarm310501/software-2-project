package Entites;
import java.util.ArrayList;

public class offer {
    private double suggested_price;
    private driver driver;
    private user user;
    private ride ride;

    
    
    public offer() {
		
	}

	public ArrayList<Boolean> getFlag() {
        return flag;
    }

    public void setFlag(ArrayList<Boolean> flag) {
        this.flag = flag;
    }
 private ArrayList<Boolean> flag = new ArrayList<>();

  

    public ride getRide() {
        return ride;
    }

    public void setRide(ride ride) {
        this.ride = ride;
    }

    public offer(float suggested_price, driver driver, user user) {
        this.suggested_price = suggested_price;
        this.driver = driver;
        this.user = user;
        for(int i=0;i<user.getRide().getPassenger_num();i++)
        {
            flag.add(false);
        
        }
         
    }
    public double getSuggested_price() {

        return suggested_price;        
    }
//   

    public void setSuggested_price(double suggested_price) {
        this.suggested_price = suggested_price;
    }

    public driver getDriver() {
        return driver;
    }

    public void setDriver(driver driver) {
        this.driver = driver;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }





}
