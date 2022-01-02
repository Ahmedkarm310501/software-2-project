package Entites;

public class Single_ride extends ride {


    public Single_ride() {
        this.source = null;
        this.destenation = null;
    }

    public Single_ride(String source, String destenation) {
        super(source, destenation);
    }

    @Override
    public boolean request_aride(String source, String destination,user user,int num) {

        
        this.setUser(user);
        user.system.getAdminuser().getAdmindata().getAll_rides().add(this);
        int driver_count=0;
       for (driver driver : user.system.getData().getDrivers()) {
           if(source.equals(driver.getCuurent_location())&&driver.isAvalibilty()==true){
               driver.add_requset(this);
               if (driver.getDriverdata().getFavourite_areas().contains(source)) {
                   driver.getDriverdata().getRequests_in_favourites().add(this);
                   String message = " you have a request for one of your favourite areas (" + source + ")";
                   driver.getNotifications().getNotification().add(message);
               }
               driver_count++;
           }
       }
        if(driver_count==0){
            user.system.getAdminuser().getAdmindata().getAll_rides().remove(this);
            user.setRide(null);
            return false;
        }
        return true;
    }


}
