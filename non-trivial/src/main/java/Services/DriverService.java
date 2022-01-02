package Services;
import java.util.ArrayList;

import Entites.*;
public class DriverService {
    private static driver driver=(driver)Account.getCuurent_user();


    public static boolean deposit(float ammount){
        if(driver!=null){
            driver.setBalance(driver.getBalance()+ammount);
            return true;
        }
        return false;
    }


    

    public static ArrayList<ride> show_all_requests(){
        if(driver!=null){
            return driver.getDriverdata().getAll_requests();
        }
        return null;
    }



}