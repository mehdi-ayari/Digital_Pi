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

    public Voyage() {
    }

    public Voyage(int id_voyage, float distance, Timestamp date_voyage, int reservation_id_res, String distination) {
        this.id_voyage = id_voyage;
        this.distance = distance;
        this.date_voyage = date_voyage;
        this.reservation_id_res = reservation_id_res;
        this.distination = distination;
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
    
    
    
    
}
