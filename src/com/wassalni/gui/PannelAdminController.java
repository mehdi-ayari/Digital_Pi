/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.gui;

import com.wassalni.entites.Voyage;
import com.wassalni.services.ServiceVoyage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author jawed
 */
public class PannelAdminController implements Initializable {

    private AnchorPane container_Admin;
    @FXML
    private Label nom;
    @FXML
    private ImageView image;
    @FXML
    private AnchorPane container_chauffeur;
                    Voyage v = new Voyage(5);
        ServiceVoyage sv = new ServiceVoyage();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    public AnchorPane getContainer_admin() {
        return container_Admin;
    }

    public void setContainer_admin(AnchorPane container_Admin) {
        this.container_Admin = container_Admin;
    }
     @FXML
    private void profil(ActionEvent event) throws IOException {
        
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/gui/ListeAffichage.fxml"));
            Parent root = loader.load();       
            container_chauffeur.getChildren().setAll(root);
    }
 @FXML
    private void Reservation(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/guiRes/Interface_reservation_business.fxml"));
            Parent root = loader.load();       
            container_chauffeur.getChildren().setAll(root);
    }

    @FXML
    private void AddNews(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/esprit/gui/AddNews.fxml"));
            Parent root = loader.load();       
            container_chauffeur.getChildren().setAll(root);
    }

    @FXML
    private void voyage(ActionEvent event) throws IOException, SQLException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/GUIVoyage/voyage.fxml"));
            Parent root = loader.load();       
            container_chauffeur.getChildren().setAll(root);
            sv.ajouter(v);
    }

    @FXML
    private void Reclamation(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/test/AfficherReclamation.fxml"));
            Parent root = loader.load();       
            container_chauffeur.getChildren().setAll(root);
    }

    @FXML
    private void promotion(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/gui/PromotionAdmin.fxml"));

            Parent root = loader.load();       
            container_chauffeur.getChildren().setAll(root);
    }
}
