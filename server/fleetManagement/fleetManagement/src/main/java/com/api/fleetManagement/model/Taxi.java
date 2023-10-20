package com.api.fleetManagement.model;

import jakarta.persistence.*;

@Entity
@Table(name = "taxis")
public class Taxi {
    @Id
    private int id;
    private String placa;

    protected Taxi() {}

    public Taxi(int id, String placa) {
        this.id = id;
        this.placa = placa;
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

}
