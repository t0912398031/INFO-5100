/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;


import Business.BitCoinMall.OrderHistory;
import Business.Role.Purchaser;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author JIN
 */
public class LogisticsOrg extends Organization{
    
    OrderHistory orderHistory;
    
    public LogisticsOrg() {
        super(Organization.Type.Logistics.getValue());
        orderHistory = new OrderHistory();
    }
    // producer
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new Purchaser());
        return roles;
    }

    public OrderHistory getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(OrderHistory orderHistory) {
        this.orderHistory = orderHistory;
    }
    
    
}