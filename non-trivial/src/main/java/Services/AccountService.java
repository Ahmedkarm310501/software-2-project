package Services;

import Entites.*;

public class AccountService {
	static Account system = Account.getInstance();

	public static boolean registerUser(user user) {

		for (user per : system.getData().getUsers()) {
			if (per.getEmail().equals(user.getEmail())) {
				return false;
			}
		}
		system.getData().addUser(user);
		return true;
	}
	
	public static boolean registerDriver(driver driver) {

		for (driver per : system.getData().getDrivers()) {
			if (per.getEmail().equals(driver.getEmail())) {
				return false;
			}
		}
		system.getAdminuser().suspend_driver(driver);
		system.getData().addDriver(driver);
		return true;
	}
	
	
	public static int loginUser(String email,String password) {
		for (user user : system.getData().getUsers()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                if (user.isStatus()) {
                	if(system.getCuurent_user()==null) {
            			system.setCuurent_user(user);
            			return 1;
            		}
                }
                else {
                	return 0;
                }
            }
        }
		return -1;
	}
	
	
	public static int loginDriver(String email,String password) {
		for (driver driver : system.getData().getDrivers()) {
            if (driver.getEmail().equals(email) && driver.getPassword().equals(password)) {
                if (driver.isStatus()) {
                	if(system.getCuurent_user()==null) {
            			system.setCuurent_user(driver);
            			return 1;
            		}
                }
                else {
                	return 0;
                }
            }
        }
		return -1;
	}
	
	
	public static int loginAdmin(String ID,String password) {
		if(system.getCuurent_user()==null) {
			if (system.getAdminuser().getID().equals(ID) && system.getAdminuser().getPassword().equals(password))
				return 1;
			else
				return 0;
        }else {
            return -1;
        }
	}
	
	

}
