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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 * FXML Controller class
 *
 * @author user
 */
public class MenuReclamation implements Initializable {

    @FXML
    private TableView<?> table;
    @FXML
    private TableColumn<?, ?> tftitre;
    @FXML
    private TableColumn<?, ?> tfdate;
    @FXML
    private Button details;
    @FXML
    private Button tfadd;
    @FXML
    private Button tfmodif;
    @FXML
    private Button contactus1;
    @FXML
    private Label tfcount;
    @FXML
    private Button PDF;
    @FXML
    private TextField rechnom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void showdetails(ActionEvent event) {
    }

    @FXML
    private void SupprimerReclamation(ActionEvent event) {
    }

    @FXML
    private void roadToajout(ActionEvent event) {
    }

    @FXML
    private void GoModif(ActionEvent event) {
    }

    @FXML
    private void GoToAContactus1(ActionEvent event) {
    }

    @FXML
    private void smartsearchPrenom(KeyEvent event) {
    }
    
}
