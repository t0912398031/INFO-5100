/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BitCoinMall;

/**
 *
 * @author JIN
 */
public class Product {
    private int id;
    private int avail;    
    private String name;
    private double prise;
    private String picturepath;  
    
    private static int count = 0;
  

//public Product(int pid, String pname,float pprise, byte[] image){
//    this.id = pid;
//    this.name= pname;
//    this.picture = image;
//    this.prise = pprise;
//}

    public Product(){
    count++;
    id=count;
    
    }
   
public int getAvail() {
        return avail;
    }

    public void setAvail(int avail) {
        this.avail = avail;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    public String getPicture() {
        return picturepath;
    }

    public void setPicture(String path) {
        this.picturepath = path;
    }
    
     @Override
    public String toString() {
        return name;
    }

}
