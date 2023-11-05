package com.api.fleetManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "taxis")
public class Taxi {
    @Id
    private int id;
    private String license;

    @JsonIgnore
    @OneToMany(mappedBy = "taxi",  cascade = CascadeType.ALL)
    List<Trajectories> trajectories;

    public Taxi(int id, String taxi2) {}

    public Taxi(int id, String license, List<Trajectories> trajectories) {
        this.id = id;
        this.license = license;
        this.trajectories = trajectories;

    }
    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getLicense() {
        return license;
    }

    public void setLicense(String placa) {
        this.license = license;
    }
    public List<Trajectories> getTrajectories() {
        return trajectories;
    }

    public void setTrajectories(List<Trajectories> trajectories) {
        this.trajectories = trajectories;
    }
}
