package com.api.fleetManagement.controllers;

import com.api.fleetManagement.Dto.TaxiAllTrajectoriesDTO;

import com.api.fleetManagement.service.TrajectoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Configuration
@RestController
@RequestMapping("/allTrajectoriesByDate")

public class AllRoutesByTaxiAndDateController {

    private final TrajectoriesService trajectoriesService;
    @Autowired
    public AllRoutesByTaxiAndDateController(TrajectoriesService trajectoriesService) {
        this.trajectoriesService = trajectoriesService;
    }

    @GetMapping("/all")
    public List<TaxiAllTrajectoriesDTO> getAllTrajectories (@RequestParam("id") int id, @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd")Date date)  {
        return trajectoriesService.getAllTrajectories(id,date);
    }

}
