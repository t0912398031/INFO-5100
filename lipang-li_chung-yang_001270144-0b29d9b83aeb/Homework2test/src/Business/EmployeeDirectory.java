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
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeDirectory;
    
    public EmployeeDirectory(){
        employeeDirectory = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(ArrayList<Employee> ed) {
        this.employeeDirectory = ed;
    }
    
    public Employee addEmployees(){
        Employee e = new Employee();
        employeeDirectory.add(e);
        return e;
    }
    
    public void deleteEmployee(Employee e){
        employeeDirectory.remove(e);
    }
    
    public Employee findEmployeeByLName(String In){
        ArrayList<Employee> employeeList;
        
        employeeList = this.getEmployeeDirectory();
        for(Employee e : employeeList){
            if(e.getLname().equals(In)){
                return e;
            }        
        }
        return null;
    }
}
