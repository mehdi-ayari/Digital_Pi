/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.services;

import com.wassalni.Iservices.INews;
import com.wassalni.entites.Comment;
import com.wassalni.utilits.DataBase;
import doryan.windowsnotificationapi.fr.Notification;
import java.awt.AWTException;
import java.awt.TrayIcon;
import java.net.MalformedURLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;



/**
 *
 * @author ASUS
 */
public class ServiceComment implements INews<Comment> {
    
   

    private Connection con;
    private Statement ste;

    public ServiceComment() {
        con = DataBase.getInstance().getConnection();

    }
    


    public void ajouter(Comment t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `wassalni`.`commentaire` (`text`) VALUES ('"  + t.getText()+ "');";
       // ste.executeUpdate(requeteInsert);   
       ste.executeUpdate(requeteInsert);
    }
            

   

    @Override
    public List<Comment> readAll() throws SQLException {
    List<Comment> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from commentaire");
     while (rs.next()) {                
               
               String commentaire=rs.getString("commentaire");
       
               Comment n=new Comment(commentaire);
     arr.add(n);
     }
    return arr;
    }

    @Override
    public boolean delete(int t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Comment t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Comment readID(Comment t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
