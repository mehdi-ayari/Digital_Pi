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
    private TableColumn<String, Promotion> Col_nom;

    @FXML
    private TableColumn<String, Promotion> Col_description;

    @FXML
    private TableColumn<String, Promotion> Col_date_debut;

    @FXML
    private TableColumn<String, Promotion> Col_date_fin;

    @FXML
    private TableColumn<String, Promotion> Col_pourcentage;

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
        
        
    }    
    
}
