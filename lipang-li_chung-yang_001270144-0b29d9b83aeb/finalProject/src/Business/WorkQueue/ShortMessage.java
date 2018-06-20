/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lingfengzhou
 */
public class ShortMessage extends WorkRequest{
    
    private static int counter=1000;
    private List<UserAccount> revList;
    
    public void initShortMessage(UserAccount sender) {
        this.setWorkNumber(counter);
        ++counter;
        this.setRequestDate(LocalDateTime.now());
        this.revList = new ArrayList<>();
        this.setStatus("unread");
        this.setSender(sender);
    }
    
    public ShortMessage(UserAccount sender) {
        initShortMessage(sender);
    }
    
    public ShortMessage(UserAccount sender,UserAccount receiver, String message) {
        initShortMessage(sender);
        this.setMessage(message);
        this.setReceiver(receiver);
    }
    
    public ShortMessage(UserAccount sender,List<UserAccount> revList,String broadcastMessage) {
        initShortMessage(sender);
        this.setMessage(broadcastMessage);
        this.revList = revList;
    }
    
    @Override
    public String toString(){
        return this.getMessage();
    }
    
    
}
