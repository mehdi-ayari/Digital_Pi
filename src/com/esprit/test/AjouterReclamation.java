/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
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
    private void ajouterReclamation(ActionEvent event) {
    }

    @FXML
    private void AfficherReclamation(ActionEvent event) {
    }
    
}
