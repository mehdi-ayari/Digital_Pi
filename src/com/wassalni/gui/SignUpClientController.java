/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.gui;

import com.wassalni.entites.User;
import com.wassalni.services.ChauffeurService;
import com.wassalni.services.ClientService;
import com.wassalni.services.FtpUpload;
import com.wassalni.services.Password;
import java.io.File;
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
import javafx.stage.FileChooser;
import javafx.util.Duration;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author jawed
 */
public class SignUpClientController implements Initializable {

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
            User client = new User();
            ClientService sp = new ClientService();
            client.setNom(nomC);
            client.setPrenom(prenomC);
            client.setMail(mailC);
            client.setTelephone(Integer.parseInt(telC));
            client.setMotDePasse(mdpCrypte1);
            client.setPhoto(Photo);
            client.setAdresse(permiC);
            sp.ajouter(client); 
            TrayNotification tray = new TrayNotification("Successfully",
                    "Inscription Effectuée avec Succés", NotificationType.SUCCESS);
            tray.setAnimationType(AnimationType.SLIDE);
            tray.showAndDismiss(Duration.seconds(10));
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/gui/signIn.fxml"));
            Parent root = loader.load();
            SignInController signin = loader.getController();
            tfNom.getScene().setRoot(root);
            
    }
    @FXML
    private void uploadP(ActionEvent event) {
        
        FileChooser fc = new FileChooser();
        FtpUpload Upload = new FtpUpload();
        String imageFile = "";
        File f = fc.showOpenDialog(null);
        System.out.println(f.getName());
        if (f != null) {
            Upload.FTPTransfer(f);
            imageFile = "http://127.0.0.1/"+f.getName();
            tfPhoto.setText(imageFile);
            System.out.println("uploaded");
        }
    }
    
}
