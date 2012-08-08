
package webflight.db;

import java.sql.Timestamp;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import webflight.domain.Flight;

/**
 *
 * @author Daniel Marshall
 */
public class MemoryFlightDao implements FlightDao {
    
    public ArrayList<Flight> getAllFlights() {
    
        ArrayList<Flight> allFlights = new ArrayList<Flight>();
        
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd");
        
        try {
            
            allFlights.add(new Flight("Brisbane","Guangzhou",500.0, dateFormat.parse("2012-08-08")));
            allFlights.add(new Flight("Guangzhou","Beijing",150.0, dateFormat.parse("2012-08-08")));
            allFlights.add(new Flight("Brisbane","Shanghai",600.0, dateFormat.parse("2012-08-08")));
            allFlights.add(new Flight("Shanghai","Beijing",100.0, dateFormat.parse("2012-08-08")));
            allFlights.add(new Flight("Melbourne", "Guangzhou", 575.0, dateFormat.parse("2012-08-08")));
            allFlights.add(new Flight("Melbourne", "Brisbane", 100.0, dateFormat.parse("2012-08-08")));
            allFlights.add(new Flight("Brisbane", "Melbourne", 100.0, dateFormat.parse("2012-08-08")));
            allFlights.add(new Flight("Brisbane", "Beijing", 1000.0, dateFormat.parse("2012-08-08")));
            allFlights.add(new Flight("Brisbane", "Melbourne", 120.0, dateFormat.parse("2012-08-08")));
            allFlights.add(new Flight("Melbourne", "Guangzhou", 275.0, dateFormat.parse("2012-08-09")));
            allFlights.add(new Flight("Guangzhou","Beijing",150.0, dateFormat.parse("2012-08-09")));
            allFlights.add(new Flight("Brisbane","Guangzhou",500.0, dateFormat.parse("2012-08-09")));
            allFlights.add(new Flight("Brisbane", "Melbourne", 50.0, dateFormat.parse("2012-08-09")));
        
        } catch (ParseException e) {
            
        }
        
        return allFlights;
    }
}
