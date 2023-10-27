package com.api.fleetManagement.Dto;

import java.util.Date;

public class TaxiAllTrajectoriesDTO {

        private Date date;

        private double latitude;
        private double longitude;


        public TaxiAllTrajectoriesDTO(Date date, double latitude, double longitude) {
            this.date = date;
            this.latitude = latitude;
            this.longitude = longitude;
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
