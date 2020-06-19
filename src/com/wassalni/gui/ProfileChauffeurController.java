/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.gui;


import com.wassalni.entites.User;
import static com.wassalni.gui.PannelChauffeurController.idusers;
import com.wassalni.services.ChauffeurService;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author jawed
 */
public class ProfileChauffeurController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
@FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfMail;   
    public static int idusers = 0;
     private Connection con;
    private Statement ste;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idusers = SignInController.userIden;
        ChauffeurService ser = new ChauffeurService();
        User u = ser.finUserById(idusers);
        System.out.println(u.getNom());
        tfNom.setText(u.getNom());
        tfPrenom.setText(u.getPrenom());
        tfMail.setText(u.getMail());
        
    }    
    
    public void modifier() throws SQLException{
        PreparedStatement pre = con.prepareStatement("UPDATE `user` SET `nom`='"+tfNom+"',`prenom`='"+tfPrenom+"' WHERE `id`='"+idusers+"';");
        pre.executeUpdate();
        System.out.println("updated");
    }
    
}
