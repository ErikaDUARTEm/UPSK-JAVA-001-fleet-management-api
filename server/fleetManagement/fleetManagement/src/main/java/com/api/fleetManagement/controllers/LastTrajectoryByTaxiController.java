package com.api.fleetManagement.controllers;

import com.api.fleetManagement.Dto.LastTrajectoryDTO;
import com.api.fleetManagement.service.TrajectoriesService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Configuration
@RestController
@RequestMapping("lastTrajectory")
public class LastTrajectoryByTaxiController {
    private final TrajectoriesService trajectoriesService;

    public LastTrajectoryByTaxiController (TrajectoriesService trajectoriesService) {
        this.trajectoriesService = trajectoriesService;
    }
    @GetMapping("/Last")
    public List<LastTrajectoryDTO> lastTrajectory(){
        return trajectoriesService.lastTrajectory();
    }
}
