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
public class Reservation {
    private int id_res;
    private String destination;
    private Timestamp date_reservation;
    private Type type_reservation; 
    private float prix;
    private int user_id_client;
    private int user_id_chauffeur;

    public Reservation() {
    }

    public Reservation(String destination, Timestamp date_reservation, Type type_reservation, float prix, int user_id_client, int user_id_chauffeur) {
        this.destination = destination;
        this.date_reservation = date_reservation;
        this.type_reservation = type_reservation;
        this.prix = prix;
        this.user_id_client = user_id_client;
        this.user_id_chauffeur = user_id_chauffeur;
    }

    
    
    public int getId_res() {
        return id_res;
    }

    public String getDestination() {
        return destination;
    }

    public Timestamp getDate_reservation() {
        return date_reservation;
    }

    public Type getType_reservation() {
        return type_reservation;
    }

    public float getPrix() {
        return prix;
    }

    public int getUser_id_client() {
        return user_id_client;
    }

    public int getUser_id_chauffeur() {
        return user_id_chauffeur;
    }

   

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate_reservation(Timestamp date_reservation) {
        this.date_reservation = date_reservation;
    }

    public void setType_reservation(Type type_reservation) {
        this.type_reservation = type_reservation;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public void setUser_id_client(int user_id_client) {
        this.user_id_client = user_id_client;
    }

    public void setUser_id_chauffeur(int user_id_chauffeur) {
        this.user_id_chauffeur = user_id_chauffeur;
    }

  

   
    }
    
    
    
    
    

