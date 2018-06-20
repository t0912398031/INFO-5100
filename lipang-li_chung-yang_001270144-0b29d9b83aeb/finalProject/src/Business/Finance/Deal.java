/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Finance;

import java.time.LocalDateTime;

/**
 *
 * @author Chung-Yang Li
 */
public class Deal {
    private int dealAmount;
    private double dealPrice;
    private LocalDateTime dealDate;
    
    public Deal() {
        this.dealDate = LocalDateTime.now();
    }

    public LocalDateTime getDealDate() {
        return dealDate;
    }

    public int getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(int dealAmount) {
        this.dealAmount = dealAmount;
    }

    public double getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(double dealPrice) {
        this.dealPrice = dealPrice;
    }


    
}
