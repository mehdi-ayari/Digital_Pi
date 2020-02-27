/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.wassalni.entites.Reservationbusiness;
import com.wassalni.services.ReservationbusinessService;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

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
   int indexreservationbusines;
   int idR;

    
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
    @FXML
    private TableColumn<Reservationbusiness, Timestamp> dateres;

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
        prenomclient.setCellValueFactory(new PropertyValueFactory("prenon_client_entreprise") );
        pointdepart.setCellValueFactory(new PropertyValueFactory("point_depart") );
        dateres.setCellValueFactory(new PropertyValueFactory("date_reservation") );
        tablereservation.getItems().addAll(reservations);
        reverseButton(true);
        
        tablereservation.setOnMouseClicked(event->{
        //pour modifier un produit il faut faire deux click
              if (event.getClickCount() == 2) {
                  //activer les Buttons 
                  reverseButton(false);
                  
                  Timestamp stamp = Timestamp.valueOf(datedepart.getText());
                          
                  String date = String.valueOf(stamp);
                      System.out.println(date);
                      System.out.println(stamp);
                  //String mjr=date.substring(0,11);
//                  String heure=date.substring(12,14);
//                  String minute=date.substring(15,17);
                 // LocalDate ndate = LocalDate.parse(date.substring(0,11));
                 
                  Reservationbusinessselectionner = tablereservation.getItems().get(tablereservation.getSelectionModel().getSelectedIndex());
                  indexreservationbusines=tablereservation.getSelectionModel().getSelectedIndex();
                  modifdestination.setText(Reservationbusinessselectionner.getDestination());
                 modifdepart.setText(Reservationbusinessselectionner.getPoint_depart());
//                  modifnom.setText(Reservationbusinessselectionner.);
//                  modifprenom.setText(Reservationbusinessselectionner.);
                  modifdated.setValue(LocalDate.parse(date.substring(0,10)));
                  modifheured.setText(date.substring(11,13));
                  modifminuted.setText(date.substring(14,16));
                 
                  
               
                 
              }
             
                    });
    }  

    
    public void reverseButton(Boolean etat){
        btnmodifier.setDisable(etat);
        btnsupprimer.setDisable(etat);
    }

    @FXML
    private void onajouter(ActionEvent event) {
        Timestamp datr = new Timestamp(System.currentTimeMillis());
        String heure = heured.getText();
        String min = minuted.getText();
        LocalDate d = dated.getValue();
        String mdy= d.toString();
        String newdate = mdy+" "+heure+":"+min+":"+"00";
        Timestamp date_depart=Timestamp.valueOf(newdate) ;
        
        Reservationbusiness rb = new Reservationbusiness();
        rb.setDate_depart(date_depart);
        rb.setDestination(modifdestination.getText());
        System.out.println("destination ajouter");
        System.out.println(modifdestination.getText());
        rb.setDate_reservation(datr);
        rb.setPoint_depart(depart.getText());

        rb.setNom_client_entreprise(modifnom.getText());
        rb.setPrenom_client_entreprise(modifprenom.getText());
        
        
        try {
            rsb.ajouter(rb);
            ref();
        } catch (SQLException ex) {
        }
        
    }
    public void ref() {
        tablereservation.getItems().clear();
        try {
            tablereservation.getItems().addAll(rsb.readAll());
        } catch (SQLException ex) {
        }
    }

    @FXML
    private void Onmodifier(ActionEvent event) {
       String heure = heured.getText();
        String min = minuted.getText();
        LocalDate d = dated.getValue();
        String mdy= d.toString();
        String newdate = mdy+"-"+heure+"-"+min+"-"+"00";
        Timestamp date_depart=Timestamp.valueOf(newdate) ;
       Timestamp datr = new Timestamp(System.currentTimeMillis());
       idR = Reservationbusinessselectionner.getId_res_business();
       System.out.println(idR);
       Reservationbusinessselectionner.setId_res_business(idR);
       Reservationbusinessselectionner.setDestination(modifdestination.getText());
       Reservationbusinessselectionner.setDate_depart(datr);
       Reservationbusinessselectionner.setDate_reservation(date_depart);
       Reservationbusinessselectionner.setPoint_depart(modifdepart.getText());
       Reservationbusinessselectionner.setNom_client_entreprise(modifnom.getText());
       Reservationbusinessselectionner.setPrenom_client_entreprise(modifprenom.getText());
       
        try {
            rsb.update(Reservationbusinessselectionner);
        } catch (SQLException ex) {
        }
       ref();

                        
    }
    
    
    
}
