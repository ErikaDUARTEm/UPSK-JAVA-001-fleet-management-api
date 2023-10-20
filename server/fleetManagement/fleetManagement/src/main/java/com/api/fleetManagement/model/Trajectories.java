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

    @Column(name = "id_taxi", insertable = false, updatable = false)
    private int id_taxi;
    @ManyToOne
    @JoinColumn(name = "id_taxi")
    private Taxi taxi;

    private Date fecha;
    private Time hora;
    private double latitud;
    private double longitud;

    protected Trajectories() {}

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

    public int getId_taxi() {
        return id_taxi;
    }

    public void setId_taxi(int id_taxi) {
        this.id_taxi = id_taxi;
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
