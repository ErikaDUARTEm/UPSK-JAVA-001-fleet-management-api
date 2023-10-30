package com.api.fleetManagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "trajectories")
public class Trajectories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "taxi_id", referencedColumnName = "id")
    @JsonIgnore
    private Taxi taxi;

    private Date date;

    private double latitude;
    private double longitude;

    public Trajectories() {}

    public Trajectories(int id, Taxi taxi, Date date, double latitude, double longitude) {
        this.id = id;
        this.taxi = taxi;
        this.date = date;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }
}
