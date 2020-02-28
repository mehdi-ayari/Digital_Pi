/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.Iservices;

import com.wassalni.entites.Reclamation;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author user
 */
public interface IReclamation { 
    void ajouter(Reclamation R) throws SQLException;
    boolean deleteReclamation(Reclamation R) throws SQLException;
    boolean updateReclamation(Reclamation R) throws SQLException;
    List<Reclamation> readAll() throws SQLException;
    
}
