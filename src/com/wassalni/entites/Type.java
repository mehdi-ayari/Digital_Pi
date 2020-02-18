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
public enum Type {
    
    
   Taxi,Privée,camion;

    public Type getType(int x) {
        switch (x) {
            case 1:
                return Taxi;
            case 2:
                return Privée;
            default:
                return camion;
        }
    }

    public static Type getTaxi() {
        return Taxi;
    }

    public static Type getPrivée() {
        return Privée;
    }

    public static Type getcamion() {
        return camion;
    }
    
    
}
