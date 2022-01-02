package Entites;

import java.util.ArrayList;
import java.util.Scanner;
import Models.*;




public class Account {
  
    private AccountsData data=new AccountsData();
    private static Admin adminuser=Admin.getInstance();
    private static person cuurent_user=null;
   
	private static Account uniqueInstance;

	private Response responce;
	public static person getCuurent_user() {
		return cuurent_user;
	}

	public void setCuurent_user(person cuurent_user) {
		this.cuurent_user = cuurent_user;
	}


    private Account() {
    }
    
    public static Account getInstance() {
		if (uniqueInstance == null) {
			uniqueInstance = new Account(adminuser);
			adminuser.setSystem(uniqueInstance);
		}
		return uniqueInstance;
	}

 
    public AccountsData getData() {
        return data;
    }

    public void setData(AccountsData data) {
        this.data = data;
    }

    public Account( Admin adminuser) {
      
        this.adminuser = adminuser;
    }



    public Admin getAdminuser() {
        return adminuser;
    }

    public void setAdminuser(Admin adminuser) {
        this.adminuser = adminuser;
    }
    

    

    
}
