package com.api.fleetManagement.controllers;

import com.api.fleetManagement.Dto.TaxiAllTrajectoriesDTO;

import com.api.fleetManagement.model.Trajectories;
import com.api.fleetManagement.service.TrajectoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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
    public Page<TaxiAllTrajectoriesDTO> getAllTrajectories(
            @RequestParam("id") int id,
            @RequestParam("date") String dateStr,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "50") int size
    ) {
        try {
            Pageable pageable = PageRequest.of(page, size);
            return trajectoriesService.getAllTrajectories(id, dateStr, pageable);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


}
