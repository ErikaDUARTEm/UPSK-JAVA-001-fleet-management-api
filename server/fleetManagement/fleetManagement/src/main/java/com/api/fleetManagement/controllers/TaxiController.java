package com.api.fleetManagement.controllers;

import com.api.fleetManagement.model.Taxi;
import com.api.fleetManagement.service.TaxiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping(path = "/all/taxis", params = {"!page", "!size"})
    public Page<Taxi> getAllTaxis() {
        Pageable pageable = PageRequest.of(0, 100, Sort.by(Sort.Direction.ASC, "id"));
        return taxiService.getAllTaxis(pageable);
    }


}
