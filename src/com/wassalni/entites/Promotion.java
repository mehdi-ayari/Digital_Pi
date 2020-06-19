/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.entites;

import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author UnKnOWn
 */
public class Promotion {
    private int id_promotion;
    private String nom;
    private int pourcentage;    
    private Timestamp date_debut;
    private Timestamp date_fin;
    private String description;
   

    public Promotion(int id_promotion, int pourcentage, Timestamp date_debut, Timestamp date_fin, String description) {
        this.id_promotion = id_promotion;
        this.pourcentage = pourcentage;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
    }

    public Promotion(String nom, int pourcentage, Timestamp date_debut, Timestamp date_fin, String description) {
        this.nom = nom;
        this.pourcentage = pourcentage;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.description = description;
    }

    public int getId_promotion() {
        return id_promotion;
    }

    public String getNom() {
        return nom;
    }

    public int getPourcentage() {
        return pourcentage;
    }

     public String getsPourcentage() {
        return Integer.toString(pourcentage);
    }
    public String getDate_debut() {
        return date_debut.toString();
    }

    public String getDate_fin() {
        return date_fin.toString();
    }

    public String getDescription() {
        return description;
    }

    public void setId_promotion(int id_promotion) {
        this.id_promotion = id_promotion;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPourcentage(int pourcentage) {
        this.pourcentage = pourcentage;
    }

    public void setDate_debut(Timestamp date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Timestamp date_fin) {
        this.date_fin = date_fin;
    }

    public void setDescription(String description) {
        this.description = description;
    }

  

   
    
}
