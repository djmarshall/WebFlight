
package webflight.db;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

import java.net.UnknownHostException;

import java.util.ArrayList;
import java.util.Date;
import webflight.domain.Flight;

/**
 *
 * @author Daniel Marshall
 */

public class MongoFlightDao implements FlightDao {
    
    public ArrayList<Flight> getAllFlights() {
    
        ArrayList<Flight> allFlights = new ArrayList<Flight>();
        
        try {
            
            Mongo mongo = new Mongo("localhost", 27017);
            DB db = mongo.getDB("flights");
            DBCollection flightColl = db.getCollection("flight");
            
            DBCursor cur = flightColl.find();
            System.out.println("cursor" + cur.size());
            
            for (DBObject dbo : cur.toArray()) {
                allFlights.add(fromDBObject(dbo));
            }
            
        } catch (UnknownHostException e) {
            
        }
        
        return allFlights;
    }
    
    private Flight fromDBObject(DBObject dbo) {
        
        Flight flight = new Flight();
        
        flight.setFromDest((String)dbo.get("fromDest"));
        flight.setToDest((String)dbo.get("toDest"));
        flight.setPrice((Double)dbo.get("price"));
        flight.setFromDate((Date)dbo.get("fromDate"));
    
        return flight;
    }
    
}
