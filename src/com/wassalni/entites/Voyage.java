/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.entites;

import java.sql.Timestamp;

/**
 *
 * @author CHOUCHANE MD
 */
public class Voyage {
    private int id_voyage;
    private float distance;
    private Timestamp date_voyage;
    private int reservation_id_res;
    private String distination;
    private Timestamp date_reservation;
    private int userid;

    public Voyage() {
    }

    public Voyage(int id_voyage, float distance, Timestamp date_voyage, int reservation_id_res, String distination) {
        this.id_voyage = id_voyage;
        this.distance = distance;
        this.date_voyage = date_voyage;
        this.reservation_id_res = reservation_id_res;
        this.distination = distination;
    }
    
        public Voyage(float distance) {

        this.distance = distance;

    }

    public Voyage(int id_voyage, float distance, Timestamp date_voyage, int reservation_id_res, String distination, Timestamp date_reservation, int userid) {
        this.id_voyage = id_voyage;
        this.distance = distance;
        this.date_voyage = date_voyage;
        this.reservation_id_res = reservation_id_res;
        this.distination = distination;
        this.date_reservation = date_reservation;
        this.userid = userid;
    }
    
    
    public Voyage(int id_voyage, float distance, Timestamp date_voyage, int reservation_id_res) {
        this.id_voyage = id_voyage;
        this.distance = distance;
        this.date_voyage = date_voyage;
        this.reservation_id_res = reservation_id_res;
    }
    
    public Voyage(float distance, Timestamp date_voyage, int reservation_id_res) {
       
        this.distance = distance;
        this.date_voyage = date_voyage;
        this.reservation_id_res = reservation_id_res;
    }
    
    public Voyage(float distance, int reservation_id_res) {
       
        this.distance = distance;
        this.reservation_id_res = reservation_id_res;
    }

    public Voyage(Timestamp date_reservation, int userid) {
            this.date_reservation=date_reservation;
            this.userid=userid;
    }

    public Timestamp getDate_voyage() {
        return date_voyage;
    }

    public float getDistance() {
        return distance;
    }

    public int getId_voyage() {
        return id_voyage;
    }

    public int getReservation_id_res() {
        return reservation_id_res;
    }

    public String getDistination() {
        return distination;
    }

    public void setDistination(String distination) {
        this.distination = distination;
    }
    
    

    public void setDate_voyage(Timestamp date_voyage) {
        this.date_voyage = date_voyage;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public void setId_voyage(int id_voyage) {
        this.id_voyage = id_voyage;
    }

    public void setReservation_id_res(int reservation_id_res) {
        this.reservation_id_res = reservation_id_res;
    }

    @Override
    public String toString() {
        return "id : " + id_voyage + " distance : " + distance + " date_voyage : " + date_voyage + " reservation_id_res : " + reservation_id_res;
    }
    
    public static double distance(double lat1, double lat2, double lon1,
        double lon2, double el1, double el2) {

    final int R = 6371; // Radius of the earth

    double latDistance = Math.toRadians(lat2 - lat1);
    double lonDistance = Math.toRadians(lon2 - lon1);
    double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
            + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
            * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    double distance = R * c * 1000; // convert to meters

    double height = el1 - el2;

    distance = Math.pow(distance, 2) + Math.pow(height, 2);

    return Math.sqrt(distance);
    
}
    
    
    
    
}
