/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.GUI;

import com.wassalni.entites.Voyage;
import com.wassalni.services.ServiceVoyage;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
    
    
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                     
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

        this.TableVoyage.setItems(data);
        this.TableVoyage.setEditable(true);
        // TODO
    }    
    
}
