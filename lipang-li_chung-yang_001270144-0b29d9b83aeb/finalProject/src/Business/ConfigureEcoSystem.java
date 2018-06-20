/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.Employee.Employee;
import Business.Enterprise.*;
import Business.Finance.Property.CoinCollection;
import Business.Finance.FinancialAccount.FinancialAccount;
import Business.Finance.Property.Coin;

import Business.Organization.Organization;

import Business.Role.*;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.InvestmentWorkRequest;

import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 *
 * @author lingfengzhou, Chung-Yang Li
 */
public class ConfigureEcoSystem {
    
    public static EcoSystem configure(){
        
        EcoSystem ecoSystem = EcoSystem.getInstance();
        if(ecoSystem.getEnterpriseNetwork().getEnterpriseList().isEmpty()){
        SystemMantenanceEnterprise systemMantenanceEnterprise = SystemMantenanceEnterprise.getInstance();
        ecoSystem.getEnterpriseNetwork().getEnterpriseList().add(systemMantenanceEnterprise);
        Organization adminOrg = systemMantenanceEnterprise.getOrganizationDirectory().addOrganization(Organization.Type.Admin);
        Employee employee =adminOrg.getEmployeeDirectory().addEmployee("superAdmin");
        UserAccount saAccount = adminOrg.getUserAccountDirectory().addUserAccount("sa", "sa", employee, new SystemAdmin());
        
        /*** Deposit Enterprise ***/                 
       
        DepositEnterprise depositEnterprise = DepositEnterprise.getInstance();
        ecoSystem.getEnterpriseNetwork().getEnterpriseList().add(depositEnterprise);
        
        Organization transactionOrg = depositEnterprise.getOrganizationDirectory().addOrganization(Organization.Type.Transaction);        
        Employee transactionManager =transactionOrg.getEmployeeDirectory().addEmployee("Transaction Manager");
        UserAccount transactionManagerAccount = transactionOrg.getUserAccountDirectory().addUserAccount("mm", "mm", transactionManager, new TransactionManager());
        
//        Organization depAccountingOrg = depositEnterprise.getOrganizationDirectory().addOrganization(Organization.Type.Accounting);
//        Employee depAccountingManager = depAccountingOrg.getEmployeeDirectory().addEmployee("dep Accounting Manager");
//        UserAccount depAccountingManagerAccount = depAccountingOrg.getUserAccountDirectory().addUserAccount("dam", "dam", depAccountingManager, new AccountingManager());

        
        /*** MAllEnterprise ***/   
  
        Enterprise mallEnterprise = ecoSystem.getEnterpriseNetwork().addEnterprise(Enterprise.Type.MallEnterprise,"BitCoinMall");
        Organization InventoryOrg = mallEnterprise.getOrganizationDirectory().addOrganization(Organization.Type.Inventory);
        
        FinancialAccount financialAccountMall = depositEnterprise.getFinancialAccountDirectory().addCompleteFinancialAccount("BitCoinMall", new CoinCollection(), 0.00);
        Employee producer =InventoryOrg.getEmployeeDirectory().addEmployee("Producer");
        UserAccount pum = InventoryOrg.getUserAccountDirectory().addUserAccount("pum", "pum", producer, new Producer());
        
        
        
         /*** investmentEnterprise ***/   
        Enterprise investmentEnterprise = ecoSystem.getEnterpriseNetwork().addEnterprise(Enterprise.Type.InvestmentEnterprise,"Mogan");
        Organization investmentAdminOrg = investmentEnterprise.getOrganizationDirectory().addOrganization(Organization.Type.Admin);
        Organization investmentAccounOrg = investmentEnterprise.getOrganizationDirectory().addOrganization(Organization.Type.Accounting);
        Organization investmentInvestOrg = investmentEnterprise.getOrganizationDirectory().addOrganization(Organization.Type.Investment);

        Organization LogisticsOrg = investmentEnterprise.getOrganizationDirectory().addOrganization(Organization.Type.Logistics);
        

        Employee investmentAdmin =investmentAdminOrg.getEmployeeDirectory().addEmployee("Investment Admin");
        UserAccount investAdminAccount = investmentAdminOrg.getUserAccountDirectory().addUserAccount("iadmin", "iadmin", investmentAdmin, new EnterpriseAdmin());
           
        Employee investManager =investmentInvestOrg.getEmployeeDirectory().addEmployee("Investment Manager1");
        UserAccount investManegerAccount = investmentInvestOrg.getUserAccountDirectory().addUserAccount("im", "im", investManager, new InvestmentManager());

        Employee investAssistant =investmentInvestOrg.getEmployeeDirectory().addEmployee("Investment Assistant1");
        UserAccount investAssistantAccount = investmentInvestOrg.getUserAccountDirectory().addUserAccount("ia", "ia", investAssistant, new InvestmentAssistant());
        
        Employee investAssistant2 =investmentInvestOrg.getEmployeeDirectory().addEmployee("Investment Assistant2");
        UserAccount investAssistant2Account = investmentInvestOrg.getUserAccountDirectory().addUserAccount("ia2", "ia2", investAssistant2, new InvestmentAssistant());
        
        Employee accountingManager =investmentAccounOrg.getEmployeeDirectory().addEmployee("Accounting Manager1");
        UserAccount accountingManagerAccount = investmentAccounOrg.getUserAccountDirectory().addUserAccount("am", "am", accountingManager, new AccountingManager());
       
        Employee pm =LogisticsOrg.getEmployeeDirectory().addEmployee("Purchaser");
        UserAccount pma = LogisticsOrg.getUserAccountDirectory().addUserAccount("pm", "pm", pm, new Purchaser());
        

        
        Enterprise investmentEnterprise2 = ecoSystem.getEnterpriseNetwork().addEnterprise(Enterprise.Type.InvestmentEnterprise,"Franklin");
        Organization FinvestmentInvestOrg = investmentEnterprise2.getOrganizationDirectory().addOrganization(Organization.Type.Investment);
        Organization FinvestmentAccounOrg = investmentEnterprise2.getOrganizationDirectory().addOrganization(Organization.Type.Accounting);
        Organization FinvestmentAdminOrg = investmentEnterprise2.getOrganizationDirectory().addOrganization(Organization.Type.Admin);
        
        Employee FinvestmentAdmin =FinvestmentAdminOrg.getEmployeeDirectory().addEmployee("FInvestment Admin");
        UserAccount FinvestAdminAccount = FinvestmentAdminOrg.getUserAccountDirectory().addUserAccount("fiadmin", "fiadmin", FinvestmentAdmin, new EnterpriseAdmin());
           
        Employee FinvestManager =FinvestmentInvestOrg.getEmployeeDirectory().addEmployee("FInvestment Manager1");
        UserAccount FinvestManegerAccount = FinvestmentInvestOrg.getUserAccountDirectory().addUserAccount("fim", "fim", FinvestManager, new InvestmentManager());

        Employee FinvestAssistant =FinvestmentInvestOrg.getEmployeeDirectory().addEmployee("FInvestment Assistant1");
        UserAccount FinvestAssistantAccount = FinvestmentInvestOrg.getUserAccountDirectory().addUserAccount("fia", "fia", FinvestAssistant, new InvestmentAssistant());
        
        Employee FinvestAssistant2 =FinvestmentInvestOrg.getEmployeeDirectory().addEmployee("FInvestment Assistant2");
        UserAccount FinvestAssistant2Account = FinvestmentInvestOrg.getUserAccountDirectory().addUserAccount("fia2", "fia2", FinvestAssistant2, new InvestmentAssistant());
        
        Employee FaccountingManager =FinvestmentAccounOrg.getEmployeeDirectory().addEmployee("FAccounting Manager1");
        UserAccount FaccountingManagerAccount = FinvestmentAccounOrg.getUserAccountDirectory().addUserAccount("fam", "fam", FaccountingManager, new AccountingManager());
        
        
        /*** Custody Enterprise ***/          
        CustodyEnterprise custodyEnterprise = (CustodyEnterprise)ecoSystem.getEnterpriseNetwork().addEnterprise(Enterprise.Type.CustodyEnterprise,"custodyEnterprise 1");        
        custodyEnterprise.setMaxAmount(50);
        custodyEnterprise.setMinAmount(10);
        custodyEnterprise.setRate(0.01);
        
        Organization custodyAdminOrg = custodyEnterprise.getOrganizationDirectory().addOrganization(Organization.Type.Admin);
        Organization custodyTradingOrg = custodyEnterprise.getOrganizationDirectory().addOrganization(Organization.Type.Trading);
        Organization custodyAccountingOrg = custodyEnterprise.getOrganizationDirectory().addOrganization(Organization.Type.Accounting);
        Organization custodyCustomerServiceOrg = custodyEnterprise.getOrganizationDirectory().addOrganization(Organization.Type.CustomerService);
        
        Employee custodyAdmin =custodyAdminOrg.getEmployeeDirectory().addEmployee("Custody Admin");
        UserAccount custodyAdminAccount = custodyAdminOrg.getUserAccountDirectory().addUserAccount("ca", "ca", custodyAdmin, new EnterpriseAdmin());
        
        Employee tradingManager =custodyTradingOrg.getEmployeeDirectory().addEmployee("Trading Manager");
        UserAccount tradingManagerAccount = custodyTradingOrg.getUserAccountDirectory().addUserAccount("tm", "tm", tradingManager, new TradingManager());
        
        Employee actAssistant =custodyAccountingOrg.getEmployeeDirectory().addEmployee("Accounting Assistant");
        UserAccount actAssistantAccount = custodyAccountingOrg.getUserAccountDirectory().addUserAccount("aa", "aa", actAssistant, new AccountingAssistant());
        
        Employee customerServiceManager =custodyCustomerServiceOrg.getEmployeeDirectory().addEmployee("CustomerService Manager");
        UserAccount customerServiceManagerAccount = custodyCustomerServiceOrg.getUserAccountDirectory().addUserAccount("sm", "sm", customerServiceManager, new CustomerServiceManager());
        
        CustodyEnterprise custodyEnterprise2 = (CustodyEnterprise)ecoSystem.getEnterpriseNetwork().addEnterprise(Enterprise.Type.CustodyEnterprise,"custodyEnterprise 2");
        custodyEnterprise2.setMaxAmount(60);
        custodyEnterprise2.setMinAmount(20);
        custodyEnterprise2.setRate(0.02);
        Organization custody2InvoiceOrg = custodyEnterprise2.getOrganizationDirectory().addOrganization(Organization.Type.CustomerService);
        
        CoinCollection bitCoinCollection = new CoinCollection();
        bitCoinCollection.addCoin("Bitcoin","K1Y568RY","Universal Bank", "Mogan");    
        bitCoinCollection.addCoin("Bitcoin","K1Y569RY","Universal Bank", "Mogan");    
        bitCoinCollection.addCoin("Bitcoin","K1Y570RY","Universal Bank", "Mogan");    
        bitCoinCollection.addCoin("Bitcoin","K1Y571RY","Universal Bank", "Mogan");    
        bitCoinCollection.addCoin("Bitcoin","K1Y572RY","Universal Bank", "Mogan");
        bitCoinCollection.addCoin("Bitcoin","K1Y573RY","Universal Bank", "Mogan");
        bitCoinCollection.addCoin("Bitcoin","K1Y574RY","Universal Bank", "Mogan");
        bitCoinCollection.addCoin("Bitcoin","K1Y575RY","Universal Bank", "Mogan");
        bitCoinCollection.addCoin("Bitcoin","K1Y576RY","Universal Bank", "Mogan");
        depositEnterprise.getFinancialAccountDirectory().addCompleteFinancialAccount("Mogan", bitCoinCollection, 1000000.00);
      
        //add tansaction history
        for(Coin coin: depositEnterprise.getFinancialAccountDirectory().getFinancialAccount("Mogan").getCoinCollection().getCoinList()){
            depositEnterprise.getTransactionHistory().createTransaction(coin.getCoinKey(), coin.getPrevOwnership(), coin.getCurOwnership(), coin.getType());
        }
        
        CoinCollection bitCoinCollection2 = new CoinCollection();
        bitCoinCollection2.addCoin("Bitcoin","U9H45E32","Universal Bank", "Franklin");
        bitCoinCollection2.addCoin("Bitcoin","U9H45E33","Universal Bank", "Franklin");  
        bitCoinCollection2.addCoin("Bitcoin","U9H45E34","Universal Bank", "Franklin");  
        bitCoinCollection2.addCoin("Bitcoin","U9H45E35","Universal Bank", "Franklin");  
        bitCoinCollection2.addCoin("Bitcoin","U9H45E36","Universal Bank", "Franklin");
        bitCoinCollection2.addCoin("Bitcoin","U9H45E37","Universal Bank", "Franklin"); 
        bitCoinCollection2.addCoin("Bitcoin","U9H45E38","Universal Bank", "Franklin"); 
        bitCoinCollection2.addCoin("Bitcoin","U9H45E39","Universal Bank", "Franklin"); 
        bitCoinCollection2.addCoin("Bitcoin","U9H45E40","Universal Bank", "Franklin"); 
        depositEnterprise.getFinancialAccountDirectory().addCompleteFinancialAccount("Franklin", bitCoinCollection2, 1200000.00);    
        
        for(Coin coin: depositEnterprise.getFinancialAccountDirectory().getFinancialAccount("Franklin").getCoinCollection().getCoinList()){
            depositEnterprise.getTransactionHistory().createTransaction(coin.getCoinKey(), coin.getPrevOwnership(), coin.getCurOwnership(), coin.getType());
        }
        
        
        //add tansaction history
        CoinCollection bitCoinCollection3 = new CoinCollection();
        depositEnterprise.getFinancialAccountDirectory().addCompleteFinancialAccount("custodyEnterprise 1", bitCoinCollection3, 1400000.00);
      
        
        /*** Work Request ***/  
//        InvestmentWorkRequest request = new InvestmentWorkRequest();
//        request.setMessage("");
//        request.setType("Buy");
//        request.setSender(investManegerAccount);
//        request.setStatus("Established");
//        request.setAmount(10);
//        request.setPrice(7848.43);       
//        investManegerAccount.getWorkQueue().addWorkRequest(request);
//        investmentInvestOrg.getWorkQueue().addWorkRequest(request);
//        
//        InvestmentWorkRequest request2 = new InvestmentWorkRequest();
//        request2.setMessage("");
//        request2.setType("Sell");
//        request2.setSender(accountingManagerAccount);
//        request2.setStatus("Pending(Assigned)");
//        request2.setAmount(15);
//        request2.setPrice(7649.25);       
//        accountingManagerAccount.getWorkQueue().addWorkRequest(request2);
//        investmentAccounOrg.getWorkQueue().addWorkRequest(request2);

//        InvestmentWorkRequest request3 = new InvestmentWorkRequest();
//        request3.setMessage("");
//        request3.setType("Sell");
//        request3.setSender(actAssistantAccount);
//        request3.setStatus("Verifying(Assigned)");
//        request3.setAmount(2);
//        request3.setPrice(7649.25);       
//        request3.setInvestmentEnterprise("Mogan");
//        actAssistantAccount.getWorkQueue().addWorkRequest(request3);
//        custodyTradingOrg.getWorkQueue().addWorkRequest(request3);
//        
//        InvestmentWorkRequest request4 = new InvestmentWorkRequest();
//        request4.setMessage("");
//        request4.setType("Buy");
//        request4.setSender(actAssistantAccount);
//        request4.setStatus("Verifying(Assigned)");
//        request4.setAmount(1);
//        request4.setPrice(7649.25);    
//        request4.setInvestmentEnterprise("Franklin");
//        actAssistantAccount.getWorkQueue().addWorkRequest(request4);
//        custodyTradingOrg.getWorkQueue().addWorkRequest(request4);
        
        uploadExistedOrder(transactionOrg, investmentInvestOrg, custodyCustomerServiceOrg);        
        uploadExistedOrder3(transactionOrg, FinvestmentInvestOrg, custodyCustomerServiceOrg);
        
        }         
        return ecoSystem;
    }
    public static void uploadExistedOrder(Organization org, Organization investOrg, Organization CustomerServiceOrg){
        boolean fail = false;
        try {                   
            BufferedReader reader = new BufferedReader(new FileReader("WorkRequest input.csv"));
            String line = null;           
            while((line=reader.readLine())!=null){//read the .csv by each line
                String item[] = line.split(",");//separate each line based on ','
                
                InvestmentWorkRequest workRequest = new InvestmentWorkRequest();
                workRequest.setMessage("");
                workRequest.setType(item[0]);
                workRequest.setStatus(item[1]);
                workRequest.setAmount(Integer.parseInt(item[2]));
                workRequest.setInitialAmount(Integer.parseInt(item[2]));
                workRequest.setPrice(Integer.parseInt(item[3]));    
                workRequest.setInvestmentEnterprise(item[4]);
                workRequest.setCustodyEnterprise(item[5]);
                org.getWorkQueue().addWorkRequest(workRequest);
                investOrg.getWorkQueue().addWorkRequest(workRequest);
                CustomerServiceOrg.getWorkQueue().addWorkRequest(workRequest);
                                                             
                fail = true;             
            }
        } catch (Exception a){
            JOptionPane.showMessageDialog(null,"The file is wrong or not existed.");
        }
        if(fail == true)
        return;
    }
    
