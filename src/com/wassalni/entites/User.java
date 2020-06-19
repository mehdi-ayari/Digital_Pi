/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.entites;

import com.wassalni.services.Role;

/**
 *
 * @author jawed
 */
public class User {
    private int id;
    private String nom;
    private String prenom;
    private String mail;
    private int telephone;
    private String adresse;
    private boolean etat;
    private int nbr_emp;
    private Role role;
    private String motDePasse;
    private String photo;
    private String permis;
    private String licence;

    public User() {
    }

    public User(String nom, String prenom, String mail, int telephone, Role role, String motDePasse, String photo, String permis) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.telephone = telephone;
        this.role = role;
        this.motDePasse = motDePasse;
        this.photo = photo;
        this.permis = permis;
    }

    public User(String nom, String prenom, String permis) {
        this.nom = nom;
        this.prenom = prenom;
        this.permis = permis;
    }
    
    

  

   
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMail() {
        return mail;
    }

    public int getTelephone() {
        return telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public boolean isEtat() {
        return etat;
    }

    public int getNbr_emp() {
        return nbr_emp;
    }

   

    public String getMotDePasse() {
        return motDePasse;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPermis() {
        return permis;
    }

    public String getLicence() {
        return licence;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }

    public void setNbr_emp(int nbr_emp) {
        this.nbr_emp = nbr_emp;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setPermis(String permis) {
        this.permis = permis;
    }

    public void setLicence(String licence) {
        this.licence = licence;
    }
    
}
