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
public class RetailerDirectory {
    
    private ArrayList<Retailer> retailerDirectory;
    
    public RetailerDirectory(){
        this.retailerDirectory = new ArrayList<>();
    }

    public ArrayList<Retailer> getRetailerDirectory() {
        return retailerDirectory;
    }

    public void setRetailerDirectory(ArrayList<Retailer> a) {
        this.retailerDirectory = a;
    }
    
    public Retailer addRetailer(){
        Retailer r = new Retailer();
        retailerDirectory.add(r);
        return r;
    }
    
    public void deleteRetailer(Retailer r){
        retailerDirectory.remove(r);
    }
    
//    public TempFlightSchedule searchAirAirliner(RetailerDirectory ad, String departure, String arrival){
//        TempFlightSchedule tempFlightSchedule = new TempFlightSchedule();
//        for(Retailer a : ad.getRetailerDirectory()){
//            for(Product f : a.getFlightSchedule().getProductCatalog()){
//                if(f.getDeparture().equals(departure)&&f.getArrival().equals(arrival)){
//                    tempFlightSchedule.addFlight(f);                    
//                }                
//            }
//        }
//        if(tempFlightSchedule.getTempFlightSchedule().isEmpty()){
//            for(Retailer a : ad.getRetailerDirectory()){
//                for(Product f : a.getFlightSchedule().getProductCatalog()){
//                    if(f.getDeparture().equals(departure)&&arrival.isEmpty()){
//                        tempFlightSchedule.addFlight(f);                    
//                    }                
//                     if(f.getArrival().equals(arrival)&&departure.isEmpty()){
//                        tempFlightSchedule.addFlight(f);                    
//                    }   
//                }
//            }
//            return tempFlightSchedule;
//        }
//        else{
//            return tempFlightSchedule;
//        }
//    }
    
  
}
