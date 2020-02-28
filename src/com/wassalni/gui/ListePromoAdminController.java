/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.gui;

import com.wassalni.entites.Promotion;
import com.wassalni.services.PromotionService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;



/**
 * FXML Controller class
 *
 * @author UnKnOWn
 */
public class ListePromoAdminController implements Initializable {
    
    
    @FXML
    private TableView<Promotion> tblData;

    @FXML
    private TableColumn<Promotion, String > Col_nom;

    @FXML
    private TableColumn<Promotion, String> Col_description;

    @FXML
    private TableColumn<Promotion, String> Col_date_debut;

    @FXML
    private TableColumn<Promotion, String> Col_date_fin;

    @FXML
    private TableColumn<Promotion, String> Col_pourcentage;

    @FXML
    private Label lblStatus;

    @FXML
    private ImageView A;
    
   PromotionService pr = new PromotionService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Col_nom.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getNom()));  
            Col_description.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getDescription()));
            Col_date_debut.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getDate_debut()));  
            Col_date_fin.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getDate_fin()));  
            Col_pourcentage.setCellValueFactory(c-> new SimpleStringProperty(c.getValue().getsPourcentage()));  
            PromotionService ps = new PromotionService();
            ObservableList<Promotion> list = ps.getAllPromotion();
            System.out.println(list);
            tblData.setItems(list);
        
        
        
    }    
    
}