    public static void uploadExistedOrder2(Organization org, Organization investOrg, Organization CustomerServiceOrg){
        boolean fail = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("WorkRequest2 input.csv"));
            String line = null;
            while((line=reader.readLine())!=null){//read the .csv by each line
                String item[] = line.split(",");//separate each line based on ','
                
                InvestmentWorkRequest workRequest = new InvestmentWorkRequest();
                workRequest.setMessage("");
                workRequest.setType(item[0]);
                workRequest.setStatus(item[1]);
                workRequest.setAmount(Integer.parseInt(item[2]));
                workRequest.setInitialAmount(Integer.parseInt(item[2]));
                workRequest.setPrice(Integer.parseInt(item[3]));    
                workRequest.setInvestmentEnterprise(item[4]);
                workRequest.setCustodyEnterprise(item[5]);
                org.getWorkQueue().addWorkRequest(workRequest);
                investOrg.getWorkQueue().addWorkRequest(workRequest);
                CustomerServiceOrg.getWorkQueue().addWorkRequest(workRequest);
                                                             
                fail = true;             
            }
        } catch (Exception a){
            JOptionPane.showMessageDialog(null,"The file is wrong or not existed.");
        }
        if(fail == true)
        return;
    }
    
    public static void uploadExistedOrder3(Organization org, Organization investOrg, Organization customerServiceOrg){
        boolean fail = false;
        try {                   
            BufferedReader reader = new BufferedReader(new FileReader("WorkRequest3 input.csv"));
            String line = null;           
            while((line=reader.readLine())!=null){//read the .csv by each line
                String item[] = line.split(",");//separate each line based on ','
                
                InvestmentWorkRequest workRequest = new InvestmentWorkRequest();
                workRequest.setMessage("");
                workRequest.setType(item[0]);
                workRequest.setStatus(item[1]);
                workRequest.setAmount(Integer.parseInt(item[2]));
                workRequest.setInitialAmount(Integer.parseInt(item[2]));
                workRequest.setPrice(Integer.parseInt(item[3]));    
                workRequest.setInvestmentEnterprise(item[4]);
                workRequest.setCustodyEnterprise(item[5]);
                org.getWorkQueue().addWorkRequest(workRequest);
                investOrg.getWorkQueue().addWorkRequest(workRequest);
                customerServiceOrg.getWorkQueue().addWorkRequest(workRequest);
                 
                fail = true;             
            }
        } catch (Exception a){
            JOptionPane.showMessageDialog(null,"The file is wrong or not existed.");
        }
        if(fail == true)
        return;
    }
    
}
