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
public class FlightSchedule {
    String airlinerName;
    private ArrayList<Flight> flightSchedule;
    
    public FlightSchedule(){
        this.flightSchedule = new ArrayList<>();
    }

    public ArrayList<Flight> getFlightSchedule() {
        return flightSchedule;
    }

    public void setFlightSchedule(ArrayList<Flight> flightSchedule) {
        this.flightSchedule = flightSchedule;
    }

    public String getAirlinerName() {
        return airlinerName;
    }
    
    public Flight addFlight(){
        Flight f = new Flight();
        flightSchedule.add(f);
        return f;
    }
    
    public void deleteFlight(Flight f){
        flightSchedule.remove(f);
    }
    
//    public Account searchAccount(String accountNum){
//        for(Account a: flightSchedule){
//            if(a.getAccountNum().equals(accountNum)){
//                return a;
//            }
//        }
//        return null;
//    }
    
    public void uploadFlight(){
        boolean fail = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Cathay Pacific input.csv"));
            String line = null;
            while((line=reader.readLine())!=null){//read the .csv by each line
                String item[] = line.split(",");//separate each line based on ','
                
                Flight f = new Flight();
                flightSchedule.add(f);
                
                f.setAirplaneName(item[0]);
                f.setFlightNumber(item[1]);          
                f.setDeparture(item[2]);
                f.setArrival(item[3]);
//set tempseatnumber to 100                               
                f.inputSeatsNumber(100);
//                System.out.println(f.getSeats());
//                System.out.println(f.getSeats().toString());   
 
                fail = true;             
            }
        } catch (Exception a){
            JOptionPane.showMessageDialog(null,"The file is wrong or not existed.");
        }
        if(fail == true)
        JOptionPane.showMessageDialog(null,"Upload Accounts Successfully.");
    }
       
}
