/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.services;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.javascript.object.GoogleMap;
import com.wassalni.Iservices.IReservation;
import com.wassalni.entites.Reservation;
import com.wassalni.entites.Type;
import com.wassalni.utilits.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void ajouter(Reservation r) throws SQLException{
        try {
            ste = con.createStatement();
             String requeteInsert = "INSERT INTO `reservation`( `destination`, `date_reservation`,`type_reservation`,`prix`, `user_id_client`, `user_id_chauffeur`) "
                + "VALUES ('" + r.getDestination() + "','" + r.getDate_reservation() + "','"+r.getType_reservation()+"',15,1,1);";
        ste.executeUpdate(requeteInsert);
        } catch (SQLException ex) {
        }
       
    }

    @Override
    public boolean delete(Reservation r) throws SQLException {
        PreparedStatement pre=con.prepareStatement("DELETE FROM `reservation` WHERE `date_reservation`= ?");
        pre.setTimestamp(1, r.getDate_reservation());        
        pre.executeUpdate();
        
        return true;
    }

    @Override
    public boolean update(Reservation r) {
        String type=String.valueOf(r.getType_reservation());
                
        PreparedStatement pre;
        try {
            pre = con.prepareStatement("UPDATE `reservation` SET `destination`=?,`type_reservation`=? WHERE `id_res`=?;");
        
         pre.setString(1, r.getDestination());
        pre.setString(2,type );
        pre.setInt(3, r.getId_res());
        pre.executeUpdate();
            System.out.println("reservation modifiée");
        } catch (SQLException ex) {
        }
       
        return true;
    }

    @Override
    public List<Reservation> readAll()  {
        List<Reservation> arr=new ArrayList<>();
        try {
            ste=con.createStatement();
            ResultSet rs=ste.executeQuery("select * from Reservation");
     while (rs.next()) {                
              int id_res=rs.getInt(1);
               String destination=rs.getString("destination");
               Timestamp date_reservation=rs.getTimestamp(3);
               Type type_reservation=Type.valueOf(rs.getString(4));
               float prix=rs.getInt(5);
               int user_id_client=rs.getInt(6);
               int user_id_chauffeur=rs.getInt(7);
               Reservation p=new Reservation(id_res,destination, date_reservation, type_reservation,prix, user_id_client,user_id_chauffeur);
     arr.add(p);
     }
        } catch (SQLException ex) {
        }
    
    
    return arr;
    }
    
}
    
    
    
    

