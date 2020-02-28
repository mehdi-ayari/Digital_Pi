/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.services;

import com.wassalni.entites.Promotion;
import com.wassalni.utilits.DataBase;
import com.wassalni.utilits.MailPromotion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author UnKnOWn
 */
public class PromotionService {
    
            private Connection con;
	    private Statement ste;

	    public PromotionService() {
	    
                con = DataBase.getInstance().getConnection();
	    }
            

            public void ajouterPromotion(Promotion p) throws SQLException {
                PreparedStatement pre=con.prepareStatement("INSERT INTO `wassalni_data_base`.`promotion` (`nom`, `pourcentage`, `date_debut`, `date_fin`,`description`)"
            + " VALUES (?,?,?,?,?);");
        
        
    pre.setString(1, p.getNom());
    pre.setInt(2, p.getPourcentage());
    pre.setString(3, p.getDate_debut());
    pre.setString(4, p.getDate_fin());
    pre.setString(6, p.getDescription());
   
    pre.executeUpdate();
    System.out.println("inserted");
      
    }
           
    public boolean update(Promotion p) throws SQLException {
        ste = con.createStatement();
        String req = "update Promotion set nom+ = '"
                +p.getNom()
                +"',date_debut='"
                +p.getDate_debut()
                +"',date_fin='"
                +p.getDate_fin()
                +"',pourcentage='"
                +p.getPourcentage()
                +"'description = '"
                +p.getDescription()+"'";
        if(ste.executeUpdate(req)==1){
            System.out.println("modification effectué");
            return  true;
        };
        System.out.println("modification échoué");
        return false;
        
    }
       
       
    public void delete(int i) {
        try {
            String req = "delete from promotion where idpromotion=" + i;
            PreparedStatement pt = con.prepareStatement(req);
            pt.executeUpdate(req);
            System.out.println("Formulaire supprimé");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
            
            
public ObservableList<Promotion> getAllPromotion() {
        ObservableList<Promotion> list = FXCollections.observableArrayList();
        String requete = "SELECT nom , description , date_debut, date_fin, pourcentage from prmotion ";

        ResultSet rs;
        try {
            Statement st =con.createStatement();
            rs= st.executeQuery(requete);
            while(rs.next()){
                String nom  = rs.getString(1);
                String description = rs.getString(2);
                Timestamp date_debut = rs.getTimestamp(3);
                Timestamp date_fin = rs.getTimestamp(4);
                int pourcentage = rs.getInt(5);


                
            
                Promotion rd = new Promotion(nom,pourcentage, date_debut, date_fin, description);

                 list.add(rd);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return list ;
    }
    
}
