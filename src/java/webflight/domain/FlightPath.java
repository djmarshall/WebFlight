/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webflight.domain;

import java.util.ArrayList;

/**
 *
 * @author Daniel Marshall
 */

public class FlightPath {
    
    private ArrayList<Flight> flightList;
    private double price;
    
    public FlightPath() {
        
    }
    
    private void calculatePrice() {
        
        price = 0.0;
        for(Flight flight : flightList) {
            price = price + flight.getPrice();
        }
        
    }
    
    public FlightPath(ArrayList<Flight> flightList) {
        this.flightList = flightList;
        calculatePrice();
    }
    
    public ArrayList<Flight> getFlightList() {
        return flightList;
    }
    
    public double getPrice() {
        return price;
    }
    
    public String getFromDest() {
        return flightList.get(0).getFromDest();
    }
    
    public String getToDest() {
        return flightList.get(flightList.size() - 1).getToDest();
    }
    
}
