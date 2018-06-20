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
public class Flight {
    private String flightNumber;
    private String airplaneName;
    private String departure;
    private String arrival;    
    private String airlinerName;
    
    private Airplane airplane;
    private Seats seats;
    
    private int departureTime;
    private int arrivalTime;
    private int date;
    private Date createdOn;
    
    public Flight() {
        this.createdOn = new Date();
        this.airplane = new Airplane();
        airplane.setName(this.airplaneName);
        this.seats = new Seats();
    }

    public String getAirlinerName() {
        return airlinerName;
    }

    public void setAirlinerName(String airlinerName) {
        this.airlinerName = airlinerName;
    }

    public Seats getSeats() {
        return seats;
    }

    public void setSeats(Seats seats) {
        this.seats = seats;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public void setAirplane(Airplane airplane) {
        this.airplane = airplane;
    }
 
    public String getAirplaneName() {
        return airplaneName;
    }

    public void setAirplaneName(String airplaneName) {
        this.airplaneName = airplaneName;
    }
    
    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(int departureTime) {
        this.departureTime = departureTime;
    }
    public void inputSeatsNumber(Integer s){
        for(int i = 1; i <= s; i++){          
            seats.addSeats(i);
        }
    }
    
    @Override
    public String toString(){      
        return flightNumber;
    }
    
}
