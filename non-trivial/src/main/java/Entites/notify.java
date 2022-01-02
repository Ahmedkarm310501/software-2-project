package Entites;

import java.util.ArrayList;

public class notify {
    private ArrayList<String> notification = new ArrayList();

    public notify() {
    }

    public ArrayList<String> getNotification() {
        return notification;
    }

    public void setNotification(ArrayList<String> notification) {
        this.notification = notification;
    }
    
    public void show_noitifications(){
        for(String message: notification){
            System.out.println(message);
        }
        this.notification.clear();

    }
}