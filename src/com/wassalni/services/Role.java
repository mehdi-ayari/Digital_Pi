/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.services;

/**
 *
 * @author jawed
 */
public enum Role {
    client,administrateur,chauffeur,entreprise;

    public static Role getEntreprise() {
        return entreprise;
    }

    public static Role getClient() {
        return client;
    }

    public static Role getAdministrateur() {
        return administrateur;
    }

    public static Role getChauffeur() {
        return chauffeur;
    }
}
