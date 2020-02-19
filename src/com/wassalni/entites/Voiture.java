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
public class Voiture {
    private int id_voiture;
    private Type type_voiture;
    private String matricule;
    private int user_id_chauffeur;

    public Voiture() {
    }

    public Voiture(int id_voiture, Type type_voiture, String matricule, int user_id_chauffeur) {
        this.id_voiture = id_voiture;
        this.type_voiture = type_voiture;
        this.matricule = matricule;
        this.user_id_chauffeur = user_id_chauffeur;
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public Type getType_voiture() {
        return type_voiture;
    }

    public String getMatricule() {
        return matricule;
    }

    public int getId_chauffeur() {
        return user_id_chauffeur;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

    public void setType_voiture(Type type_voiture) {
        this.type_voiture = type_voiture;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setId_chauffeur(int user_id_chauffeur) {
        this.user_id_chauffeur = user_id_chauffeur;
    }
    
    
    
}
