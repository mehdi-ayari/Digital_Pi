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
    private PreparedStatement ps;
    private ResultSet rs;
    

    public ReservationbusinessService() {
        
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Reservationbusiness rb) throws SQLException {
        String req ="INSERT INTO `reservation_business`("
                + " `date_depart`, "
                + "`destination`, "
                + "`user_id_entreprise`,"
                + " `date_reservation`,"
                + " `nom_client_entreprise`,"
                + " `prenon_client_entreprise`,"
                + " `point_depart`)"
                + "VALUES (?,?,?,?,?,?,?)";
                
        try {
            System.out.println(rb.toString());
            
             ps = con.prepareStatement(req);
            ps.setTimestamp(1,rb.getDate_depart());
            ps.setString(2,rb.getDestination());
            ps.setInt(3,1);
            ps.setTimestamp(4,rb.getDate_reservation());
            ps.setString(5,rb.getNom_client_entreprise());
            ps.setString(6,rb.getPrenom_client_entreprise());
            ps.setString(7,rb.getPoint_depart());
            ps.execute();
            System.out.println("res ajouté");
            
        } catch (SQLException ex) {
            System.out.println("res non ajouté"+ex);
        }
//        try {
//            ste = con.createStatement();
//             String requeteInsert = "INSERT INTO `reservation_business`( `date_depart`, `destination`, `user_id_entreprise`, `date_reservation`, `nom_client_entreprise`, `prenon_client_entreprise`, `point_depart`) "
//                + "VALUES ('" + rb.getDate_depart() + "','" + rb.getDestination() + "',1,'"+rb.getDate_reservation()+"','"+rb.getNom_client_entreprise()+"','"+rb.getPrenom_client_entreprise()+"','"+rb.getPoint_depart()+"');";
//        ste.executeUpdate(requeteInsert);
//        } catch (SQLException ex) {
//        }
//       

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
            pre = con.prepareStatement("UPDATE `reservation_business` SET"
                    + " `date_depart`=?,"
                    + "`destination`=?,"
                    + "`date_reservation`=?,"
                    + "`nom_client_entreprise`=?,"
                    + "`prenon_client_entreprise`=?,"
                    + "`point_depart`=?"
                    + " WHERE `id_res_business`=?;");
        
         pre.setTimestamp(1, rb.getDate_depart());
        pre.setString(2, rb.getDestination());
        pre.setTimestamp(3, rb.getDate_reservation());
        pre.setString(4, rb.getNom_client_entreprise());
        pre.setString(5, rb.getPrenom_client_entreprise());
        pre.setString(6, rb.getPoint_depart());
        pre.setInt(7, rb.getId_res_business());
        pre.execute();
      
            System.out.println("reservation modifiée");
        } catch (SQLException ex) {
        }
       
        return true;

    }

    @Override
    public List<Reservationbusiness> readAll() throws SQLException {
        String req ="SELECT * FROM `reservation_business` WHERE 1";
   List<Reservationbusiness> arr=new ArrayList<>();
        try {
            ps=con.prepareStatement(req);
            rs = ps.executeQuery();
     while (rs.next()) {                
              Reservationbusiness r = new Reservationbusiness();
               r.setId_res_business(rs.getInt("id_res_business"));
               r.setDate_depart(rs.getTimestamp("date_depart"));
               r.setDestination(rs.getString("destination"));
               r.setUser_id_entreprise(rs.getInt("user_id_entreprise"));
               r.setDate_reservation(rs.getTimestamp("date_reservation"));
               r.setNom_client_entreprise(rs.getString("nom_client_entreprise"));
               r.setPrenom_client_entreprise(rs.getString("prenon_client_entreprise"));
               r.setPoint_depart(rs.getString("point_depart"));

               
     arr.add(r);
     }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
        System.out.println(arr.toString()+"\n");
    return arr;

    }
    
    
    
}
