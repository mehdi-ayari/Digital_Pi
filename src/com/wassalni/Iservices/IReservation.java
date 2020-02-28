/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.Iservices;


import com.wassalni.services.ReservationService;
import com.wassalni.entites.Reservation;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Mahdi
 */
public interface IReservation {
    
    void ajouter(Reservation r) throws SQLException;
    boolean delete(Reservation r) throws SQLException;
    boolean update(Reservation r) throws SQLException;
    List<Reservation> readAll() throws SQLException;
    
}
