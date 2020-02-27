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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

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
   boolean verifnomclient ;
   boolean verifprenomclient ;
   boolean verifdestination ;
   boolean verifpointdepart ;
   boolean verifdate ;
   boolean verifheure ;
   boolean verifminute ;

    
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
    private Label controlenom;
    private Label controleprenom;
    private Label controlepoint;
    private Label controledestination;
    private Label controleheure;
    private Label controleminute;
    private Label controledate;

    
    
    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            reservations=rsb.readAll();
        } catch (SQLException ex) {
        }
        LocalDate now = LocalDate.now();
        dated.setValue(now);
        heured.setText("00");
        minuted.setText("00");
        
//        idres.setCellValueFactory(new PropertyValueFactory("id_res") );
        datedepart.setCellValueFactory(new PropertyValueFactory("date_depart") );
        destinationview.setCellValueFactory(new PropertyValueFactory("destination") );
        nomclient.setCellValueFactory(new PropertyValueFactory("nom_client_entreprise") );
        prenomclient.setCellValueFactory(new PropertyValueFactory("prenom_client_entreprise") );
        pointdepart.setCellValueFactory(new PropertyValueFactory("point_depart") );
        dateres.setCellValueFactory(new PropertyValueFactory("date_reservation") );
        tablereservation.getItems().addAll(reservations);
        reverseButton(true);
        
        tablereservation.setOnMouseClicked(event->{
        //pour modifier un produit il faut faire deux click
              if (event.getClickCount() == 2) {
                  //activer les Buttons 
                  reverseButton(false);
                  Reservationbusinessselectionner = tablereservation.getItems().get(tablereservation.getSelectionModel().getSelectedIndex());
                  indexreservationbusines=tablereservation.getSelectionModel().getSelectedIndex();
                  String date = Reservationbusinessselectionner.getDate_depart().toString();
//                  System.out.println(date);
//                  String date = String.valueOf(stamp);
//                  String SEPARATEUR = "-";
//                  
//                  String mja[]=date.split(SEPARATEUR);
//                  String mja1 = mja[0]+"/"+mja[1]+"/"+mja[2];
//                  LocalDate daten = LocalDate.parse(mja1);
//                  System.out.println(mja1);

//                      System.out.println(date);
//                      System.out.println(stamp);
                  
                  String heure=date.substring(11,13);
                  String minute=date.substring(14,16);
                  LocalDate ndate = LocalDate.parse(date.substring(0,10));
//                 
//                  Reservationbusinessselectionner = tablereservation.getItems().get(tablereservation.getSelectionModel().getSelectedIndex());
//                  indexreservationbusines=tablereservation.getSelectionModel().getSelectedIndex();
                  modifdestination.setText(Reservationbusinessselectionner.getDestination());
                 modifdepart.setText(Reservationbusinessselectionner.getPoint_depart());
                  modifdated.setValue(ndate);
                  modifheured.setText(date.substring(11,13));
                  modifminuted.setText(date.substring(14,16));
                  modifnom.setText(Reservationbusinessselectionner.getNom_client_entreprise());
                  modifprenom.setText(Reservationbusinessselectionner.getPrenom_client_entreprise());
                  
               
                 
              }
             
                    });
    
