/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Chung-Yang Li
 */
class Fleet {
    private ArrayList<Airplane> fleet;
    
    public Fleet(){
        this.fleet = new ArrayList<>();
    }

    public ArrayList<Airplane> getFleet() {
        return fleet;
    }
    
    public void setFleet(ArrayList<Airplane> fleet) {
        this.fleet = fleet;
    }

    public Airplane addAirplane(){
        Airplane a = new Airplane();
        fleet.add(a);
        return a;
    }
    
    public void deleteAirplane(Airplane a){
        fleet.remove(a);
    }
    
//    public Account searchAccount(String accountNum){
//        for(Account a: fleet){
//            if(a.getAccountNum().equals(accountNum)){
//                return a;
//            }
//        }
//        return null;
//    }
}
