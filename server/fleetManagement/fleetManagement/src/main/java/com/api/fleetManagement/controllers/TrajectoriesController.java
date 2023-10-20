package com.api.fleetManagement.controllers;

import com.api.fleetManagement.model.Trajectories;
import com.api.fleetManagement.service.TrajectoriesService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

@Configuration
@RestController
@RequestMapping("trajectoriesApi")
public class TrajectoriesController {
    private final TrajectoriesService trajectoriesService;

    public TrajectoriesController(TrajectoriesService trajectoriesService) {
        this.trajectoriesService = trajectoriesService;
    }

    @GetMapping("/trajectories/{taxiId}")
    public Trajectories findLastLocationByTaxiId(@PathVariable("taxiId") int taxiId) {
        return trajectoriesService.findLastLocationByTaxiId(taxiId);
    }
}