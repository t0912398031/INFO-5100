/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseNetwork;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author lingfengzhou
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem ecoSystem;
    private EnterpriseNetwork enterpriseNetwork;
    
    public static synchronized EcoSystem getInstance(){
        if(ecoSystem==null){
            ecoSystem = new EcoSystem();
        }
        return ecoSystem;
    }
    
    private EcoSystem(){
        super("EcoSystem");
        this.enterpriseNetwork = new EnterpriseNetwork();
        
    }

    public EnterpriseNetwork getEnterpriseNetwork() {
        return enterpriseNetwork;
    }
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public boolean checkDuplicateUserName(String usrName){
        for(Enterprise e:enterpriseNetwork.getEnterpriseList()){
            for(Organization o:e.getOrganizationDirectory().getOrganizationList()){
                for(UserAccount u:o.getUserAccountDirectory().getUserAccountList()){
                    if(usrName.equals(u.getUsername())) return true;
                }
            }
        }
        return false;
    }
    
}
