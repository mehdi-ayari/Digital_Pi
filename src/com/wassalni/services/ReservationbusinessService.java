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
             String requeteInsert = "INSERT INTO `reservation_business`( `date_depart`, `destination`,`user_id_entrepot`,`date_reservation`,`nom_client_entreprise`,`prenon_client_entreprise`,`point_depart`) "
                + "VALUES ('" + rb.getDate_depart() + "','" + rb.getDestination() + "','"+rb.getUser_id_entreprise()+"','"+rb.getDate_reservation()+"','"+rb.getNom_client_entreprise()+"','"+rb.getPrenom_client_entreprise()+"','"+rb.getPoint_depart()+"');";
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
            pre = con.prepareStatement("UPDATE `reservation_business` SET `date_depart`=?,`destination`=?,`date_reservation`=?,`nom_client_entreprise`=?,`prenom_client_entreprise`=?,`point_depart`=?;");
        
         pre.setTimestamp(1, rb.getDate_depart());
        pre.setString(2, rb.getDestination());
        pre.setTimestamp(3, rb.getDate_reservation());
        pre.setString(4, rb.getNom_client_entreprise());
        pre.setString(5, rb.getPrenom_client_entreprise());
        pre.setString(6, rb.getPoint_depart());
      
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
               Timestamp date_debut=rs.getTimestamp("date_depart");
               String destination=rs.getString("destination");
               int id_e=rs.getInt("user_id_entreprise");
               Timestamp date_reservation=rs.getTimestamp("date_reservation");
               String nom_client_entreprise=rs.getString("nom_client_entreprise");
               String prenon_client_entreprise=rs.getString("prenon_client_entreprise");
               String point_depart=rs.getString("point_depart");

               
               Reservationbusiness p=new Reservationbusiness(id,date_debut,destination,id_e,date_reservation,nom_client_entreprise,prenon_client_entreprise,point_depart);
     arr.add(p);
     }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
    
    return arr;

    }
    
    
    
}
