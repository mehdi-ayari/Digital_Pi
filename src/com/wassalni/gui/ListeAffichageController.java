/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.gui;

import com.wassalni.entites.User;
import com.wassalni.services.ChauffeurService;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author jawed
 */
public class ListeAffichageController implements Initializable {

    @FXML
    private TableView<User> tblData;
    @FXML
    private TableColumn<User , String> Col_Name;
    @FXML
    private TableColumn<User, String> Col_LastName;
    
    ObservableList<User> oblist = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             ChauffeurService SC = new ChauffeurService();
        try {
             oblist = SC.readAll();
        } catch (SQLException ex) {
            Logger.getLogger(ListeAffichageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Col_Name.setCellValueFactory(new PropertyValueFactory<>("nom"));
        Col_LastName.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        
                
        this.tblData.setItems(oblist);
    }
    
    
    
}
