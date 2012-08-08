
package webflight.domain;

import java.util.ArrayList;
import java.util.Date;

import webflight.db.FlightDao;

/**
 *
 * @author Daniel Marshall
 */

public class FlightGraph {
    
    private FlightDao flightDao;
    private ArrayList<FlightPath> flightPaths;
    ArrayList<Flight> allFlights;
    
    public FlightGraph(ArrayList<Flight> allFlights) {
    
        // List of valid paths
        flightPaths = new ArrayList<FlightPath>();
        
        // Set of all flights
        this.allFlights = allFlights;
        
    }
    
    public void nextFlight(ArrayList<Flight> currentPath, ArrayList<String> visited, String fromDest, String toDest) {
        
        Flight recentFlight = currentPath.get(currentPath.size() - 1);
        
        // Are we at our destination?
        if (recentFlight.getToDest().equals(toDest)) {

            // This is a valid flight path
            
            // Make a copy of the path and add it to the list of valid paths
            ArrayList<Flight> goodPath = new ArrayList<Flight>();
            for(Flight copyFlight : currentPath) {
                goodPath.add(copyFlight);
            }
            flightPaths.add(new FlightPath(goodPath));
            
        } else {
        
            for(Flight flight : allFlights) {
            
                // Is the fromDest of the flight connected to the toDest of the previous flight?
                if (recentFlight.getToDest().equals(flight.getFromDest())) {
                    
                    // Is the flight not going somewhere we have already been?
                    if (!visited.contains(flight.getToDest())) {
                        
                        // Is the flight not too long after the previous flight
                        if (flight.getFromDate().getDay() <= (recentFlight.getFromDate().getDay() + 1)) {
                            
                            // Is the flight not before the previous flight
                            if (flight.getFromDate().getDay() >= recentFlight.getFromDate().getDay()) {
                                
                                // This is a valid partial path
                                
                                // Recurse to continue building the path
                                currentPath.add(flight);
                                visited.add(flight.getToDest());
                    
                                nextFlight(currentPath, visited, fromDest, toDest);
                    
                                currentPath.remove(currentPath.size() - 1);
                                visited.remove(visited.size() - 1);
                                
                            }
                        }
                    }
                    
                }
            
            }
        }
        
    }
    
    public ArrayList<FlightPath> getFlightPaths(String fromDest, String toDest, Date fromDate) {
        
        // Look for valid starting points to constructing flight paths
        for(Flight firstFlight : allFlights) {
            
            // Is the flight leaving from the right destination?
            if (firstFlight.getFromDest().equals(fromDest)) {
                
                // Is the flight leaving on the right day? (TODO: add time)
                if (firstFlight.getFromDate().getDate() == fromDate.getDate()) {
                    
                    // This flight is a valid starting point
                    
                    // To store the current path under consideration
                    ArrayList<Flight> currentPath = new ArrayList<Flight>();
                    
                    // To keep track of places already visited (avoid loops)
                    ArrayList<String> visited = new ArrayList<String>();
                
                    currentPath.add(firstFlight);
                    visited.add(firstFlight.getFromDest());
                    visited.add(firstFlight.getToDest());
                
                    // Begin the recursion
                    nextFlight(currentPath, visited, fromDest, toDest);
                }
            }
        }
        
        return flightPaths;
    }
    
}
