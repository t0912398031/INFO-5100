/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lingfengzhou
 */
public class ShortMessageQueue {
    
    private List<ShortMessage> messageList;

    public ShortMessageQueue() {
        messageList = new ArrayList<>();
    }
    
    

    public List<ShortMessage> getMessageList() {
        return messageList;
    }
    
    public void addMessage(ShortMessage shortMessage){
        messageList.add(shortMessage);
    }
    
    public ShortMessage addSendMessage(UserAccount sender, UserAccount receiver, String message){
        ShortMessage sm = new ShortMessage(sender, receiver, message);
        messageList.add(sm);
        return sm;
    }
    
    public ShortMessage addBroadcastMessage(UserAccount sender, List<UserAccount> revAccounts, String broadcastMessage){
        ShortMessage sm = new ShortMessage(sender, revAccounts, broadcastMessage);
        messageList.add(sm);
        return sm;
    }
    
    public List<ShortMessage> searchUnreadMessage(UserAccount rev){
        List<ShortMessage> unreadMessages = new ArrayList<>();
        String unread = "unread";
        for(ShortMessage s:this.messageList){
            if(s.getReceiver().equals(rev)&&s.getStatus().equalsIgnoreCase(unread))
                unreadMessages.add(s);
        }
        return unreadMessages;
    }
    
}
