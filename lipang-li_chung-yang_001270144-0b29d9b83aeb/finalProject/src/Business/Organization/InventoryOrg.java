/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.BitCoinMall.MasterOrderCatalog;
import Business.Role.Producer;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author JIN
 */
public class InventoryOrg extends Organization{
    
    private MasterOrderCatalog masterOrderCatalog;
    
    public InventoryOrg() {
        super(Organization.Type.Inventory.getValue());
        this.masterOrderCatalog = new MasterOrderCatalog();
    }
    // producer
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Producer());
        return roles;
    }

    public MasterOrderCatalog getMasterOrderCatalog() {
        return masterOrderCatalog;
    }

    public void setMasterOrderCatalog(MasterOrderCatalog masterOrderCatalog) {
        this.masterOrderCatalog = masterOrderCatalog;
    }
    
    
    
}
