/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.gui;

import com.wassalni.entites.User;
import com.wassalni.services.ChauffeurService;
import com.wassalni.services.Password;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author jawed
 */
public class SignUPChauffeurController implements Initializable {

     @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private TextField tfMail;   
    @FXML
    private TextField tfTel;
    @FXML
    private PasswordField psPass;
    @FXML
    private TextField tfPhoto;
    @FXML
    private TextField tfPermis;
    @FXML
    private TextField tfLicence;    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    private void signup(ActionEvent event) throws IOException, SQLException {
            Password md = new Password();
            String mdpCrypte1 = md.hashPassword(psPass.getText());
            String nomC = tfNom.getText();
            String prenomC = tfPrenom.getText();
            String mailC = tfMail.getText();
            String telC = tfTel.getText();
            String Photo = tfPhoto.getText();
            String permiC = tfPermis.getText();
            String licence = tfLicence.getText();
            User chauffeur = new User();
            ChauffeurService sp = new ChauffeurService();
            chauffeur.setNom(nomC);
            chauffeur.setPrenom(prenomC);
            chauffeur.setMail(mailC);
            chauffeur.setTelephone(Integer.parseInt(telC));
            chauffeur.setMotDePasse(mdpCrypte1);
            chauffeur.setPhoto(Photo);
            chauffeur.setPermis(permiC);
            chauffeur.setLicence(licence);
            sp.ajouter(chauffeur); 
            TrayNotification tray = new TrayNotification("Successfully",
                    "Inscription Effectuée avec Succés", NotificationType.SUCCESS);
            tray.setAnimationType(AnimationType.SLIDE);
            tray.showAndDismiss(Duration.seconds(10));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/gui/signIn.fxml"));
            Parent root = loader.load();
            SignInController signin = loader.getController();
            tfNom.getScene().setRoot(root);
    }
    
}
