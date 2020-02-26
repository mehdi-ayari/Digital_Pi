/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.wassalni.entites.Reservationbusiness;
import com.wassalni.services.ReservationbusinessService;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Mahdi
 */
public class reservation_businessController implements Initializable{
 
    ReservationbusinessService rsb = new ReservationbusinessService();
    Reservationbusiness Reservationbusinessselectionner = new Reservationbusiness();
    private List<Reservationbusiness> reservations= new ArrayList<>() ;

    
    @FXML
    private TextField depart;
    @FXML
    private TextField destination;
    @FXML
    private DatePicker dated;
    @FXML
    private TextField heured;
    @FXML
    private TextField minuted;
    @FXML
    private Button btnajouter;
    @FXML
    private TableColumn<Reservationbusiness, Timestamp> datedepart;
    @FXML
    private TableColumn<Reservationbusiness, String> destinationview;
    @FXML
    private TableColumn<Reservationbusiness, String> nomclient;
    @FXML
    private TableColumn<Reservationbusiness, String> prenomclient;
    @FXML
    private TableColumn<Reservationbusiness, String> pointdepart;
    @FXML
    private TableColumn<?, String> nomchauffeur;
    @FXML
    private TableColumn<?, String> prenomchauffeur;
    @FXML
    private TextField nom;
    @FXML
    private TextField prenom;
    @FXML
    private Button btnsupprimer;
    @FXML
    private TextField modifdestination;
    @FXML
    private DatePicker modifdated;
    @FXML
    private TextField modifheured;
    @FXML
    private TextField modifminuted;
    @FXML
    private TextField modifnom;
    @FXML
    private TextField modifprenom;
    @FXML
    private TextField modifdepart;
    @FXML
    private Button btnmodifier;
    @FXML
    private TableView<Reservationbusiness> tablereservation;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            reservations=rsb.readAll();
        } catch (SQLException ex) {
        }
//        idres.setCellValueFactory(new PropertyValueFactory("id_res") );
        datedepart.setCellValueFactory(new PropertyValueFactory("date_depart") );
        destinationview.setCellValueFactory(new PropertyValueFactory("destination") );
        nomclient.setCellValueFactory(new PropertyValueFactory("nom_client_entreprise") );
        prenomclient.setCellValueFactory(new PropertyValueFactory("prenom_client_entreprise") );
        pointdepart.setCellValueFactory(new PropertyValueFactory("point_depart") );
//        idchauffeur.setCellValueFactory(new PropertyValueFactory("voiture_id_voiture") );
        tablereservation.getItems().addAll(reservations);
        reverseButton(true);
    }    
    
    public void reverseButton(Boolean etat){
        btnmodifier.setDisable(etat);
        btnsupprimer.setDisable(etat);
    }

    @FXML
    private void onajouter(ActionEvent event) {
    }

    @FXML
    private void Onmodifier(ActionEvent event) {
    }
    
    
    
}
