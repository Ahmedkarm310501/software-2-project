package com.mycompany.non.trivial;

public class main {
    public static void main(String[]args){
        menu menu=new menu();
        admin admin = new admin();
        system system=new system(menu,admin);
        admin.setSystem(system);
        menu.setSystem(system);
        menu.main_menu();
    }
}
