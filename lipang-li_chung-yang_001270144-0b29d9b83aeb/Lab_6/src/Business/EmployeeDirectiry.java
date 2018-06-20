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
public class EmployeeDirectiry {
    
    private ArrayList<Employee> employeelist;

    public EmployeeDirectiry() {
        this.employeelist = new ArrayList<Employee>();
    }

    public ArrayList<Employee> getEmployeelist() {
        return employeelist;
    }

    public void setEmployeelist(ArrayList<Employee> employeelist) {
        this.employeelist = employeelist;
    }
    
    public Employee addEmployee(){
    Employee e = new Employee();
    employeelist.add(e);
    return e;
    }
    
    public void removeEmployee(Employee e){
    employeelist.remove(e);    
    }
    
}
