/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import Business.WorkQueue.ShortMessageQueue;
import Business.WorkQueue.WorkQueue;

/**
 *
 * @author lingfengzhou
 */
public class UserAccount {
    private String username;
    private String password;
    private Employee employee;
    private Role role;
    private WorkQueue workQueue;
    private ShortMessageQueue messageQueue;
//    private ShortMessageQueue sendMessageQueue;

    
    public UserAccount() {
        workQueue = new WorkQueue();
        messageQueue = new ShortMessageQueue();
//        sendMessageQueue = new ShortMessageQueue();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }
    @Override
    public String toString() {
        return employee.getName();
    }

    public ShortMessageQueue getMessageQueue() {
        return messageQueue;
    }

//    public ShortMessageQueue getSendMessageQueue() {
//        return sendMessageQueue;
//    }
    
    
}
