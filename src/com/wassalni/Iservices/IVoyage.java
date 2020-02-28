/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.Iservices;

import com.wassalni.entites.Voyage;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author CHOUCHANE MD
 */
public interface IVoyage {
    
    public void ajouter(Voyage v) throws SQLException ;
    public boolean delete(int id_news) throws SQLException ;
    public List<Voyage> readAll() throws SQLException ;
    
}
