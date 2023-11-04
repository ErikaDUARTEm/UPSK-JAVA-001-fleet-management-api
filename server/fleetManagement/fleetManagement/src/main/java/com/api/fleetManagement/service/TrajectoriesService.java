package com.api.fleetManagement.service;

import com.api.fleetManagement.Dto.LastTrajectoryDTO;
import com.api.fleetManagement.Dto.TaxiAllTrajectoriesDTO;
import com.api.fleetManagement.model.Trajectories;
import com.api.fleetManagement.repository.TrajectoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class TrajectoriesService {
    private final TrajectoriesRepository trajectoriesRepository;

    @Autowired
    public TrajectoriesService(TrajectoriesRepository trajectoriesRepository) {
        this.trajectoriesRepository = trajectoriesRepository;
    }



    public List<TaxiAllTrajectoriesDTO> getAllTrajectories(int id, String dateStr) throws ParseException {

        List<Trajectories> allTrajectories = trajectoriesRepository.findTrajectoriesByTaxi_idAndDate(id, dateStr);

        List<TaxiAllTrajectoriesDTO> filterTrajectories = new ArrayList<>();

        if (!allTrajectories.isEmpty()) {
            for (Trajectories trajectory : allTrajectories) {
                System.out.println(trajectory.getDate());
                TaxiAllTrajectoriesDTO dto = new TaxiAllTrajectoriesDTO(trajectory.getDate(), trajectory.getLatitude(), trajectory.getLongitude());
                filterTrajectories.add(dto);
            }
        } else {
            System.out.println("No existen trayectorias para este taxi en esta fecha.");
        }
        return filterTrajectories;

    }


    public List<LastTrajectoryDTO> lastTrajectory() {

        List<Trajectories> allTrajectories = trajectoriesRepository.findAll();

        if (allTrajectories.isEmpty()) {
            return Collections.emptyList();
        }

        Map<Integer, Trajectories> lastTrajectoriesMap = allTrajectories.stream()
                .collect(Collectors.toMap(
                        trajectory -> trajectory.getTaxi().getId(),
                        Function.identity(),
                        (existing, replacement) -> existing.getDate().after(replacement.getDate()) ? existing : replacement
                ));


        return lastTrajectoriesMap.values().stream()
                .map(trajectory -> {
                    int trajectoryId = trajectory.getTaxi().getId();
                    String trajectoryLicense = trajectory.getTaxi().getLicense();
                    double trajectoryLatitude = trajectory.getLatitude();
                    double trajectoryLongitude = trajectory.getLongitude();
                    Date trajectoryDate = trajectory.getDate();
                    return new LastTrajectoryDTO(trajectoryId, trajectoryLicense, trajectoryLatitude, trajectoryLongitude, trajectoryDate);
                })
                .collect(Collectors.toList());
    }
}
