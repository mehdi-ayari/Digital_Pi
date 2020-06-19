/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.services;

import com.wassalni.Iservices.IEntreprise;
import com.wassalni.entites.User;
import com.wassalni.utilits.DataBase;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author jawed
 */
public class EntrepiseService implements IEntreprise<User>{

    private Connection con;
    private Statement ste;
    public EntrepiseService() {
        con = DataBase.getInstance().getConnection();
    }
    @Override
    public void ajouter(User p) throws SQLException {
         PreparedStatement pre=con.prepareStatement("INSERT INTO `wassalni_data_base`.`user` (`nom`, `prenom`, `mail`, `telephone`"
            + " ,`adresse`,`role`,`password`, `nbr_emp`)"
            + " VALUES (?,?,?,?,?,?,?,?,?);");
        pre.setString(1, p.getNom());
        pre.setString(2, p.getPrenom());
        pre.setString(3, p.getMail());
        pre.setInt(4, p.getTelephone());
        pre.setString(5, p.getAdresse());
        pre.setString(6,String.valueOf(Role.getEntreprise()));
        pre.setString(7, p.getMotDePasse());
        pre.setInt(8, p.getNbr_emp());
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
    public List<User> readAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
