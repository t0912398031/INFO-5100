/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Finance.CoinTransaction;

import java.time.LocalDateTime;

/**
 *
 * @author lingfengzhou
 */
public final class Transaction {
    
    private final LocalDateTime dealTime;
    private final String type;
    private final String coinNum;
    private final String prevOwner;
    private final String curOwner;
    private static int count=7000000;
    private final int id;
    public Transaction(LocalDateTime dealTime, String coinNum, String prevOwner, String curOwner,String type) {
        this.dealTime = LocalDateTime.now();
        this.coinNum = coinNum;
        this.prevOwner = prevOwner;
        this.curOwner = curOwner;
        this.type = type;
        this.id = count++;
    }

    public LocalDateTime getDealTime() {
        return dealTime;
    }

    public String getCoinNum() {
        return coinNum;
    }

    public String getPrevOwner() {
        return prevOwner;
    }

    public String getCurOwner() {
        return curOwner;
    }

    public String getType() {
        return type;
    }
    

    public int getId() {
        return id;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.getId());
    }
    
}
