/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Chung-Yang Li
 */
public class Business {
    private static Business business;
    private EmployeeDirectiry ed;
    private UserAccountDirectory uad;

    public Business() {
        ed = new EmployeeDirectiry();
        uad = new UserAccountDirectory();
    }
    public static Business getInstance(){
        if(business == null){
            business = new Business();
        }
        return business;    
    }
    
    public EmployeeDirectiry getEd() {
        return ed;
    }

    public void setEd(EmployeeDirectiry ed) {
        this.ed = ed;
    }

    public UserAccountDirectory getUad() {
        return uad;
    }

    public void setUad(UserAccountDirectory uad) {
        this.uad = uad;
    }
    
    
    
}
