/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.wassalni.entites.Reservation;
import com.wassalni.entites.Type;
import com.wassalni.services.ReservationService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mahdi
 */
public class FXMLDocumentController implements Initializable {
 ObservableList list =FXCollections.observableArrayList("Taxi","Privée","camion");
    @FXML
    private Label nomch;
    @FXML
    private TextField txtdestination;
    @FXML
    private ChoiceBox<?> boxtype;
    @FXML
    private Label prench;
    @FXML
    private Label label2;
    @FXML
    private Button btnvalider;
    @FXML
    private Button btnannuller;
    @FXML
    private TextField dateres;
    @FXML
    private TextField txterreur;

    ReservationService ser = new ReservationService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        boxtype.setItems(list);
        
    }    

    @FXML
    private void OnClickValider(ActionEvent event) {
        
        String dest = txtdestination.getText();
        String datr = dateres.getText();
        String type = boxtype.getItems().toString();
        
        if (dest != null && datr!= null && type != null) 
          {
              Reservation r = new Reservation();
              r.setDate_reservation(datr);
              r.setDestination(dest);
              r.setType_reservation(Type.valueOf(type));
              
            try {
                ser.ajouter(r);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
          }
        else 
            txterreur.setText("erreur valodation");
        
    }

    @FXML
    private void OnClickRefuser(ActionEvent event) {
    }
    
}
