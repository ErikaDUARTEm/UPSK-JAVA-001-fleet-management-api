package com.api.fleetManagement.controllers;

import com.api.fleetManagement.Dto.TaxiAllTrajectoriesDTO;
import com.api.fleetManagement.service.TaxiService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Configuration
@RestController
@RequestMapping("/allTrajectoriesByDate")

public class allTrajectoriesByDateController {

    private final TaxiService taxiService;
    @Autowired
    public allTrajectoriesByDateController(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    @GetMapping()
    public List<TaxiAllTrajectoriesDTO> getAllTrajectories (@RequestParam("id") int id, @RequestParam("fecha") Date fecha)  {
        return taxiService.getAllTrajectories(id,fecha);
    }

}
