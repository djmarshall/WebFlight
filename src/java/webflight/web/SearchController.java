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
    public ModelAndView searchFlight(@ModelAttribute
                            FlightSearch flightSearch, BindingResult result) {
         
        ModelAndView displayMV = new ModelAndView("display");
        
        String fromDest = flightSearch.getFromDest();
        String toDest = flightSearch.getToDest();
        String fromDay = flightSearch.getFromDay();
        
        System.out.println(fromDay);
        
        FlightGraph flightGraph = new FlightGraph(flightDao);
        
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd");
        
        try {
            
            System.out.println("2012-08-"+flightSearch.getFromDay());
            Date fromDate = dateFormat.parse("2012-08-"+flightSearch.getFromDay());
            ArrayList<FlightPath> flights = flightGraph.getFlightPaths(fromDest, toDest, fromDate);
        
            Collections.sort(flights, new FlightPathPriceComparator());
        
            displayMV.addObject("flights", flights);
            displayMV.addObject("fromDest", fromDest);
            displayMV.addObject("toDest", toDest);
         
        } catch (ParseException e) {
            
        }
        
        return displayMV;

    }
     
    @RequestMapping("/search")
    public ModelAndView showSearch() {
         
        ModelAndView mv = new ModelAndView("search");
        
        FlightGraph flightGraph = new FlightGraph(flightDao);
        
        List<String> dayList = Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
                "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31");
        
        mv.addObject("command", new FlightSearch());
        mv.addObject("fromList", flightGraph.getFromList());
        mv.addObject("toList", flightGraph.getToList());
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
