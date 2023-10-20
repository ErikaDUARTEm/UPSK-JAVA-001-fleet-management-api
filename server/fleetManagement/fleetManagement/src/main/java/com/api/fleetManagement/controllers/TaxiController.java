package com.api.fleetManagement.controllers;

import com.api.fleetManagement.model.Taxi;
import com.api.fleetManagement.service.TaxiService;
import com.api.fleetManagement.service.TrajectoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@Configuration
@RestController
@RequestMapping("taxiApi")
public class TaxiController {

    private final TaxiService taxiService;


    @Autowired
    public TaxiController(TaxiService taxiService) {
        this.taxiService = taxiService;

    }

    @GetMapping("/taxi/{id}")
        public Taxi getTaxiById(@PathVariable int id) {
            return taxiService.getTaxiById(id);
        }

    @GetMapping("/placa/{placa}")
        public Taxi getTaxiByPlaca(@PathVariable String placa){return taxiService.getTaxiByPlaca(placa);}

}
