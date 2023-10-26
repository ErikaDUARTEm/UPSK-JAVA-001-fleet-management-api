package com.api.fleetManagement.service;

import com.api.fleetManagement.model.Taxi;
import com.api.fleetManagement.model.Trajectories;
import com.api.fleetManagement.repository.TaxiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.fleetManagement.Dto.TaxiAllTrajectoriesDTO;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


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

    //método que devuelve todas las trayectorias de un taxi por fecha.
    public List<TaxiAllTrajectoriesDTO> getAllTrajectories(int id, Date fecha) {
        Taxi taxi = taxiRepository.findById(id);

        if (taxi != null) {
            List<Trajectories> allTrajectories = taxi.getTrajectories();
            List<TaxiAllTrajectoriesDTO> filteredTrajectories = new ArrayList<>();

            for (Trajectories trajectory : allTrajectories) {
                if (trajectory.getFecha().equals(fecha)) {
                    Date fechaTrajectory = trajectory.getFecha();
                    Time horaTrajectory = trajectory.getHora();
                    double latitudTrajectory = trajectory.getLatitud();
                    double longitudTrajectory = trajectory.getLongitud();

                    Date fechaFormateada = new Date(fechaTrajectory.getTime());
                    TaxiAllTrajectoriesDTO trajectoryDTO = new TaxiAllTrajectoriesDTO(fechaFormateada, horaTrajectory, latitudTrajectory, longitudTrajectory);
                    filteredTrajectories.add(trajectoryDTO);

                }
            }
            return filteredTrajectories;
        } else {
            return Collections.emptyList();
        }
    }
}
