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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author user
 */
public class ModifierReclamationController implements Initializable {

    @FXML
    private Button tfReturn;
    @FXML
    private TextField fetitre;
    @FXML
    private TextArea fedesciption;
    @FXML
    private Label idrec;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ModifierReclamation(ActionEvent event) {
    }

    @FXML
    private void Retour(ActionEvent event) {
    }
    
}
