/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.BitCoinMall.MasterOrderCatalog;
import Business.BitCoinMall.ProductCatalog;
import Business.Finance.FinancialAccount.FinancialAccount;
import Business.Organization.Organization;
import Business.Role.Role;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author JIN
 */
public class MallEnterprise  extends Enterprise{
       
    private MasterOrderCatalog moc;
    private ProductCatalog productCatalog;
 
    public MallEnterprise() {
        super(Enterprise.Type.MallEnterprise.getValue());
        this.moc = new MasterOrderCatalog();
        this.productCatalog = new ProductCatalog();
    }

     public MasterOrderCatalog getMoc() {
        return moc;
    }

    public void setMoc(MasterOrderCatalog moc) {
        this.moc = moc;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }
    
    
    @Override
    public FinancialAccount getAccountInfo(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public List<Organization.Type> getSupportedOrg() {
        List<Organization.Type> orgTypes = new ArrayList<>();
        orgTypes.add(Organization.Type.Inventory);
        orgTypes.add(Organization.Type.Admin);
        orgTypes.add(Organization.Type.Accounting);
        return orgTypes;
        
    }
    
}
