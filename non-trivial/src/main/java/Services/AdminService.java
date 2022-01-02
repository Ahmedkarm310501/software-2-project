package Services;
import java.util.ArrayList;

import Entites.*;

public class AdminService {
	private static Admin admin=Admin.getInstance();
	
	
    public static boolean activate_driver(String email) {
        for (driver driver : admin.getAdmindata().getPending_drivers()) {
            if (driver.getEmail().equals(email)) {
                driver.setStatus(true);
                admin.getAdmindata().getPending_drivers().remove(driver);
                return true;
            }
        }
        return false;
    }
    ///////////////////////////////////////////////////////////////////
   public static ArrayList<driver> list_suspended_drivers() {
   	return admin.getAdmindata().getPending_drivers();
   }
   
   public static boolean suspend_person(String email) {
       for (user user :admin.getSystem().getData().getUsers() ){
           if(user.getEmail().equals(email)){
               admin.getAdmindata().getSuspended_users().add(user);
               user.setStatus(false);
               return true;
           }
       }
       
       for (driver driver :admin.getSystem().getData().getDrivers() ){
           if(driver.getEmail().equals(email)){
               admin.getAdmindata().getSuspended_users().add(driver);
               driver.setStatus(false);
               return true;
           }
       }
       return false;
   }
   
    public static ArrayList<person> list_suspended_users() {
    	return admin.getAdmindata().getSuspended_users();
    }

   
   public static boolean activate_user(String email) {
       for (person person : admin.getAdmindata().getSuspended_users()) {
           if (person.getEmail().equals(email)) {
               person.setStatus(true);
               admin.getAdmindata().getSuspended_users().remove(person);
               return true;
           }
       }
       return false;
   }
   
   public static ArrayList<ride> get_all_rides() {
   	return admin.getAdmindata().getAll_rides();
   }

   public static void add_discount_area(String area) {
       admin.getAdmindata().getAdmin_discount_areas().add(area);
   }
   
   public static ArrayList<String> show_discount_areas() {
   	return admin.getAdmindata().getAdmin_discount_areas();
   }

   public static void add_discount_Holiday(String date) {
       admin.getAdmindata().getPublic_holiday().add(date);
   }

   public static ArrayList<String> show_discount_Holiday() {
   	return admin.getAdmindata().getPublic_holiday();
   }
   
}
