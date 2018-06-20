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
public class ConfigureBusiness {
    public static Business initailizeBusiness(){
        Business business = Business.getInstance();
        Employee e1 = business.getEd().addEmployee();
        e1.setFirstName("Chung-Yang");
        e1.setLastName("Li");
        e1.setOrganization("Northeastern");
        Employee e2 = business.getEd().addEmployee();
        e2.setFirstName("YiRen");
        e2.setLastName("Goh");
        e2.setOrganization("Singapore");
        
        UserAccount ua = business.getUad().addUserAccount();
        ua.setUserName("123");
        ua.setPassword("123");
        ua.setPerson(e1);
        ua.setRole(UserAccount.ADMIN_ROLE);
        ua.setIsActive(true);
        
        return business;
    }
}
