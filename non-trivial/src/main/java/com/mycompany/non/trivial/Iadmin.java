
package com.mycompany.non.trivial;

public interface Iadmin {
    public void suspend_driver(driver person);
    public void list_suspended_drivers();
    public void activate_driver(String email);
    public void suspend_person(String email);
    public void list_suspended_users();
    public void activate_user(String email);
}
