/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Chung-Yang Li
 */
public class TempFlightSchedule {
    private String airlinerName;
    private ArrayList<Flight> tempFlightSchedule;
    
    public TempFlightSchedule(){
        this.tempFlightSchedule = new ArrayList<>();        
    }
    
    public TempFlightSchedule(String airlinerName){
        this.tempFlightSchedule = new ArrayList<>();
        this.airlinerName = airlinerName;        
    }

    public String getAirlinerName() {
        return airlinerName;
    }

    public ArrayList<Flight> getTempFlightSchedule() {
        return tempFlightSchedule;
    }

    public void setTempFlightSchedule(ArrayList<Flight> tempFlightSchedule) {
        this.tempFlightSchedule = tempFlightSchedule;
    }
    
    public Flight addFlight(){
        Flight f = new Flight();
        tempFlightSchedule.add(f);
        return f;
    }
    
    public void addFlight(Flight f){
        tempFlightSchedule.add(f);        
    }
    
    public void deleteFlight(Flight f){
        tempFlightSchedule.remove(f);
    }      
}
