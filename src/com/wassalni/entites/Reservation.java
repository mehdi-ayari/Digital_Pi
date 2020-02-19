/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.entites;

/**
 *
 * @author Mahdi
 */
public class Reservation {
    private int id_res;
    private String destination;
    private String date_reservation;
    private Type type_reservation; 
    private float prix;
    private int user_id_client;
    private int voiture_id_voiture;

    public Reservation() {
    }

    public Reservation(String destination, String date_reservation, Type type_reservation, float prix) {
        this.destination = destination;
        this.date_reservation = date_reservation;
        this.type_reservation = type_reservation;
        this.prix = prix;
    }

    public Reservation(String destination, String date_reservation, Type type_reservation, float prix, int user_id_client, int voiture_id_voiture) {
        this.destination = destination;
        this.date_reservation = date_reservation;
        this.type_reservation = type_reservation;
        this.prix = prix;
        this.user_id_client = user_id_client;
        this.voiture_id_voiture = voiture_id_voiture;
    }

    
    public Reservation(int id_res, String destination, String date_reservation, Type type_reservation, float prix, int user_id_client, int voiture_id_voiture) {
        this.id_res = id_res;
        this.destination = destination;
        this.date_reservation = date_reservation;
        this.type_reservation = type_reservation;
        this.prix = prix;
        this.user_id_client = user_id_client;
        this.voiture_id_voiture = voiture_id_voiture;
    }
    
    

    public int getId_res() {
        return id_res;
    }

    public String getDestination() {
        return destination;
    }

    public String getDate_reservation() {
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

    public int getVoiture_id_voiture() {
        return voiture_id_voiture;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setDate_reservation(String Datae_reservation) {
        this.date_reservation = Datae_reservation;
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

    public void setVoiture_id_voiture(int voiture_id_voiture) {
        this.voiture_id_voiture = voiture_id_voiture;
    }

    @Override
    public String toString() {
        return "Resrvation{" + "id_res=" + id_res + ", destination=" + destination + ", Datae_reservation=" + date_reservation + ", type_reservation=" + type_reservation + ", prix=" + prix + ", user_id_client=" + user_id_client + ", voiture_id_voiture=" + voiture_id_voiture + '}';
    }

    public class voiture {

        public voiture() {
        }
    }
    
    
    
    
    
}
