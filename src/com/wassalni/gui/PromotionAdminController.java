/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.gui;

import com.wassalni.entites.Promotion;
import com.wassalni.services.PromotionService;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author UnKnOWn
 */
public class PromotionAdminController implements Initializable {
    
      @FXML
    private ImageView A;

    @FXML
    private TextField tfNom;

    @FXML
    private TextField tfdate_debut;

    @FXML
    private TextField tfdescription;

    @FXML
    private Button B;

    @FXML
    private TextField tfdate_fin;

    @FXML
    private TextField tfpourcentage;

    PromotionService pr = new PromotionService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
         B.setOnAction(e->{
                      
             try {
                 String Nom= tfNom.getText();
                 Timestamp date_debut= Timestamp.valueOf(tfdate_debut.getText());
                 Timestamp date_fin= Timestamp.valueOf(tfdate_fin.getText());
                 int pourcentage= Integer.valueOf(tfpourcentage.getText());
                 String description= tfdescription.getText();
                 Promotion p = new Promotion(Nom,pourcentage, date_debut, date_fin, description);
                 pr.ajouterPromotion(p);
             } catch (SQLException ex) {
                 Logger.getLogger(PromotionAdminController.class.getName()).log(Level.SEVERE, null, ex);
             }
                                              

                        
		});

    }    
    
}
