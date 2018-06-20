/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Chung-Yang Li
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountDirectory;
    
    public UserAccountDirectory(){
        this.userAccountDirectory = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(ArrayList<UserAccount> c) {
        this.userAccountDirectory = c;
    }
    
    public UserAccount addUserAccount(){
        UserAccount c = new UserAccount();
        userAccountDirectory.add(c);
        return c;
    }
    
    public void deleteUserAccount(UserAccount c){
        userAccountDirectory.remove(c);
    }
    
//    public Account searchAccount(String accountNum){
//        for(Account a: userAccountDirectory){
//            if(a.getAccountNum().equals(accountNum)){
//                return a;
//            }
//        }
//        return null;
//    }
    
//    public void uploadCustomer(){
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
//                c.setAge(Integer.parseInt(item[2]));
//                c.setLocation(item[3]);
//                c.setDestination(item[4]);
//                                             
//                fail = true;             
//            }
//        } catch (Exception a){
//            JOptionPane.showMessageDialog(null,"The file is wrong or not existed.");
//        }
//        if(fail == true)
//        return;
//    }
//    
}
