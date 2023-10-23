package com.api.fleetManagement.model;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "trajectories")
public class Trajectories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "id_taxi", referencedColumnName = "id")
    private Taxi taxi;

    private Date fecha;
    private Time hora;
    private double latitud;
    private double longitud;

    public Trajectories() {}

    public Trajectories(int id, Taxi taxi, Date fecha, Time hora, double latitud, double longitud) {
        this.id = id;
        this.taxi = taxi;
        this.fecha = fecha;
        this.hora = hora;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getId() {
        return id;
    }
    public void setId(int id){
        this.id = id;
    }


    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }
}
