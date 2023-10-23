package com.api.fleetManagement.controllers;

import com.api.fleetManagement.model.Taxi;
import com.api.fleetManagement.model.Trajectories;
import com.api.fleetManagement.service.TaxiService;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Configuration
@RestController
@RequestMapping("taxiApi")
public class TaxiController {

    private final TaxiService taxiService;
    private Taxi taxi;

    @Autowired
    public TaxiController(TaxiService taxiService) {
        this.taxiService = taxiService;

    }

    @GetMapping("/taxi/{id}")
        public Taxi getTaxiById(@PathVariable int id) {
            return taxiService.getTaxiById(id);
        }

    @GetMapping("/all/taxis")
    public Object getAll() {
        return taxiService.getAll();
    }

    @GetMapping("/last/trajectories/{id}")
    public List<Trajectories> getTrajector (@PathVariable int id){
        return taxiService.getTraject(id);
    }
}
