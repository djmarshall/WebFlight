/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webflight.domain;

import java.util.Comparator;

/**
 *
 * @author Daniel Marshall
 */
public class FlightPathPriceComparator implements Comparator<FlightPath> {
    
    @Override
    public int compare(FlightPath fp1, FlightPath fp2) {
        return (int) (fp1.getPrice() - fp2.getPrice());
    }
    
}
