package com.api.fleetManagement.service;

import com.api.fleetManagement.model.Taxi;
import com.api.fleetManagement.model.Trajectories;
import com.api.fleetManagement.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.fleetManagement.Dto.TaxiAllTrajectoriesDTO;
import java.util.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class TaxiService {
    private final TaxiRepository taxiRepository;

    @Autowired
    public TaxiService(TaxiRepository taxiRepository) {
        this.taxiRepository = taxiRepository;
    }


    public Taxi getTaxiById(int id) {

        return taxiRepository.findById(id);
    }

    public List<Taxi> getAllTaxis() {
        return taxiRepository.findAll();
    }




}
