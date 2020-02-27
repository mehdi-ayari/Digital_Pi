/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.services;

import com.wassalni.entites.User;
import com.wassalni.utilits.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jawed
 */
public class AdminService {
      private Connection con;
    private Statement ste;

    public AdminService() {
        con = DataBase.getInstance().getConnection();
    }
     public void supprimerUser(List<User> users) {
        for (User user : users) {

            try {
                User userfound = new User();

                userfound = finUserById(user.getId());

                String requete = "delete from User where id=?";
                PreparedStatement pst = con.prepareStatement(requete);
                pst.setInt(1, user.getId());
                pst.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(AdminService.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
     
    public User finUserById(int id) {
        User user = new User();

        try {
            String requete = "select * from User where id='" + id + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {
                 user.setId(rs.getInt("id"));
                 user.setNom(rs.getString("nom"));
                 user.setPrenom(rs.getString("prenom"));
                 user.setMail(rs.getString("mail"));
                 user.setPhoto(rs.getString("photo"));
                 user.setTelephone(rs.getInt("Telephone"));
                 user.setRole(Role.valueOf(rs.getString("role")));

                System.out.println(user.getNom());
            }

        } catch (SQLException ex) {

        }

        return user;
    } 
}
