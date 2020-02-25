/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.services;

import com.wassalni.Iservices.IReservationbusiness;
import com.wassalni.entites.Reservationbusiness;
import com.wassalni.utilits.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mahdi
 */
public class ReservationbusinessService implements IReservationbusiness {
    private Connection con;
    private Statement ste;
    
    

    public ReservationbusinessService() {
        
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Reservationbusiness rb) throws SQLException {
        try {
            ste = con.createStatement();
             String requeteInsert = "INSERT INTO `reservation_business`( `date_debut`, `destination`,`user_id_entrepot`) "
                + "VALUES ('" + rb.getDate_debut() + "','" + rb.getDestination() + "','"+rb.getUser_id_entreprise()+"');";
        ste.executeUpdate(requeteInsert);
        } catch (SQLException ex) {
        }
       

    }

    @Override
    public boolean delete(Reservationbusiness rb) throws SQLException {
        PreparedStatement pre=con.prepareStatement("DELETE FROM `reservation` WHERE `id_res`= ?");
        pre.setInt(1, rb.getId_res_business());        
        pre.executeUpdate();
        
        return true;
    }

    @Override
    public boolean update(Reservationbusiness rb) throws SQLException {

    PreparedStatement pre;
        try {
            pre = con.prepareStatement("UPDATE `reservation_business` SET `date_debut`=?,`destination`=?;");
        
         pre.setTimestamp(1, rb.getDate_debut());
        pre.setString(2, rb.getDestination());
      
            System.out.println("reservation modifiée");
        } catch (SQLException ex) {
        }
       
        return true;

    }

    @Override
    public List<Reservationbusiness> readAll() throws SQLException {
   List<Reservationbusiness> arr=new ArrayList<>();
        try {
            ste=con.createStatement();
            ResultSet rs=ste.executeQuery("select * from reservation_business");
     while (rs.next()) {                
              
               int id=rs.getInt("id_res_business");
               Timestamp date_debut=rs.getTimestamp("date_debut");
               String destination=rs.getString("destination");
               int id_e=rs.getInt("user_id_entreprise");
               
               Reservationbusiness p=new Reservationbusiness(id,date_debut,destination,id_e);
     arr.add(p);
     }
        } catch (SQLException ex) {
        }
    
    
    return arr;

    }
    
    
    
}
