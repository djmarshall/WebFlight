/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package webflight.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Daniel Marshall
 */
@Controller
public class MainController {
    
 
    @RequestMapping("/index")
    public ModelAndView helloWorld() {
 
        String message = "Hello World, Spring 3.0!";
        return new ModelAndView("index");
    }
    
}
