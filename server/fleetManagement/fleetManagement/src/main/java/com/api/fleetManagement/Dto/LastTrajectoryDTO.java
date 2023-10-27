package com.api.fleetManagement.Dto;


import java.util.Date;
public class LastTrajectoryDTO {
    private int id;
    private String license;
    private Date date;

    private double latitude;
    private double longitude;


    public LastTrajectoryDTO(int id, String license, double latitude, double longitude, Date date) {
        this.id = id;
        this.license= license;
        this.latitude = latitude;
        this.longitude = longitude;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
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



}
