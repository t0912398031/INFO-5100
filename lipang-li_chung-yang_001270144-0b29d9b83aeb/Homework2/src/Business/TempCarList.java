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
public class TempCarList {
    
    private ArrayList<Car> tempCarList;
    private CarList carList;
    public TempCarList(){
        tempCarList = new ArrayList<>();    
    }

    

    public void setCarList(CarList carList) {
        this.carList = carList;
    }

    public ArrayList<Car> getTempCarList() {
        return tempCarList;
    }

    public void setTempCarList(ArrayList<Car> c) {
        this.tempCarList = c;
    }
    
    public Car addCars(){
        Car c = new Car();
        tempCarList.add(c);
        return c;
    }
    
    public void deleteCar(Car c){
        tempCarList.remove(c);
    }  
    
    public void findCarByBrand(String In) {  
        for(Car c : carList.getCarList()){           
            if(c.getBrand().equals(In)){
                tempCarList.add(c);               
            }       
        }   
    }
    
    public void findCarBySerialNum(int In) {  
        for(Car c : carList.getCarList()){           
            if(c.getSerialNum() == In){
                tempCarList.add(c);               
            }       
        }   
    }
    
    public void findCarByModelNum(int In) {  
        for(Car c : carList.getCarList()){           
            if(c.getModelNum() == In){
                tempCarList.add(c);               
            }       
        }   
    }
    
    public void findCarByCity(String In) {  
        for(Car c : carList.getCarList()){           
            if(c.getCity().equals(In)){
                tempCarList.add(c);               
            }       
        }   
    }
    
    public void findCarByMadeYear(int In) {  
        for(Car c : carList.getCarList()){           
            if(c.getMadeYear() == In){
                tempCarList.add(c);               
            }       
        }   
    }
    
    public int findCarByAvail() {  
        for(Car c : carList.getCarList()){           
            if(c.isAvail()){
                tempCarList.add(c);               
            }       
        }       
        int notAvail = carList.getCarList().size() - tempCarList.size();
        return notAvail;
    }
    
    public void findCarUsedByUBER() {  
        for(Car c : carList.getCarList()){           
            if(c.getManufacturersByUBER()){
                tempCarList.add(c);               
            }       
        }   
    }
    
    public void findCarExpiredMC() {  
        for(Car c : carList.getCarList()){           
            if(c.isExpiredMC()){
                tempCarList.add(c);               
            }       
        }   
    }
    
    public void findAvailCarBySeats(int min, int max) {          
        for(Car c : carList.getCarList()){
            if(c.getSeats()<=max && c.getSeats()>=min && c.isAvail()){
                tempCarList.add(c);               
            }
        }          
    }
    
    public void findFirstAvail() {  
        int min = carList.getCarList().size();
        for(Car c : carList.getCarList()){           
            if(c.isAvail()){                       
                if(carList.getCarList().indexOf(c)<min){
                    min = carList.getCarList().indexOf(c);
                }
            }                   
        }
        Car car = carList.getCarList().get(min);
        tempCarList.add(car);  
    }
    
    
    public void clearFind(){
        tempCarList.clear();
    }
    
    public void deleteFindName(Car e){
        tempCarList.remove(e);
    }
}
