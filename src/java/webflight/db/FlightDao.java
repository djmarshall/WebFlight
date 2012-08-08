/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webflight.db;


import java.util.List;
import javax.sql.DataSource;

import webflight.domain.Flight;

/**
 *
 * @author Daniel Marshall
 */
public interface FlightDao {
    
    public List<Flight> getAllFlights();
    
}


