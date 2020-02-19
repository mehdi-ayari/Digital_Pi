/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.Iservices;

import com.wassalni.entites.Voiture;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mahdi
 */
public interface IVoiture {
    
    void ajouter(Voiture v) throws SQLException;
    boolean delete(Voiture v) throws SQLException;
    boolean update(Voiture v) throws SQLException;
    List<Voiture> readAll() throws SQLException;
    
}