//    controledate.setVisible(false);
//        controleheure.setVisible(false);
//        controleminute.setVisible(false);
//        controledestination.setVisible(false);
//        controlenom.setVisible(false);
//        controleprenom.setVisible(false);
//        controlepoint.setVisible(false);
    
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
        Timestamp datedepart=Timestamp.valueOf(newdate) ;
        
        if (verifnomclient == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("Veuillez remplir le nom");
            alert.show();

        }
        else if (verifprenomclient == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("Veuillez remplir le prenom");
            alert.show();
        }
        else if(verifdestination == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("Veuillez remplir la destination");
            alert.show();
        }
        else if(verifpointdepart == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("Veuillez remplir la point de depart");
            alert.show();
        }
        else if(verifdate == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("Veuillez remplir date et doit pas etre une ancienne date");
            alert.show();
        }
        else if (verifheure == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("Veuillez remplir le champ heure et doit etre entre 00 et 23");
            alert.show();
        }
        else if(verifminute == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("Veuillez remplir le champ minute et doit etre entre 00 et 60");
            alert.show();
        }
        else{
        
            
//        Timestamp datr = new Timestamp(System.currentTimeMillis());
//        String heure = heured.getText();
//        String min = minuted.getText();
//        LocalDate d = dated.getValue();
//        String mdy= d.toString();
//        String newdate = mdy+" "+heure+":"+min+":"+"00";
//        Timestamp datedepart=Timestamp.valueOf(newdate) ;
        
        Reservationbusiness rb = new Reservationbusiness();
        rb.setDate_depart(datedepart);
        rb.setDestination(destination.getText());
        rb.setDate_reservation(datr);
        rb.setPoint_depart(depart.getText());

        rb.setNom_client_entreprise(nom.getText());
        rb.setPrenom_client_entreprise(prenom.getText());
        
        
        try {
            rsb.ajouter(rb);
            ref();
        } catch (SQLException ex) {
        }
        
        }                   
    }
    
    

    @FXML
    private void Onmodifier(ActionEvent event) {
       String heure = modifheured.getText();
        String min = modifminuted.getText();
        LocalDate d = modifdated.getValue();
        String mdy= d.toString();
        String newdate = mdy+" "+heure+":"+min+":"+"00";
        Timestamp date_depart=Timestamp.valueOf(newdate) ;
       Timestamp datr = new Timestamp(System.currentTimeMillis());
       idR = Reservationbusinessselectionner.getId_res_business();
       System.out.println(idR);
       Reservationbusinessselectionner.setId_res_business(idR);
       Reservationbusinessselectionner.setDestination(modifdestination.getText());
       Reservationbusinessselectionner.setDate_depart(date_depart);
       Reservationbusinessselectionner.setDate_reservation(datr);
       Reservationbusinessselectionner.setPoint_depart(modifdepart.getText());
       Reservationbusinessselectionner.setNom_client_entreprise(modifnom.getText());
       Reservationbusinessselectionner.setPrenom_client_entreprise(modifprenom.getText());
       
        try {
            rsb.update(Reservationbusinessselectionner);
        } catch (SQLException ex) {
        }
       ref();

                        
    }
    
    public void ref() {
        tablereservation.getItems().clear();
        try {
            tablereservation.getItems().addAll(rsb.readAll());
        } catch (SQLException ex) {
        }
    
}

    @FXML
    private void onsupprimer(ActionEvent event) {
         Reservationbusiness rb = new Reservationbusiness();
        rb.setId_res_business(Reservationbusinessselectionner.getId_res_business());
        
        
        
            try {
                rsb.delete(rb);
                tablereservation.getItems().remove(Reservationbusinessselectionner);
                
            } catch (SQLException ex) {
            }
    }

    @FXML
    private void controlnomclient(KeyEvent event) {
     if (nom.getText().trim().equals("")) {

            verifnomclient = false;

        } else {

            verifnomclient = true;
        }
    
    }
    

    @FXML
    private void controlprenomclient(KeyEvent event) {
         if (prenom.getText().trim().equals("")) {

            verifprenomclient = false;

        } else {

            verifprenomclient = true;
        }
    
    }

    @FXML
    private void controlpoint(KeyEvent event) {
         if (depart.getText().trim().equals("")) {

            verifpointdepart = false;

        } else {

            verifpointdepart = true;
        }
    
    }

    @FXML
    private void controldestination(KeyEvent event) {
         if (destination.getText().trim().equals("")) {

            verifdestination = false;

        } else {

            verifdestination = true;
        }
    
    }

    @FXML
    private void controledate(KeyEvent event) {
                LocalDate now = LocalDate.now();

         if (dated.getValue()==null && dated.getValue().isBefore(now)) {

            verifdate = false;

        } else {

            verifdate= true;
        }
    
    }

    @FXML
    private void controlheure(KeyEvent event) {
        int i=Integer.parseInt(heured.getText());
         if (heured.getText().trim().equals("") && heured.getText().length()!=2 && i>60) {

            verifheure = false;

        } else {

            verifheure = true;
        }
    
    }

    @FXML
    private void controlminute(KeyEvent event) {
                int i=Integer.parseInt(minuted.getText());

         if (minuted.getText().trim().equals("") && minuted.getText().length()!=2 && i>23) {

            verifminute = false;

        } else {

            verifminute = true;
        }
    
    }
}
