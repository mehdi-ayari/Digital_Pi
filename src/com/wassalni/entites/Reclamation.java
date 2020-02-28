/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.entites;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author user
 */
public class Reclamation {
    private int id;
    private String titre;
    private String description;
    private String  datee;

    public Reclamation(String titre, String datee) {
        this.titre = titre;
        this.datee = datee;
    }

    private int user_id;

    public Reclamation(int id, String titre, String description, String datee, int user_id) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.datee = datee;
        this.user_id = user_id;
    }

    public Reclamation(int id, String titre, String description, String datee) {
        this.id = id;
        this.titre = titre;
        this.description = description;
        this.datee = datee;
    }

    public String getDatee() {
        return datee;
    }

    public void setDatee(String datee) {
        this.datee = datee;
    }



 

    public Reclamation(String titre, String description, int user_id) {
        this.titre = titre;
        this.description = description;
        this.user_id = user_id;
    }

    public Reclamation() {
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getDescription() {
        return description;
    }

    public int getuser_id() {
        return user_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setuser_id(int user_id) {
        this.user_id = user_id;
    }

    public Reclamation(int id, String titre, String description) {
        this.id = id;
        this.titre = titre;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", titre=" + titre + ", description=" + description + ", datee=" + datee + ", user_id=" + user_id + '}';
    }

  
    
}
