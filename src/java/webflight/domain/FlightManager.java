
package webflight.domain;

import java.util.ArrayList;
import java.util.Date;

import webflight.db.FlightDao;

/**
 *
 * @author Daniel Marshall
 */
public class FlightManager {
    
    private FlightDao flightDao;
    
    // To store all flights
    ArrayList<Flight> allFlights;
    
    public FlightManager(FlightDao flightDao) {
        
        // get flights from the database
        // TODO: access flights by date range
        allFlights = (ArrayList<Flight>) flightDao.getAllFlights();
    }
    
    public ArrayList<FlightPath> getFlightPaths(String fromDest, String toDest, Date fromDate) {
        
        // Build a FlightGraph to search for and return all valid FlightPaths
        
        FlightGraph flightGraph = new FlightGraph(allFlights);
        
        return flightGraph.getFlightPaths(fromDest, toDest, fromDate);
    }
    
    public ArrayList<String> getFromList() {
        
        // Return a list of all possible origins from the set of all flights
        
        ArrayList<String> fromList = new ArrayList<String>();
        
        for(Flight flight : allFlights) {
            if(!fromList.contains(flight.getFromDest())) {
                fromList.add(flight.getFromDest());
            }
        }
        
        return fromList;
    }
    
    public ArrayList<String> getToList() {
        
        // Return a list of all possible destinations from the set of all flights
        
        ArrayList<String> toList = new ArrayList<String>();
        
        for(Flight flight : allFlights) {
            if(!toList.contains(flight.getToDest())) {
                toList.add(flight.getToDest());
            }
        }
        
        return toList;
    }
    
}
