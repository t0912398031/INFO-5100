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
public class AirlinerDirectory {
    
    private ArrayList<Airliner> airlinerDirectory;
    
    public AirlinerDirectory(){
        this.airlinerDirectory = new ArrayList<>();
    }

    public ArrayList<Airliner> getAirlinerDirectory() {
        return airlinerDirectory;
    }

    public void setAirlinerDirectory(ArrayList<Airliner> a) {
        this.airlinerDirectory = a;
    }
    
    public Airliner addAirliner(){
        Airliner a = new Airliner();
        airlinerDirectory.add(a);
        return a;
    }
    
    public void deleteAirliner(Airliner a){
        airlinerDirectory.remove(a);
    }
    
    public TempFlightSchedule searchAirAirliner(AirlinerDirectory ad, String departure, String arrival){
        TempFlightSchedule tempFlightSchedule = new TempFlightSchedule();
        for(Airliner a : ad.getAirlinerDirectory()){
            for(Flight f : a.getFlightSchedule().getFlightSchedule()){
                if(f.getDeparture().equals(departure)&&f.getArrival().equals(arrival)){
                    tempFlightSchedule.addFlight(f);                    
                }                
            }
        }
        if(tempFlightSchedule.getTempFlightSchedule().isEmpty()){
            for(Airliner a : ad.getAirlinerDirectory()){
                for(Flight f : a.getFlightSchedule().getFlightSchedule()){
                    if(f.getDeparture().equals(departure)&&arrival.isEmpty()){
                        tempFlightSchedule.addFlight(f);                    
                    }                
                     if(f.getArrival().equals(arrival)&&departure.isEmpty()){
                        tempFlightSchedule.addFlight(f);                    
                    }   
                }
            }
            return tempFlightSchedule;
        }
        else{
            return tempFlightSchedule;
        }
    }
    
  
}
