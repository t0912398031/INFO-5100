/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.SupplierDirectory;

/**
 *
 * @author Chung-Yang Li
 */
public class Business {
    private SupplierDirectory sd;
    private MasterOrderCatalog moc;
    
    public Business(){
        sd = new SupplierDirectory();
        moc = new MasterOrderCatalog();
    }

    public SupplierDirectory getSd() {
        return sd;
    }

    public void setSd(SupplierDirectory sd) {
        this.sd = sd;
    }

    public MasterOrderCatalog getMoc() {
        return moc;
    }

    public void setMoc(MasterOrderCatalog moc) {
        this.moc = moc;
    }
    
    
}
