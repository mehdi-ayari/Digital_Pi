/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.gui;

import com.wassalni.entites.User;
import com.wassalni.entites.Voyage;
import static com.wassalni.gui.PannelChauffeurController.idusers;
import com.wassalni.services.ChauffeurService;
import com.wassalni.services.ServiceVoyage;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author jawed
 */
public class PannelClientController implements Initializable {

    @FXML
    private AnchorPane container_chauffeur;
    @FXML
    private ImageView image;
    @FXML
    private Label nom;
    public static int idusers = 0;
      /*      Voyage v = new Voyage(5);
        ServiceVoyage sv = new ServiceVoyage();*/
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        idusers = SignInController.userIden;
        System.out.println(idusers);
        ChauffeurService ser = new ChauffeurService();
        User u = ser.finUserById(idusers);
        System.out.println(u.getNom());
//        image.setImage(new Image(u.getPhoto()));
        nom.setText(u.getNom());


        
    }    
    public AnchorPane getContainer_admin() {
        return container_chauffeur;
    }

    public void setContainer_chauffeur(AnchorPane container_chauffeur) {
        this.container_chauffeur = container_chauffeur;
    }
    private void profil(ActionEvent event) throws IOException {
        
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/gui/ListeAffichage.fxml"));
            Parent root = loader.load();       
            container_chauffeur.getChildren().setAll(root);
    }

    @FXML
    private void Reservation(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/guiRes/Interface_reservation_client.fxml"));
            Parent root = loader.load();       
            container_chauffeur.getChildren().setAll(root);
    }

    @FXML
    private void News(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/esprit/gui/AddNews.fxml"));
            Parent root = loader.load();       
            container_chauffeur.getChildren().setAll(root);
    }

    @FXML
    private void voyage(ActionEvent event) throws IOException, SQLException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/GUIVoyage/voyage.fxml"));
            Parent root = loader.load();       
            container_chauffeur.getChildren().setAll(root);
          //  sv.ajouter(v);
    }

    @FXML
    private void Reclamation(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/test/AfficherReclamation.fxml"));
            Parent root = loader.load();       
            container_chauffeur.getChildren().setAll(root);
    }

    @FXML
    private void Promotion(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/gui/ListePromoClient.fxml"));
            Parent root = loader.load();       
            container_chauffeur.getChildren().setAll(root);
    }
    
}
