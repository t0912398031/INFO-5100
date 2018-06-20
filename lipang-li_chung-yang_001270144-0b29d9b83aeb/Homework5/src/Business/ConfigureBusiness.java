/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author Chung-Yang Li
 */
public class ConfigureBusiness {
    public static Business initailizeBusiness(){
        Business business = Business.getInstance();
        
        Person p = new Person();
        p.setFirstName("Chung-Yang");
        p.setLastName("Li");
        
        Retailer r1 = business.getRd().addRetailer();
        r1.setRetailerName("Wal-Mart Stores");
        r1.setFirstName(r1.getRetailerName());

        Customer c1 = new Customer();
        c1.setFirstName("Spider");
        c1.setLastName("Man");
        
        UserAccount ua1 = business.getUad().addUserAccount();
        ua1.setUserName("0");
        ua1.setPassword("0");
        ua1.setPerson(p);
        ua1.setRole(UserAccount.ADMIN_ROLE);
        ua1.setIsActive(true);
        
        UserAccount ua2 = business.getUad().addUserAccount();
        ua2.setUserName("1");
        ua2.setPassword("1");
        ua2.setPerson(r1);
        ua2.setRole(UserAccount.RETAILER_ROLE);
        ua2.setIsActive(true);
        
        UserAccount ua3 = business.getUad().addUserAccount();
        ua3.setUserName("2");
        ua3.setPassword("2");
        ua3.setPerson(c1);
        ua3.setRole(UserAccount.CUSTOMER_ROLE);
        ua3.setIsActive(true);
        
//        uploadFromFile();
        
        return business;
    }
    
//    public static void uploadFromFile(){
//        boolean fail = false;
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("Customer input.csv"));
//            String line = null;
//            while((line=reader.readLine())!=null){//read the .csv by each line
//                String item[] = line.split(",");//separate each line based on ','
//                
//                UserAccount c = new UserAccount();
//                userAccountDirectory.add(c);
//                
//                c.setFirstName(item[0]);
//                c.setLastName(item[1]);          
//                                                             
//                fail = true;             
//            }
//        } catch (Exception a){
//            JOptionPane.showMessageDialog(null,"The file is wrong or not existed.");
//        }
//        if(fail == true)
//        return;
//    }
}
