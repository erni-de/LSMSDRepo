/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package it.unipi.weblsmsd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author erni
 */
@Controller
public class HomeController {
    
    @GetMapping("/")
    public String getHomePage() {
        return "home"; // this corresponds to the map.html page in templates
    }
}
