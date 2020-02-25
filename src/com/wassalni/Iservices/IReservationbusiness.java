/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.Iservices;

import com.wassalni.entites.Reservationbusiness;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mahdi
 */
public interface IReservationbusiness {
    
    void ajouter(Reservationbusiness rb) throws SQLException;
    boolean delete(Reservationbusiness rb) throws SQLException;
    boolean update(Reservationbusiness rb) throws SQLException;
    List<Reservationbusiness> readAll() throws SQLException;
    
}
