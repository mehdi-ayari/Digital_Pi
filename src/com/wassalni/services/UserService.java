/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.services;

import com.wassalni.entites.User;
import com.wassalni.utilits.DataBase;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jawed
 */
public class UserService {
    public User connecter(String login) throws SQLException{
        
       
            String req="Select * from user WHERE nom='"+login+"'or mail='"+login+"'";
            Statement stat= DataBase.getInstance().getConnection().createStatement();           
            ResultSet rs= stat.executeQuery(req);
            User user=new User();

            while (rs.next()) {     
                
                user.setId(rs.getInt("id"));
                user.setNom(rs.getString("nom"));
                user.setMotDePasse(rs.getString("password"));
                user.setRole(Role.valueOf(rs.getString("role")));

        }
            
            
            
   
          
                System.out.println("*************************************");
                System.out.println(user.getNom());
                System.out.println("*************************************");
  
        return user;
            
            
     }
    
    
        public User finUserById(int id)
    {
          User user=new User();
         
         try {
             String requete = "select * from User where id='"+id+ "'"; 
             Statement st=DataBase.getInstance().getConnection().createStatement();
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
