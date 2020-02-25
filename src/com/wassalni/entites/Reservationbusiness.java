/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.entites;

import java.sql.Timestamp;

/**
 *
 * @author Mahdi
 */
public class Reservationbusiness {
   private int id_res_business ;
   private Timestamp date_debut ;
   private String destination;
   private int user_id_entreprise;

    public Reservationbusiness() {
    }

    public Reservationbusiness(int id_res_business, Timestamp date_debut, String destination, int user_id_entreprise) {
        this.id_res_business = id_res_business;
        this.date_debut = date_debut;
        this.destination = destination;
        this.user_id_entreprise = user_id_entreprise;
    }
    
    

    public int getId_res_business() {
        return id_res_business;
    }

    public Timestamp getDate_debut() {
        return date_debut;
    }

    public String getDestination() {
        return destination;
    }

    public int getUser_id_entreprise() {
        return user_id_entreprise;
    }

    public void setId_res_business(int id_res_business) {
        this.id_res_business = id_res_business;
    }

    public void setDate_debut(Timestamp date_debut) {
        this.date_debut = date_debut;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setUser_id_entreprise(int user_id_entreprise) {
        this.user_id_entreprise = user_id_entreprise;
    }
   
   
   
    
}
