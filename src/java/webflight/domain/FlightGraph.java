
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
    
    public FlightGraph(FlightDao flightDao) {
        // store all valid paths
        flightPaths = new ArrayList<FlightPath>();
        
        // get flights from the database
        allFlights = (ArrayList<Flight>) flightDao.getAllFlights();
        
    }
    
    public void nextFlight(ArrayList<Flight> currentPath, ArrayList<String> visited, String fromDest, String toDest) {
        
        System.out.println("nextflight! " + visited.toString());
        
        Flight recentFlight = currentPath.get(currentPath.size() - 1);
        
        // Are we at our destination?
        
        if (recentFlight.getToDest().equals(toDest)) {
            
            System.out.println(recentFlight.getToDest());
                        
            ArrayList<Flight> goodPath = new ArrayList<Flight>();
                        
            for(Flight copyFlight : currentPath) {
                goodPath.add(copyFlight);
            }
                        
            flightPaths.add(new FlightPath(goodPath));
            
            System.out.println(""+flightPaths.size());
            
        } else {
        
            for(Flight flight : allFlights) {
            
                // Is the fromDest of the flight connected to the toDest of the previous flight?
                if (recentFlight.getToDest().equals(flight.getFromDest())) {
                    // Is the flight going somewhere we have already been?
                    if (!visited.contains(flight.getToDest())) {
                        // Is the flight not too far in the future?
                        if (flight.getFromDate().getDay() <= (recentFlight.getFromDate().getDay() + 1)) {
                            // Is the flight not in the past?
                            if (flight.getFromDate().getDay() >= recentFlight.getFromDate().getDay()) {
                                
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
        
        for(Flight flighta : allFlights) {
            
            // If flight leaves from the right destination
            if (flighta.getFromDest().equals(fromDest)) {
                // If flight leaves on the right day (TODO: add time)
                System.out.println(flighta.getFromDate().getDate()+" "+fromDate.getDate());
                if (flighta.getFromDate().getDate() == fromDate.getDate()) {
                    
                    ArrayList<Flight> currentPath = new ArrayList<Flight>();
                    ArrayList<String> visited = new ArrayList<String>();
                
                    currentPath.add(flighta);
                    visited.add(flighta.getFromDest());
                    visited.add(flighta.getToDest());
                
                    nextFlight(currentPath, visited, fromDest, toDest);
                }
            }
        }
        
        return flightPaths;
    }
    
    public ArrayList<String> getFromList() {
        
        ArrayList<String> fromList = new ArrayList<String>();
        
        for(Flight flight : allFlights) {
            if(!fromList.contains(flight.getFromDest())) {
                fromList.add(flight.getFromDest());
            }
        }
        
        return fromList;
    }
    
    public ArrayList<String> getToList() {
        
        ArrayList<String> toList = new ArrayList<String>();
        
        for(Flight flight : allFlights) {
            if(!toList.contains(flight.getToDest())) {
                toList.add(flight.getToDest());
            }
        }
        
        return toList;
    }
    
    public FlightDao getFlightDao() {
        return flightDao;
    }
    
    public void setFlightDao(FlightDao flightDao) {
        this.flightDao = flightDao;
    }
    
}
