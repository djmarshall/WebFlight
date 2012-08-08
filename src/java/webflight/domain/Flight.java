/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webflight.domain;

/**
 *
 * @author Daniel Marshall
 */
public class Flight {
    
    private String fromDest;
    private String toDest;
    private double price;
    
    public String getFromDest() {
        return fromDest;
    }
    
    public void setFromDest(String fromDest) {
        this.fromDest = fromDest;
    }
    
    public String getToDest() {
        return toDest;
    }
    
    public void setToDest(String toDest) {
        this.toDest = toDest;
    }
    
    public double getPrice() {
        return price;
    }
    
    public void setPrice(double price) {
            this.price = price;
    }
    
}
