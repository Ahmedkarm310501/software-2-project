package com.mycompany.non.trivial;

import java.util.Scanner;

public class system {
  
    private systemdata data=new systemdata();
    private admin adminuser;

    public system() {
    }

 


    public systemdata getData() {
        return data;
    }

    public void setData(systemdata data) {
        this.data = data;
    }

    public system( admin adminuser) {
      
        this.adminuser = adminuser;
    }



    public admin getAdminuser() {
        return adminuser;
    }

    public void setAdminuser(admin adminuser) {
        this.adminuser = adminuser;
    }

    
}
