package com.api.fleetManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "taxis")
public class Taxi {
    @Id
    private int id;
    private String placa;

    @JsonIgnore
    @OneToMany(mappedBy = "taxi",  cascade = CascadeType.ALL)
    List<Trajectories> trajectories;

    protected Taxi() {}

    public Taxi(int id, String placa, List<Trajectories> trajectories) {
        this.id = id;
        this.placa = placa;
        this.trajectories = trajectories;

    }
    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public List<Trajectories> getTrajectories() {
        return trajectories;
    }

    public void setTrajectories(List<Trajectories> trajectories) {
        this.trajectories = trajectories;
    }
}
