/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Date;

/**
 *
 * @author Chung-Yang Li
 */
public class Airliner {
    private String airlinerName;
    
    private Fleet fleet;
    private FlightSchedule flightSchedule;
    private Date createdOn;
    
    public Airliner() {
        this.createdOn = new Date();
        this.flightSchedule = new FlightSchedule();
        this.fleet = new Fleet();
    }

    public Fleet getFleet() {
        return fleet;
    }

    public void setFleet(Fleet fleet) {
        this.fleet = fleet;
    }

    public FlightSchedule getFlightSchedule() {
        return flightSchedule;
    }

    public void setFlightSchedule(FlightSchedule flightSchedule) {
        this.flightSchedule = flightSchedule;
    }

    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airlinerName) {
        this.airlinerName = airlinerName;
    }

    @Override
    public String toString(){      
        return this.getAirlinerName();
    }
    
    
    
    
}
