/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.gui;

import com.wassalni.entites.User;
import com.wassalni.services.ChauffeurService;
import com.wassalni.services.FtpUpload;
import com.wassalni.services.Password;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
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
    @FXML
    private Label labelemail;
    @FXML
    private Label labelNum;
    
    
    Boolean verificationUserPhone = false;
    Boolean verificationUserNom = false;
    Boolean verificationUserPrenom = false;
    Boolean verificationUserEmail = false;
    Boolean verificationLicence = false;
    Boolean verificationUserMdp = false;
    Boolean verificationPermis = false;
    Boolean verificationPhoto = false;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     @FXML
    private void signup(ActionEvent event) throws IOException, SQLException {
        
        if (verificationUserPhone == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("Veuillez remplir le telephone");
            alert.show();

        } else if (verificationUserNom == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("Veuillez remplir le nom");
            alert.show();

        } else if (verificationUserPrenom == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("Veillez remplir le prenom");
            alert.show();

        } else if (verificationUserEmail == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("Veuillez remplir l'email");
            alert.show();

        } /**else if (verificationLicence == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("Veuillez choisir votre Licence");
            alert.show();

        } **/else if (verificationUserMdp == false) {

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("Veuillez resaissir votre Mot de Passe Correctement");
            alert.show();

        }/** else if ( verificationPermis == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("Veuillez choisir votre permis ");
            alert.show();

        }
        else if ( verificationPhoto == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("Veuillez choisir votre photo ");
            alert.show();

        }**/else {    
        
            Password md = new Password();
            String mdpCrypte1 = md.hashPassword(psPass.getText());
            //FtpUpload  Upload = new FtpUpload();
           // Upload.FTPTransfer(tfPhoto);
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
    @FXML
    private void uploadL(ActionEvent event) {
        
        FileChooser fc = new FileChooser();
        FtpUpload Upload = new FtpUpload();
        String imageFile = "";
        File f = fc.showOpenDialog(null);
        System.out.println(f.getName());
        if (f != null) {
            Upload.FTPTransfer(f);
            imageFile = "http://127.0.0.1/"+f.getName();
            tfLicence.setText(imageFile);
            System.out.println("uploaded");
        }
    }
    
        @FXML
    private void uploadA(ActionEvent event) {
        
        FileChooser fc = new FileChooser();
        FtpUpload Upload = new FtpUpload();
        String imageFile = "";
        File f = fc.showOpenDialog(null);
        System.out.println(f.getName());
        if (f != null) {
            Upload.FTPTransfer(f);
            imageFile = "http://127.0.0.1/"+f.getName();
            tfPermis.setText(imageFile);
            System.out.println("uploaded");
        }
    }
    
    
    @FXML
    private void precedent(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/gui/signIn.fxml"));
            Parent root = loader.load();
            SignInController signin = loader.getController();
            tfPrenom.getScene().setRoot(root);
        } catch (IOException ex) {

        }
    }
    
    
     @FXML
    private void controlNom(KeyEvent event) {

        if (tfNom.getText().trim().equals("")) {

            verificationUserNom = false;

        } else {

            verificationUserNom = true;
        }
    }

    @FXML
    private void controlPrenom(KeyEvent event) {
        if (tfPrenom.getText().trim().equals("")) {

            verificationUserPrenom = false;

        } else {

            verificationUserPrenom = true;
        }
    }
    
    @FXML
    private void controlEmail(KeyEvent event) {

        ChauffeurService ps = new ChauffeurService();
        if (ps.findUserByEmail(tfMail.getText().trim()) == true) {
            labelemail.setText("Email Existe déja");
            verificationUserEmail = false;
        }
        if (ps.findUserByEmail(tfMail.getText().trim()) == false) {//alphanumerique@alphanumerique.com
            //{ici longeur  }
            //debut ^
            //fin $
            String email_pattern = "^[a-zA-Z]+[a-zA-Z0-9\\._-]*[a-zA-Z0-9]@[a-zA-Z]+" + "[a-zA-Z0-9\\._-]*[a-zA-Z0-9]+\\.[a-zA-Z]{2,4}$";
            Pattern pattern = Pattern.compile(email_pattern);
            Matcher matcher = pattern.matcher(tfMail.getText());

            if (matcher.matches()) {       //if   matcher ne contient pas la format   
                labelemail.setVisible(true);
                labelemail.setText("Email valide !");
                verificationUserEmail = true;
                labelemail.setText("");

            } else {
                labelemail.setVisible(true);
                labelemail.setText("Email Format invalide !");
                // JOptionPane.showMessageDialog(null, "Email Format invalide");
                verificationUserEmail = false;

            }
        }
    }
     @FXML
    private void controlNumero(KeyEvent event) {

        System.out.println(tfTel.getText().trim());
        if (tfTel.getText().trim().length() == 7) {
            int nbChar = 0;
            for (int i = 1; i < tfTel.getText().trim().length(); i++) {
                char ch = tfTel.getText().charAt(i);

                if (Character.isLetter(ch)) {

                    nbChar++;

                }
                System.out.println(nbChar);
            }

            if (nbChar == 0) {
                labelNum.setText("");
                verificationUserPhone = true;
            } else {
                labelNum.setText("numéro invalide  "
                        + " Il existe des caractères");
                verificationUserPhone = false;

            }

        } else {
            labelNum.setText("Il faut 8 chiffres");
            verificationUserPhone = false;
        }

    }

    @FXML
    private void controlMDP(KeyEvent event) {

        if (psPass.getText().trim().equals("")) {

            verificationUserMdp = false;

        } else {

            verificationUserMdp = true;

        }
    }
    
}
