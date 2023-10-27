package com.api.fleetManagement.controllers;

import com.api.fleetManagement.service.TrajectoriesService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@RestController
@RequestMapping("lastTrajectory")
public class LastTrajectoryByTaxiController {
    private final TrajectoriesService trajectoriesService;

    public LastTrajectoryByTaxiController (TrajectoriesService trajectoriesService) {
        this.trajectoriesService = trajectoriesService;
    }
}
