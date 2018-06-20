/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Finance.Property;

import Business.Finance.FinancialAccount.FinancialAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Chung-Yang Li
 * @author Lingfeng Zhou
 */
public class CoinCollection {
    private List<Coin> coinList;

    public CoinCollection() {
        this.coinList = new ArrayList<>();
    }

    public List<Coin> getCoinList() {
        return coinList;
    }
    
    public Coin addCoin(Coin coin){
        coinList.add(coin);
        return coin;
    }
    
    public Coin addCoin(String type,String coinKey){
        Coin coin = new Coin(type , coinKey);
//        bitCoin.setCoinKey(bitCoinKey);
        coinList.add(coin);
        return coin;
    }
    
    public Coin addCoin(String type,String coinKey,String prevOwnership, String currOwnership){
        Coin coin = new Coin(type, coinKey, prevOwnership, currOwnership);
        coinList.add(coin);
        return coin;
    }
    /*** Match **/
    public String transferBitCoin(Coin coin, FinancialAccount buyerAccount){
        String key = coin.getCoinKey();
        String type = coin.getType();
        coinList.remove(coin);
        String prevOwner = coin.getCurOwnership();
        Coin coin1 = buyerAccount.getCoinCollection().addCoin(type, key, prevOwner, buyerAccount.getName());
        return key;
    }
    
    public void removeBitCoin(Coin coin){
    coinList.remove(coin);
    }
       
    
}
