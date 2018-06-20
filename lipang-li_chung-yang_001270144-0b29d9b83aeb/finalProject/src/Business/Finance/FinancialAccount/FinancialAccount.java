package Business.Finance.FinancialAccount;



import Business.Finance.Property.CoinCollection;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lingfengzhou, Chung-Yang Li
 */
public class FinancialAccount {
    
    private String name;
    private CoinCollection coinCollection;
    private Double dollorAccount = 100000.0;

    public FinancialAccount(String name) {
        this.name = name;
        this.coinCollection = new CoinCollection();
    }
    public FinancialAccount(String name, CoinCollection bitCoinCollection, Double dollorAccount) {
        this.name = name;
        this.coinCollection = bitCoinCollection;
        this.dollorAccount = dollorAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CoinCollection getCoinCollection() {
        return coinCollection;
    }

    public Double getDollorAccount() {
        return dollorAccount;
    }

    public void setDollorAccount(Double dollorAccount) {
        this.dollorAccount = dollorAccount;
    }
   
}
