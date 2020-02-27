/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.GUIVoyage;

import com.wassalni.entites.Voyage;
import com.wassalni.services.ServiceVoyage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CHOUCHANE MD
 */
public class VoyageController implements Initializable {

    @FXML
    private TableView<Voyage> TableVoyage;
    @FXML
    private TableColumn<Voyage,Integer> refId;
    @FXML
    private TableColumn<Voyage,Float> refdistance;
    @FXML
    private TableColumn<Voyage,Timestamp> refdate;
    @FXML
    private TableColumn<Voyage, Integer> refreservation;
    @FXML
    private TableColumn<Voyage,String> refdistination;
    @FXML
    private Button Map;
    public ObservableList<Voyage> data = FXCollections.observableArrayList();
    ServiceVoyage sv = new ServiceVoyage();
    public static String dest;
        Voyage voyageselectionner = new Voyage();
    int indexProduitSelectionner;
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        TableVoyage.setOnMouseClicked((event) -> {
            if (event.getClickCount()==2){
                voyageselectionner = TableVoyage.getItems().get(TableVoyage.getSelectionModel().getSelectedIndex());
                  //System.out.println("Produit selectionnner"+ProduitSelectionner);
                  indexProduitSelectionner=TableVoyage.getSelectionModel().getSelectedIndex();
                  
            dest = voyageselectionner.getDistination();
                System.out.println(dest);
            
            }
        });
        
                     
        try {
            data.addAll(sv.readAll());
        } catch (SQLException ex) {
            Logger.getLogger(VoyageController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
      

        this.refId.setCellValueFactory(new PropertyValueFactory<>("id_voyage"));

        this.refdistance.setCellValueFactory(new PropertyValueFactory<>("distance"));

        this.refdate.setCellValueFactory(new PropertyValueFactory<>("date_voyage"));
        this.refreservation.setCellValueFactory(new PropertyValueFactory<>("reservation_id_res"));
        this.refdistination.setCellValueFactory(new PropertyValueFactory<>("distination"));
        //int id = Integer.parseInt(refreservation.getText());
        this.TableVoyage.setItems(data);
        this.TableVoyage.setEditable(true);
        // TODO
      /*  destination = refdistination.getText();
                String req = "select destination from reservation where id_res ="+ id;*/
                

    }    

    @FXML
    private void ajouter(ActionEvent event) {
                try {
            Parent root = FXMLLoader
        .load(getClass().getResource("Map.fxml"));
            
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Map");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
    }
    
 
}
