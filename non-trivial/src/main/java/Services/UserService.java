package Services;
import Entites.*;
public class UserService {

	 
    private static user user=(user)Account.getCuurent_user();

    public static boolean requestSingleRide(String source, String destination,int num){
        ride ride=new Single_ride(source, destination);
        if( ride.request_aride(source, destination, user, num)){
            return true;
        }
        return false;
    }
    public static boolean requestMultiRide(String source, String destination,int num){
        ride ride=new Mulit_ride(source, destination);
        if( ride.request_aride(source, destination, user, num)){
            return true;
        }
        return false;
    }

/////////////////////////////////////////////////////
    public static boolean deposit(float ammount){
        user user=(user)Account.getCuurent_user();
        if(user!=null){
            user.deposit(ammount);
            return true;
        }
        return false;
    }




    







	
}