
package webflight.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import webflight.domain.Flight;

/**
 *
 * @author Daniel Marshall
 */

public class JdbcFlightDao implements FlightDao { 
    
    private DataSource dataSource;
    
    public DataSource getDataSource() {
        return dataSource;
    }
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public List<Flight> getAllFlights() {
        JdbcTemplate select = new JdbcTemplate(dataSource);
		return select.query("select fromDest, toDest, price, fromDate from FLIGHT",
				new FlightMapper());   
    }
    
    private static class FlightMapper implements RowMapper {
    
        public Flight mapRow(ResultSet rs, int i) throws SQLException {
        
            Flight flight = new Flight();
            flight.setFromDest(rs.getString("fromDest"));
            flight.setToDest(rs.getString("toDest"));
            flight.setPrice(rs.getDouble("price"));
            flight.setFromDate(rs.getDate("fromDate"));
        
            return flight;
        
        }
    }
}
