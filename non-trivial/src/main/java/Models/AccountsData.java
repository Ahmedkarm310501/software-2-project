package Models;
import Entites.*;

import java.util.ArrayList;

public class AccountsData {
    private ArrayList<user> users = new ArrayList();
    private ArrayList<driver> drivers = new ArrayList();

    public AccountsData() {
    }

    public ArrayList<user> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<user> users) {
        this.users = users;
    }

    public ArrayList<driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(ArrayList<driver> drivers) {
        this.drivers = drivers;
    }
    
    public void addUser(user user) {
    	this.users.add(user);
    }
    public void addDriver(driver driver) {
    	this.drivers.add(driver);
    }
    
	public user getUser(String email) {
		for(user p:users) {
			if(p.getEmail()==email) {
				return p;
			}
		}
		return null;
	}
	
	public driver getDriver(String email) {
		for(driver p:drivers) {
			if(p.getEmail()==email) {
				return p;
			}
		}
		return null;
	}
    
//	public  void update(user p) {
//		for(user user : users) {
//			if(person.getId()==p.getId()) {
//				person.setName(p.getName());
//				return;
//			}
//		}
//	}
    
    
    
    
}
