package com.example.pat.controlleurs;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String afficherAccueil() {
        return "home";  // Retourne la vue home.html
    }
}
