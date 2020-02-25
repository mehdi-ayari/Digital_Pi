/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author Mahdi
 */
public class Interface_reservation_businessController implements Initializable {

    @FXML
    private TableColumn<?, ?> dateresb;
    @FXML
    private TableColumn<?, ?> depart;
    @FXML
    private TableColumn<?, ?> destination;
    @FXML
    private TableColumn<?, ?> idresb;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
