package com.esprit.test;

import com.wassalni.entites.Reservation;
import com.wassalni.entites.Type;
import com.wassalni.services.ReservationService;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Mahdi
 */
public class ReservationController implements Initializable {
        ReservationService ser = new ReservationService();
        private List<Reservation> reservations= new ArrayList<>() ;
        private Reservation ReservationSelectionner = new Reservation();
        private int indexReservationSelectionner;
 ObservableList list =FXCollections.observableArrayList("Taxi","Privée","camion");
    @FXML
    private Label nomch;
    @FXML
    private TextField txtdestination;
    @FXML
    private ChoiceBox<String> boxtype;
    @FXML
    private Label prench;
    @FXML
    private Label label2;
    @FXML
    private Button btnvalider;
    @FXML
    private Button btnannuller;
    private TextField dateres;
    @FXML
    private TextField txterreur;

    @FXML
    private TableView<Reservation> tablereservation;
    @FXML
    private TableColumn<Reservation, Integer> idres;
    @FXML
    private TableColumn<Reservation, String> destination;
    @FXML
    private TableColumn<Reservation, String> datereservation;
    @FXML
    private TableColumn<Reservation, Type> typereservation;
    @FXML
    private TableColumn<Reservation, Float> prixreservation;
    
    @FXML
    private TableColumn<?, ?> nomclient;
    @FXML
    private TableColumn<?, ?> prenclient;
    @FXML
    private TableColumn<?, ?> nomchauffeur;
    @FXML
    private TableColumn<?, ?> prenomchauffeur;
//    private TableColumn<Reservation, Integer> idclient;
//    private TableColumn<Reservation, Integer> idchauffeur;
    
    @FXML
    private Button btnmodifier;
    @FXML
    private Button btnsupprimer;
    @FXML
    private TextField txtmodifdestination;
    private TextField txtmodifdateres;
    @FXML
    private ComboBox<String> cmbmodiftype;
    private int idR;
    @FXML
    private Button btnmap;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        boxtype.setItems(list);
                          cmbmodiftype.setItems(list);

        reservations=ser.readAll();
        idres.setCellValueFactory(new PropertyValueFactory("id_res") );
        destination.setCellValueFactory(new PropertyValueFactory("destination") );
        datereservation.setCellValueFactory(new PropertyValueFactory("date_reservation") );
        typereservation.setCellValueFactory(new PropertyValueFactory("type_reservation") );
        prixreservation.setCellValueFactory(new PropertyValueFactory("prix") );
//        idclient.setCellValueFactory(new PropertyValueFactory("user_id_client") );
//        idchauffeur.setCellValueFactory(new PropertyValueFactory("voiture_id_voiture") );
        
        tablereservation.getItems().addAll(reservations);
        reverseButton(true);
        
        tablereservation.setOnMouseClicked(event->{
        //pour modifier un produit il faut faire deux click
              if (event.getClickCount() == 2) {
                  //activer les Buttons 
                  reverseButton(false);
                 
                  ReservationSelectionner = tablereservation.getItems().get(tablereservation.getSelectionModel().getSelectedIndex());
                  indexReservationSelectionner=tablereservation.getSelectionModel().getSelectedIndex();
                  txtmodifdestination.setText(ReservationSelectionner.getDestination());
//                  txtmodifdateres.setText(ReservationSelectionner.getDate_reservation());
                  cmbmodiftype.setValue(ReservationSelectionner.getType_reservation().toString());
                 
              }
             
                    });
    }    

    @FXML
    private void OnClickValider(ActionEvent event) {
        
        String dest = txtdestination.getText();
        Timestamp datr = new Timestamp(System.currentTimeMillis());
        String type = boxtype.getItems().toString();
        
        if(dest.equals(""))
            txterreur.setText("champs distination obligatoire");
        else
            if(datr.equals(""))
                txterreur.setText("date reservation obligatoire");
            else 
                if(type.equals(""))
                    txterreur.setText("type reservation obligatoire");
                else
         
          {
              Type ty =Type.valueOf(boxtype.getValue());
              
              Reservation r = new Reservation();
              r.setDate_reservation(datr);
              r.setDestination(dest);
              r.setType_reservation(ty);
              
              
            try {
                ser.ajouter(r);
                ref();
            } catch (SQLException ex) {
                System.out.println("erreur");
            }

           
          }
       
    }
    
    public void ref() {
        tablereservation.getItems().clear();
        tablereservation.getItems().addAll(ser.readAll());
    }

    @FXML
    private void OnClickRefuser(ActionEvent event) {
    }
    
    public void reverseButton(Boolean etat){
        btnmodifier.setDisable(etat);
        btnsupprimer.setDisable(etat);
    }

    @FXML
    private void onmodifier(ActionEvent event) {
                Timestamp datr = new Timestamp(System.currentTimeMillis());

          idR=ReservationSelectionner.getId_res();
                  System.out.println(idR);
                  ReservationSelectionner.setId_res(idR);
        ReservationSelectionner.setDestination(txtmodifdestination.getText());
       ReservationSelectionner.setDate_reservation(datr);
       ReservationSelectionner.setType_reservation(Type.valueOf(cmbmodiftype.getValue()));
       
     
        //System.out.println(ProduitSelectionner);
       ser.update(ReservationSelectionner);
       ref();
    }

    @FXML
    private void onsupprimer(ActionEvent event) {
        Reservation r = new Reservation();
        r.setDate_reservation(ReservationSelectionner.getDate_reservation());
        
        
        
            try {
                ser.delete(r);
                tablereservation.getItems().remove(ReservationSelectionner);
                
            } catch (SQLException ex) {
            }
    }

    @FXML
    private void onMap(ActionEvent event) {
    }

}