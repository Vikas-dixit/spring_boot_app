package com.dixitdada.journalApp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheck {

   @GetMapping("/HEALTH_CHECK")
   public String  healthCheck()
    {
        return "ok";
    }
}
