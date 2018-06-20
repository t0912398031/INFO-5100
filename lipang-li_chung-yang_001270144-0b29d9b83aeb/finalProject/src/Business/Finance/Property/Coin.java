/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Finance.Property;


/**
 *
 * @author Chung-Yang Li
 * @author Lingfeng Zhou
 */
public class Coin extends Property{
    private final String coinKey;
    
    public Coin(String type,String coinKey) {
        super(type);
        this.coinKey = coinKey;
    }

    public Coin(String type,String coinKey,String prevOwnership, String curOwnership) {
        super(type, prevOwnership, curOwnership);
        this.coinKey = coinKey;
    }
    

    public String getCoinKey() {
        return coinKey;
    }

//    public void setCoinKey(String bitcoinKey) {
//        this.coinKey = bitcoinKey;
//    }
    
}
