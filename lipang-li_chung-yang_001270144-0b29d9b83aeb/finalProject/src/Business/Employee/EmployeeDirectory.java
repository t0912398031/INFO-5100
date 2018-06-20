/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author lingfengzhou
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeList;

    public EmployeeDirectory() {
        employeeList = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
    
    public Employee addEmployee(){
        Employee employee = new Employee();
        employeeList.add(employee);
        return employee;        
    }
    
    public Employee addEmployee(String EName){
        Employee employee = new Employee();
        employee.setName(EName);
        employeeList.add(employee);
        return employee;
    }
    
    public void removeEmployee(Employee employee){
        employeeList.remove(employee);
    }
    
    public Employee updateEmployee(Employee e,String name){
        e.setName(name);
        return e;
    }
    
}
