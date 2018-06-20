/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Finance.FinancialAccount.FinancialAccount;
import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lingfengzhou
 */
public class SystemMantenanceEnterprise extends Enterprise{
    
    private static SystemMantenanceEnterprise systemMantenanceEnterprise;
    
    private SystemMantenanceEnterprise() {
        super(Enterprise.Type.SystemMantenanceEnterprise.getValue());
        this.setName("System Mantenance");
    }
    
    public static SystemMantenanceEnterprise getInstance(){
        if(systemMantenanceEnterprise==null){
            systemMantenanceEnterprise = new SystemMantenanceEnterprise();
        }
        return systemMantenanceEnterprise;
    }

    @Override
    public FinancialAccount getAccountInfo(String name) {
        return null;
    }
    @Override
    public ArrayList<Role> getSupportedRole() {
        return null;
    }
    
    @Override
    public List<Organization.Type> getSupportedOrg() {
        List<Organization.Type> orgTypes = new ArrayList<>();
        orgTypes.add(Organization.Type.Admin);
        return orgTypes;
        
    }
}
