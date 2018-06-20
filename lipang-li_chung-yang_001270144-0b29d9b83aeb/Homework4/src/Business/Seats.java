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
public class Seats {
    
    private ArrayList<Integer> seats;
    
    public Seats(){
        this.seats = new ArrayList<>();
    }

    public ArrayList<Integer> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Integer> s) {
        this.seats = s;
    }
    
    public void addSeats(Integer s){        
        seats.add(s);
    }
    
    public void deleteSeats(Integer s){
        seats.remove(s);
    }
    
    public void removeSeats(){
        seats.removeAll(seats);
    }

   @Override
    public String toString() {
        String result = "";
        for (int i = 1; i <= seats.size() ; i++) {
            if(seats.get(i-1)<10){
                result += " 0" + seats.get(i-1);
                continue;
            }            
            result += " " + seats.get(i-1);
            if(i % 10 == 0)
            result +="\n";
        }
        return result;
    }
}
