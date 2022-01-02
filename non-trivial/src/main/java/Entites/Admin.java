package Entites;
import Models.*;
public class Admin {
    private admindata admindata=new admindata();
    private String ID;
    private String password;
    private static Account system;
    private static Admin uniqueInstance;
    
    
    private Admin() {
        this.ID = "111";
        this.password = "111";
    }
    
    public static Admin getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Admin();
			uniqueInstance.setSystem(system);
		}
		return uniqueInstance;
	}
    
    public admindata getAdmindata() {
        return admindata;
    }

    public void setAdmindata(admindata admindata) {
        this.admindata = admindata;
    }



    public Account getSystem() {
        return system;
    }

    public void setSystem(Account system) {
        this.system = system;
    }



    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public void suspend_driver(driver person) {
        person.setStatus(false);
        this.admindata.getPending_drivers().add(person);
    }

    



    



    ////////////////////////////////////////////////
    ///////////////////////delete///////////////////////


}