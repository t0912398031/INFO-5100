/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BitCoinMall;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author JIN
 */
public class Order {
    private ArrayList<OrderItem> orderItemList;
    private int orderNumber;
    private static int count = 0;
    private double totalPrice;
    private Date createDate;
    private String status = "unpaid";
    
    public Order(){
        count++;
        this.orderNumber = count;
        this.createDate = new Date();
        this.orderItemList = new ArrayList<OrderItem>();   
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getTotalPrice() {
        double sum=0;
        for(OrderItem o:orderItemList){
            sum+=o.getTotalAmount();
        }
        return sum;
    }
    
    
    public OrderItem addOrderItem(Product p, int q){
        OrderItem o = new OrderItem();
        o.setProduct(p);
        o.setQuantity(q);
        o.setPrise(p.getPrise());
       
        orderItemList.add(o);
        return o;        
    }
    
    public void removeOrderItem(OrderItem o){
        orderItemList.remove(o);    
    }

    public Date getCreateDate() {
        return createDate;
    }

    public Order(ArrayList<OrderItem> orderItemList, int orderNumber, double totalPrice, Date createDate) {
        this.orderItemList = orderItemList;
        this.orderNumber = orderNumber;
        this.totalPrice = totalPrice;
        this.createDate = createDate;
    }
    @Override
    public String toString(){
        return String.valueOf(this.getOrderNumber());
    }
    
}
