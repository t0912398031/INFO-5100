/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Chung-Yang Li
 */
public class Car {
    private String Brand;
    private int Seats;
    private int SerialNum;
    private int ModelNum;    
    private int MadeYear;
    private String UpdatedTime = "";
    private String City;
    private boolean Avail;
    private boolean ManufacturersByUBER;
    private boolean ExpiredMC;
    private int Index;

    public int getIndex() {
        return Index;
    }

    public void setIndex(int Index) {
        this.Index = Index;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String Brand) {
        this.Brand = Brand;
    }

    public int getSerialNum() {
        return SerialNum;
    }

    public void setSerialNum(int SerialNum) {
        this.SerialNum = SerialNum;
    }

    public int getModelNum() {
        return ModelNum;
    }

    public void setModelNum(int ModelNum) {
        this.ModelNum = ModelNum;
    }

    public boolean isAvail() {
        return Avail;
    }

    public void setAvail(boolean Avail) {
        this.Avail = Avail;
    }

    public String getUpdatedTime() {
        return UpdatedTime;
    }

    public void setUpdatedTime(String UpdatedTime) {
        this.UpdatedTime = UpdatedTime;
    }

    public boolean isExpiredMC() {
        return ExpiredMC;
    }

    public void setExpiredMC(boolean ExpiredMC) {
        this.ExpiredMC = ExpiredMC;
    }

    public boolean getManufacturersByUBER() {
        return ManufacturersByUBER;
    }

    public void setManufacturersByUBER(boolean ManufacturersByUBER) {
        this.ManufacturersByUBER = ManufacturersByUBER;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public int getSeats() {
        return Seats;
    }

    public void setSeats(int Seats) {
        this.Seats = Seats;
    }

    public int getMadeYear() {
        return MadeYear;
    }

    public void setMadeYear(int MadeYear) {
        this.MadeYear = MadeYear;
    }
    
    @Override
    public String toString(){
        String name = this.Brand;
        return name;
    }
    
    
    
    
}
