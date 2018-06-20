/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Finance.Property;

/**
 *
 * @author lingfengzhou
 */
public abstract class Property {
    
    private final String type;
    private String prevOwnership;
    private String curOwnership;

    public Property(String type) {
        this.type = type;
    }

    public Property(String type, String prevOwnership, String curOwnership) {
        this.type = type;
        this.prevOwnership = prevOwnership;
        this.curOwnership = curOwnership;
    }
    
    
    
    
    public String getType() {
        return type;
    }

    public String getPrevOwnership() {
        return prevOwnership;
    }

    public void setPrevOwnership(String prevOwnership) {
        this.prevOwnership = prevOwnership;
    }

    public String getCurOwnership() {
        return curOwnership;
    }

    public void setCurOwnership(String curOwnership) {
        this.curOwnership = curOwnership;
    }

    
    
    
    
    
    
}
