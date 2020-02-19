/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.services;

import com.wassalni.Iservices.IVoiture;
import com.wassalni.entites.Type;
import com.wassalni.entites.Voiture;
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
public class VoitureService implements IVoiture {
    
    private Connection con;
    private Statement ste;

    public VoitureService() {
        
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Voiture v) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `voiture`( `type_voiture`, `matricule`,`user_id_chauffeur`) "
                + "VALUES ('" + v.getType_voiture() + "','" + v.getMatricule() + "','"+v.getId_chauffeur()+"');";
        ste.executeUpdate(requeteInsert);
    }

    @Override
    public boolean delete(Voiture v) throws SQLException {
        PreparedStatement pre=con.prepareStatement("DELETE FROM `voiture` WHERE `id_res`= ?");
        pre.setInt(1, v.getId_voiture());        
        pre.executeUpdate();
        
        return true;
    }

    @Override
    public boolean update(Voiture v) throws SQLException {
        String typev=String.valueOf(v.getType_voiture());
                
        PreparedStatement pre = con.prepareStatement("UPDATE `voiture` SET `type_voiture`=?,`matricule`=? WHERE `id_voiture`=?;");
        pre.setString(1, typev);
        pre.setString(2, v.getMatricule());
               pre.executeUpdate();
        
        return true;
    }

    @Override
    public List<Voiture> readAll() throws SQLException {
    List<Voiture> arr=new ArrayList<>();
    ste=con.createStatement();
    
    ResultSet rs=ste.executeQuery("select * from voiture");
     while (rs.next()) {                
               int id_voiture=rs.getInt(1);
               Type type_voiture=Type.valueOf(rs.getString(2));
               String matricule=rs.getString("matricule");
               int user_id_chauffeur=rs.getInt(4);
               Voiture p=new Voiture(id_voiture, type_voiture, matricule, user_id_chauffeur);
     arr.add(p);
     }
    return arr;
    }
    }
    
    

   
