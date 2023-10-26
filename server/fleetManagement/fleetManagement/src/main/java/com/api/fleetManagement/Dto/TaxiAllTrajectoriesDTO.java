package com.api.fleetManagement.Dto;

import java.sql.Date;
import java.sql.Time;

public class TaxiAllTrajectoriesDTO {

        private Date fecha;
        private Time hora;
        private double latitud;
        private double longitud;


        public TaxiAllTrajectoriesDTO(Date fecha, Time hora, double latitud, double longitud) {
            this.fecha = fecha;
            this.hora = hora;
            this.latitud = latitud;
            this.longitud = longitud;
        }

        public Date getFecha() {
            return fecha;
        }

        public Date setFecha(Date fecha) {
            this.fecha = fecha;
            return fecha;
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


}
