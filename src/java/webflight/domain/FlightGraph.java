/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webflight.domain;

import java.util.ArrayList;
import webflight.db.FlightDao;

/**
 *
 * @author Daniel Marshall
 */

public class FlightGraph {
    
    private FlightDao flightDao;
    
    public ArrayList<FlightPath> getFlightPaths(String fromDest, String toDest) {
        
        // Get flights from database
        ArrayList<Flight> allFlights = (ArrayList<Flight>) flightDao.getAllFlights();
        
        // valid flight paths stored here
        ArrayList<FlightPath> flightPaths = new ArrayList<FlightPath>();
        
        for(Flight flighta : allFlights) {
            
            // TODO: For each flight, try and build the longest chain...
            
            for(Flight flightb : allFlights) {
                
                if (flighta.getToDest().equals(flightb.getFromDest())) {
                
                    ArrayList<Flight> thisPath = new ArrayList<Flight>();
                    thisPath.add(flighta);thisPath.add(flightb);
                
                    FlightPath fp = new FlightPath(thisPath);
                
                    if (fp.getFromDest().equals(fromDest) && fp.getToDest().equals(toDest)) {
                        flightPaths.add(fp);
                    }
                }
                
            }
        }
        
        // NEXT: find best paths from fromDest to toDest
            // CURRENT: naive permutations on sets of two
        
        return flightPaths;
    }
    
    public FlightDao getFlightDao() {
        return flightDao;
    }
    
    public void setFlightDao(FlightDao flightDao) {
        this.flightDao = flightDao;
    }
    
}
