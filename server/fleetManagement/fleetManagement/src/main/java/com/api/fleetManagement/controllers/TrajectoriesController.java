package com.api.fleetManagement.controllers;
import com.api.fleetManagement.service.TrajectoriesService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Configuration
@RestController
@RequestMapping("trajectoriesApi")
public class TrajectoriesController {
    private final TrajectoriesService trajectoriesService;

    public TrajectoriesController(TrajectoriesService trajectoriesService) {
        this.trajectoriesService = trajectoriesService;
    }



}