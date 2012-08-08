/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webflight.web;


import java.util.ArrayList;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import webflight.db.FlightDao;

import webflight.domain.FlightPath;
import webflight.domain.FlightPathPriceComparator;
import webflight.domain.FlightGraph;

/**
 *
 * @author Daniel Marshall
 */
 
@Controller
@SessionAttributes
public class SearchController {
    
    @Autowired
    private FlightDao flightDao;
    
    @RequestMapping(value = "/display", method = RequestMethod.POST)
    public ModelAndView searchFlight(@ModelAttribute("contact")
                            FlightSearch flightSearch, BindingResult result) {
         
        ModelAndView displayMV = new ModelAndView("display");
        
        System.out.println("First Name:" + flightSearch.getFromDest() + 
                    "Last Name:" + flightSearch.getToDest());
        
        String fromDest = flightSearch.getFromDest();
        String toDest = flightSearch.getToDest();
        
        FlightGraph flightGraph = new FlightGraph();
        flightGraph.setFlightDao(flightDao);
        
        // TODO: check destinations are ok
        
        ArrayList<FlightPath> flights = flightGraph.getFlightPaths(fromDest, toDest);
        
        Collections.sort(flights, new FlightPathPriceComparator());
        
        displayMV.addObject("flights", flights);
        displayMV.addObject("fromDest", fromDest);
        displayMV.addObject("toDest", toDest);
         
        return displayMV;

    }
     
    @RequestMapping("/search")
    public ModelAndView showSearch() {
         
        return new ModelAndView("search", "command", new FlightSearch());
    }
    
    public FlightDao getFlightDao() {
        return flightDao;
    }
    
    public void setFlightDao() {
        this.flightDao = flightDao;
    }
}
