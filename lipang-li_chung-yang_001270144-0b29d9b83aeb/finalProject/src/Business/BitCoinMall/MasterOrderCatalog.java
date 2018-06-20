/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BitCoinMall;

import java.util.ArrayList;

/**
 *
 * @author JIN
 */
public class MasterOrderCatalog {

   
    private ArrayList<Order> orderCatalog;
    
    public MasterOrderCatalog(){
        orderCatalog = new ArrayList<Order>();
    }

    public ArrayList<Order> getOrderCatalog() {
        return orderCatalog;
    }

    public void setOrderCatalog(ArrayList<Order> orderCatalog) {
        this.orderCatalog = orderCatalog;
    }
    
    public Order addOrder(){
        Order order = new Order();
        orderCatalog.add(order);
        return order;
    }
    
    public Order addOrder(Order order){
        orderCatalog.add(order);
        return order;
    }
    //todo search
    public Order searchOrderByNum(int orderNum){
        return null;
    }
    
    public void removeOrder(Order o){
        orderCatalog.remove(o);
    }
}
