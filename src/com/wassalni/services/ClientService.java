
package com.wassalni.services;

import com.wassalni.Iservices.IClient;
import com.wassalni.entites.User;
import com.wassalni.utilits.DataBase;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author jawed
 */
public class ClientService implements IClient<User> {
    private Connection con;
    private Statement ste;
    public ClientService() {
        con = DataBase.getInstance().getConnection();
    }
    @Override
    public void ajouter(User p) throws SQLException {
        PreparedStatement pre=con.prepareStatement("INSERT INTO `wassalni_data_base`.`user` (`nom`, `prenom`, `mail`, `telephone`"
            + " ,`adresse`,`role`,`mdp`, `photo`)"
            + " VALUES (?,?,?,?,?,?,?,?);");
        
        
    pre.setString(1, p.getNom());
    pre.setString(2, p.getPrenom());
    pre.setString(3, p.getMail());
    pre.setInt(4, p.getTelephone());
    pre.setString(5, p.getAdresse());
    pre.setString(6,String.valueOf(Role.getClient()));
    pre.setString(7, p.getMotDePasse());
    pre.setString(8, p.getPhoto());
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
                 user.setPhoto(rs.getString("photo"));
                 user.setTelephone(rs.getInt("Telephone"));
                 user.setRole(Role.valueOf(rs.getString("role")));
               
                
             }
            
           
         } catch (SQLException ex) {
           
         }
              System.out.println(user.toString());    
         return user;
    }
    
    
}
