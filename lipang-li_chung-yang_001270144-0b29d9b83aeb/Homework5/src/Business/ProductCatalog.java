/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Chung-Yang Li
 */
public class ProductCatalog {
    String airlinerName;
    private ArrayList<Product> productCatalog;
    
    public ProductCatalog(){
        this.productCatalog = new ArrayList<>();
    }

    public ArrayList<Product> getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(ArrayList<Product> productCatalog) {
        this.productCatalog = productCatalog;
    }

    public Product addProduct(){
        Product p = new Product();
        productCatalog.add(p);
        return p;
    }
    
    public void deleteProduct(Product p){
        productCatalog.remove(p);
    }
    
//    public Account searchAccount(String accountNum){
//        for(Account a: productCatalog){
//            if(a.getAccountNum().equals(accountNum)){
//                return a;
//            }
//        }
//        return null;
//    }
    
    public void uploadProduct(){
        boolean fail = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Product Catalog.csv"));
            String line = null;
            while((line=reader.readLine())!=null){//read the .csv by each line
                String item[] = line.split(",");//separate each line based on ','
                
                Product p = new Product();
                productCatalog.add(p);
                
                p.setProductName(item[0]);
                p.setModelNumber(Integer.parseInt(item[1]));          
                p.setPrice(Double.parseDouble(item[2]));
                p.setAvail(Integer.parseInt(item[3])); 
 
                fail = true;             
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"The file is wrong or not existed.");
        }
        if(fail == true)
        JOptionPane.showMessageDialog(null,"Upload Accounts Successfully.");
    }
       
}
