/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.services;

import com.wassalni.Iservices.IReservation;
import com.wassalni.entites.Reservation;
import com.wassalni.entites.Type;
import com.wassalni.utilits.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mahdi
 */
public class ReservationService implements IReservation {
    private Connection con;
    private Statement ste;

    public ReservationService() {
        
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Reservation r) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `reservation`( `destination`, `date_reservation`,`type_reservation`,`prix`, `user_id_client`, `voiture_id_voiture`) "
                + "VALUES ('" + r.getDestination() + "','" + r.getDate_reservation() + "','Taxi',15,1,1);";
        ste.executeUpdate(requeteInsert);
    }

    @Override
    public boolean delete(Reservation r) throws SQLException {
        PreparedStatement pre=con.prepareStatement("DELETE FROM `reservation` WHERE `id_res`= ?");
        pre.setInt(1, r.getId_res());        
        pre.executeUpdate();
        
        return true;
    }

    @Override
    public boolean update(Reservation r) throws SQLException {
        String type=String.valueOf(r.getType_reservation());
                
        PreparedStatement pre = con.prepareStatement("UPDATE `reservation` SET `destination`=?,`date_reservation`=?,`type_reservation`=?,`prix`=? WHERE `id_res`=?;");
        pre.setString(1, r.getDestination());
        pre.setString(2, r.getDate_reservation());
        pre.setString(3,type );
        pre.setFloat(4, r.getPrix());
        pre.executeUpdate();
        
        return true;
    }

    @Override
    public List<Reservation> readAll() throws SQLException {
        List<Reservation> arr=new ArrayList<>();
    ste=con.createStatement();
    
    ResultSet rs=ste.executeQuery("select * from Reservation");
     while (rs.next()) {                
               int id_res=rs.getInt(1);
               String destination=rs.getString("destination");
               String date_reservation=rs.getString(3);
               Type type_reservation=Type.valueOf(rs.getString(5));
               float prix=rs.getInt(6);
               int user_id_client=rs.getInt(7);
               int voiture_id_voiture=rs.getInt(8);
               Reservation p=new Reservation(id_res, destination, date_reservation, type_reservation,prix, user_id_client,voiture_id_voiture);
     arr.add(p);
     }
    return arr;
    }
    }
    
    
    
    

