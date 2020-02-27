/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.wassalni.entites.Reclamation;
import com.wassalni.services.MailService;
import com.wassalni.services.ReclamationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author MED HOUSSEM KAFFEL
 */
public class AjouterReclamation implements Initializable {

    @FXML
    private TextField feTitre;
    @FXML
    private TextArea feDescription;
    @FXML
    private Button tfretour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ajouterReclamation(ActionEvent event) throws IOException, Exception {
             Reclamation s = new Reclamation();
        if (feTitre.getText() == null || feDescription.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Champ vide.");
        }else{
        s.setTitre(feTitre.getText());
        s.setDescription(feDescription.getText());
        s.setuser_id(1);
        
        
        
        ReclamationService sp = new ReclamationService();
        try {
            sp.ajouter(s);
            MailService.SendMail("seifeddine.jemai@gmail.com", "test");
            
            
        } catch (SQLException ex) {
            Logger.getLogger(AjouterReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Parent root1 = FXMLLoader.load(getClass().getResource("AfficherReclamation.fxml"));
                  tfretour.getScene().setRoot(root1);
    
    }

    

    
}

    @FXML
    private void AfficherReclamation(ActionEvent event) throws IOException {
                Parent root1 = FXMLLoader.load(getClass().getResource("AfficherReclamation.fxml"));
                  tfretour.getScene().setRoot(root1);

    }

}

