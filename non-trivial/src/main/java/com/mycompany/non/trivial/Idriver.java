
package com.mycompany.non.trivial;

public interface Idriver {
    public void show_all_requests(String type);
    public void create_offer(float price, ride ride);
    public void add_offer(int ride_number,String type) ;
    public void show_users_rating();
    public float averege_rating();
    public void add_favourite_area();
}
