/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BitCoinMall;

import Business.BitCoinMall.Product;

/**
 *
 * @author JIN
 */
public class OrderItem {
    private int quantity;
//    private double salesPrice;
    private Product product;
    private double totalAmount;
    private double Prise;

    public double getPrise() {
        return Prise;
    }

    public void setPrise(double Prise) {
        this.Prise = Prise;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

//    public double getSalesPrice() {
//        return salesPrice;
//    }
//
//    public void setSalesPrice(double salesPrice) {
//        this.salesPrice = salesPrice;
//    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getTotalAmount() {
        return this.Prise*this.quantity;
    }
    
    @Override
    public String toString(){
        return product.getName();
    }  
    
}
