/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author Chung-Yang Li
 */
public class Retailer extends Person{
    private String retailerName;
    private String location;
    private ProductCatalog productCatalog;
    private Date createdOn;
    
    public Retailer() {
        this.createdOn = new Date();
        this.productCatalog = new ProductCatalog();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ProductCatalog getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ProductCatalog productCatalog) {
        this.productCatalog = productCatalog;
    }

    public String getRetailerName() {
        return retailerName;
    }

    public void setRetailerName(String retailerName) {
        this.retailerName = retailerName;
    }

    @Override
    public String toString(){      
        return this.retailerName;
    }
    
    
    
    
}
