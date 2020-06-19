/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.services;

import com.wassalni.Iservices.IChauffeur;
import com.wassalni.entites.User;
import com.wassalni.utilits.DataBase;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author jawed
 */
public class ChauffeurService implements IChauffeur<User>{
    private Connection con;
    private Statement ste;

    public ChauffeurService() {
        con = DataBase.getInstance().getConnection();
    }

    @Override
    public void ajouter(User p) throws SQLException {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `wassalni_data_base`.`user` (`nom`, `prenom`, `mail`, `telephone`"
            + " ,`role`,`password`, `image`, `permis`, `licence`)"
            + " VALUES (?,?,?,?,?,?,?,?,?);");
        
        
    pre.setString(1, p.getNom());
    pre.setString(2, p.getPrenom());
    pre.setString(3, p.getMail());
    pre.setInt(4, p.getTelephone());
    pre.setString(5,String.valueOf(Role.getChauffeur()));
    pre.setString(6, p.getMotDePasse());
    pre.setString(7, p.getPhoto());
    pre.setString(8, p.getPermis());
    pre.setString(9, p.getLicence());
    pre.executeUpdate();
    System.out.println("inserted");
    }

    @Override
    public void delete() throws SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() throws SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   @Override
    public ObservableList<User> readAll() throws SQLException {
        ObservableList<User> oblist = FXCollections.observableArrayList();
        ste=con.createStatement();
        ResultSet rs=ste.executeQuery("SELECT * FROM `user` where role = '"+Role.getChauffeur()+"'");
        while (rs.next()) {                
               String nom=rs.getString("nom");
               String prenom=rs.getString("prenom");
               String permis = rs.getString("permis");
               User c=new User(nom,prenom,permis);
        oblist.add(c);    }
        return  oblist;
    }
    public Boolean findUserByEmail(String email) {
        User user = null;
        String req = "select * from User where mail =?";
        PreparedStatement preparedStatement;
        try {
         preparedStatement = con.prepareStatement(req);
            preparedStatement.setString(1, email );
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               user=new User();
               user.setId(resultSet.getInt("id"));
               user.setMail(resultSet.getString("mail"));
                 
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (user == null) {
            return false;
        }
        return true;
    
    }
    public User finUserById(int id)
    {
          User user=new User();
         
         try {
             String requete = "select * from user where id='"+id+ "'"; 
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery(requete);
            
     
     
             while(rs.next())
             {
                   user.setId(rs.getInt("id"));
                 user.setNom(rs.getString("nom"));
                 user.setPrenom(rs.getString("prenom"));
                 user.setMail(rs.getString("mail"));
                 user.setPhoto(rs.getString("image"));
                 user.setTelephone(rs.getInt("Telephone"));
                 user.setRole(Role.valueOf(rs.getString("role")));
               
                
             }
            
           
         } catch (SQLException ex) {
           
         }
              System.out.println(user.toString());    
         return user;
    }
    
    

  
}
