/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webflight.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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
import webflight.domain.FlightManager;

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
    public ModelAndView searchFlight(@ModelAttribute
                            FlightSearch flightSearch, BindingResult result) {
         
        ModelAndView displayMV = new ModelAndView("display");
        
        // Get bound FlightSearch form variables
        String fromDest = flightSearch.getFromDest();
        String toDest = flightSearch.getToDest();
        String fromDay = flightSearch.getFromDay();
        
        FlightManager flightManager = new FlightManager(flightDao);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        
        try {
            
            Date fromDate = dateFormat.parse("2012-08-"+flightSearch.getFromDay());
            
            // Search for all flights from the origin to the destination flying out at the given date
            ArrayList<FlightPath> flights = flightManager.getFlightPaths(fromDest, toDest, fromDate);
        
            // Sort the search result into ascending order based on price
            Collections.sort(flights, new FlightPathPriceComparator());
        
            displayMV.addObject("flights", flights);
            displayMV.addObject("fromDest", fromDest);
            displayMV.addObject("toDest", toDest);
            displayMV.addObject("fromDate", fromDate);
         
        } catch (ParseException e) {
            
        }
        
        return displayMV;

    }
     
    @RequestMapping("/search")
    public ModelAndView showSearch() {
         
        ModelAndView mv = new ModelAndView("search");
        
        FlightManager flightManager = new FlightManager(flightDao);
        
        // Allowable dates (DAY_OF_THE_MONTH)
        List<String> dayList = Arrays.asList("8", "9", "10");
        
        // Get list of possible origins and destinations from flightManager
        ArrayList<String> fromList = flightManager.getFromList();
        ArrayList<String> toList = flightManager.getToList();
        
        // Sort into alphabetical order to present in drop down boxes
        Collections.sort(fromList);
        Collections.sort(toList);
        
        mv.addObject("command", new FlightSearch());
        mv.addObject("fromList", fromList);
        mv.addObject("toList", toList);
        mv.addObject("dayList", dayList);
        
        return mv;
    }
    
    public FlightDao getFlightDao() {
        return flightDao;
    }
    
    public void setFlightDao() {
        this.flightDao = flightDao;
    }
}
