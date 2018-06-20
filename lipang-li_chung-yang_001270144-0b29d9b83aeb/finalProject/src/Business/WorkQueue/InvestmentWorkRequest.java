/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.Finance.DealRecord;

/**
 *
 * @author Chung-Yang Li
 */
public class InvestmentWorkRequest extends WorkRequest {
    private String type;
    private int amount;
    private int initialAmount;
    private double price;
    private double rate;
    private String investmentEnterprise;
    private String custodyEnterprise;
    private DealRecord dealRecord;

    public InvestmentWorkRequest() {
        super();
        dealRecord = new DealRecord();
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getCustodyEnterprise() {
        return custodyEnterprise;
    }

    public void setCustodyEnterprise(String custodyEnterprise) {
        this.custodyEnterprise = custodyEnterprise;
    }

    public int getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(int initialAmount) {
        this.initialAmount = initialAmount;
    }

    public DealRecord getDealRecord() {
        return dealRecord;
    }

    public void setDealRecord(DealRecord dealRecord) {
        this.dealRecord = dealRecord;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getInvestmentEnterprise() {
        return investmentEnterprise;
    }

    public void setInvestmentEnterprise(String investmentEnterprise) {
        this.investmentEnterprise = investmentEnterprise;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getWorkNumber());
    }

}
