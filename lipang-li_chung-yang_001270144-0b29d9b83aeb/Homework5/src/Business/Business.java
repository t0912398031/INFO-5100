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
    private RetailerDirectory rd;
    private MasterOrderCatalog moc;
    private UserAccountDirectory uad;

    public Business() {
        rd = new RetailerDirectory();
        moc = new MasterOrderCatalog();
        uad = new UserAccountDirectory();
    }
    public static Business getInstance(){
        if(business == null){
            business = new Business();
        }
        return business;    
    }
    
    public RetailerDirectory getRd() {
        return rd;
    }

    public void setRd(RetailerDirectory rd) {
        this.rd = rd;
    }

    public UserAccountDirectory getUad() {
        return uad;
    }

    public void setUad(UserAccountDirectory uad) {
        this.uad = uad;
    }

    public MasterOrderCatalog getMoc() {
        return moc;
    }

    public void setMoc(MasterOrderCatalog moc) {
        this.moc = moc;
    } 
}
