package com.esprit.test;

import com.wassalni.entites.Reservation;
import com.wassalni.entites.Type;
import com.wassalni.services.ReservationService;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

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
        boolean verifdestination;
        public static String dest;
//        boolean veriftype;
        
        
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
    private TextField txterreur;

    @FXML
    private TableView<Reservation> tablereservation;
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
    @FXML
    private TextField prix;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        boxtype.setValue("choisir votre type de reservation");
        boxtype.setItems(list);
                          cmbmodiftype.setItems(list);

        reservations=ser.readAll();
//        idres.setCellValueFactory(new PropertyValueFactory("id_res") );
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
        
        if (verifdestination == false) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText("Warning");
            alert.setContentText("Veuillez remplir la destination");
            alert.show();

        }
//        else if (veriftype== false) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Warning");
//            alert.setHeaderText("Warning");
//            alert.setContentText("Veuillez remplir le type de voiture");
//            alert.show();
//
//        }
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
        txtdestination.setText("");
       
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
        r.setId_res(ReservationSelectionner.getId_res());
        
        
        
            try {
                ser.delete(r);
                tablereservation.getItems().remove(ReservationSelectionner);
                
            } catch (SQLException ex) {
            }
    }

    @FXML
    private void onMap(ActionEvent event) throws IOException {
        dest = txtdestination.getText();
        
        
                Parent root = FXMLLoader.load(getClass().getResource("Map.fxml"));
    
        Scene scene1 = new Scene(root);
        
        Stage stage = new Stage();
        stage.setScene(scene1);
        stage.show();
        
        
    }

    @FXML
    private void controldestination(KeyEvent event) {
         if (txtdestination.getText().trim().equals("")) {

            verifdestination = false;

        } else {

            verifdestination = true;
        }
    }

//    @FXML
//    private void controltype(KeyEvent event) {
//         if (boxtype.getValue()!="Taxi" || boxtype.getValue()!="Privée" || boxtype.getValue()!="camion" ) {
//
//            veriftype = false;
//
//        } else {
//
//            veriftype = true;
//        }
//    }

}