package com.api.fleetManagement.controllers;

import com.api.fleetManagement.model.Trajectories;
import com.api.fleetManagement.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;

@Configuration
@RestController
@RequestMapping("allLocations")
public class AllLocationsController {

    private final TaxiService taxiService;
    @Autowired
    public AllLocationsController(TaxiService taxiService) {
        this.taxiService = taxiService;
    }
    @GetMapping("all/{id}/{fecha}")
    public List<Trajectories> getAllTrajectories (@PathVariable int id, @PathVariable Date fecha) {
        return taxiService.getAllTrajectories(id, fecha);
    }
}
