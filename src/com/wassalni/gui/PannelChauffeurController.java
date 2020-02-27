/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author jawed
 */
public class PannelChauffeurController implements Initializable {
    @FXML
    private AnchorPane container_chauffeur;
        private Connection con;
        private Statement ste;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public AnchorPane getContainer_admin() {
        return container_chauffeur;
    }

    public void setContainer_chauffeur(AnchorPane container_chauffeur) {
        this.container_chauffeur = container_chauffeur;
    }
     @FXML
    private void profil(ActionEvent event) throws IOException {
        
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/gui/signIn.fxml"));
            Parent root = loader.load();       
            container_chauffeur.getChildren().setAll(root);
    }
    

    
}
