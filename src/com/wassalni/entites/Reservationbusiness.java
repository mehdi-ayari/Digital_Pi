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
   private Timestamp date_depart ;
   private String destination;
   private int user_id_entreprise;
   private Timestamp date_reservation;
   private String nom_client_entreprise;
   private String prenom_client_entreprise;
   private String point_depart;

   
    public Reservationbusiness() {
    }

    public Reservationbusiness(int id_res_business, Timestamp date_depart, String destination, int user_id_entreprise,Timestamp date_reservation) {
        this.id_res_business = id_res_business;
        this.date_depart = date_depart;
        this.destination = destination;
        this.user_id_entreprise = user_id_entreprise;
        this.date_reservation=date_reservation;
    }

    public Reservationbusiness(Timestamp date_depart, String destination, Timestamp date_reservation, String nom_client_entreprise, String prenom_client_entreprise, String point_depart) {
        this.date_depart = date_depart;
        this.destination = destination;
        this.date_reservation = date_reservation;
        this.nom_client_entreprise = nom_client_entreprise;
        this.prenom_client_entreprise = prenom_client_entreprise;
        this.point_depart = point_depart;
    }

    public Reservationbusiness(int id_res_business, Timestamp date_depart, String destination, int user_id_entreprise, Timestamp date_reservation, String nom_client_entreprise, String prenom_client_entreprise, String point_depart) {
        this.id_res_business = id_res_business;
        this.date_depart = date_depart;
        this.destination = destination;
        this.user_id_entreprise = user_id_entreprise;
        this.date_reservation = date_reservation;
        this.nom_client_entreprise = nom_client_entreprise;
        this.prenom_client_entreprise = prenom_client_entreprise;
        this.point_depart = point_depart;
    }

    public String getNom_client_entreprise() {
        return nom_client_entreprise;
    }

    public String getPrenom_client_entreprise() {
        return prenom_client_entreprise;
    }

    public String getPoint_depart() {
        return point_depart;
    }
    
    

    public Timestamp getDate_reservation() {
        return date_reservation;
    }
    
    public int getId_res_business() {
        return id_res_business;
    }

    public Timestamp getDate_depart() {
        return date_depart;
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

    public void setDate_depart(Timestamp date_debut) {
        this.date_depart = date_debut;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setUser_id_entreprise(int user_id_entreprise) {
        this.user_id_entreprise = user_id_entreprise;
    }

    public void setDate_reservation(Timestamp date_reservation) {
        this.date_reservation = date_reservation;
    }

    public void setNom_client_entreprise(String nom_client_entreprise) {
        this.nom_client_entreprise = nom_client_entreprise;
    }

    public void setPrenom_client_entreprise(String prenom_client_entreprise) {
        this.prenom_client_entreprise = prenom_client_entreprise;
    }

    public void setPoint_depart(String point_depart) {
        this.point_depart = point_depart;
    }

    @Override
    public String toString() {
        return "Reservationbusiness{" + "id_res_business=" + id_res_business + ", date_depart=" + date_depart + ", destination=" + destination + ", user_id_entreprise=" + user_id_entreprise + ", date_reservation=" + date_reservation + ", nom_client_entreprise=" + nom_client_entreprise + ", prenom_client_entreprise=" + prenom_client_entreprise + ", point_depart=" + point_depart + '}';
    }
   
   
   
    
}
