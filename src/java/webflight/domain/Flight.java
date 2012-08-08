/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webflight.domain;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Daniel Marshall
 */
public class Flight {
    
    // Origin
    private String fromDest;
    
    // Destination
    private String toDest;
    
    // Flight price
    private double price;
    
    // Date flight leaves (TODO: add time)
    private Date fromDate;
    
    public Flight() {
        
    }
    
    public Flight(String fromDest, String toDest, double price, Date fromDate) {
        
        this.fromDest = fromDest;
        this.toDest = toDest;
        this.price = price;
        this.fromDate = fromDate;
    }
    
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
    
    public Date getFromDate() {
        return fromDate;
    }
    
    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }
    
}
