package com.api.fleetManagement.controllers;

import com.api.fleetManagement.model.Taxi;
import com.api.fleetManagement.model.Trajectories;
import com.api.fleetManagement.service.TrajectoriesService;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Configuration
@RestController
@RequestMapping("trajectoriesApi")
public class TrajectoriesController {
    private final TrajectoriesService trajectoriesService;

    public TrajectoriesController(TrajectoriesService trajectoriesService) {
        this.trajectoriesService = trajectoriesService;
    }

    @GetMapping("/trajectories/{id}")
    public ResponseEntity<Trajectories> getTrajectoryById(@PathVariable int id) {
        Trajectories trajectory = trajectoriesService.getTaxiById(id);

        if (trajectory != null) {
            Taxi taxi = trajectory.getTaxi();
            return new ResponseEntity<>(new Trajectories(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}