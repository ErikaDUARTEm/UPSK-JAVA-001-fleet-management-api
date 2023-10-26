package com.api.fleetManagement.service;

import com.api.fleetManagement.model.Taxi;
import com.api.fleetManagement.model.Trajectories;
import com.api.fleetManagement.repository.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrajectoriesService {
    private final TrajectoriesRepository trajectoriesRepository;

    @Autowired
    public TrajectoriesService(TrajectoriesRepository trajectoriesRepository) {
        this.trajectoriesRepository = trajectoriesRepository;
    }



}
