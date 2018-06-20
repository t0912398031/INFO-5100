/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author Chung-Yang Li
 */
public class CarList {
    
    private ArrayList<Car> carList;
    
    public CarList(){
        carList = new ArrayList<>();
    }

    public ArrayList<Car> getCarList() {
        return carList;
    }

    public void setCarList(ArrayList<Car> c) {
        this.carList = c;
    }
    
    public Car addCars(){
        Car c = new Car();
        carList.add(c);
        return c;
    }
    
    public void deleteCar(Car c){
        carList.remove(c);
    }
    
    
}
