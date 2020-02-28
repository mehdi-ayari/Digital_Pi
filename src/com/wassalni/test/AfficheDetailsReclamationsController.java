/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.wassalni.entites.Reclamation;
import com.wassalni.services.ReclamationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author user
 */
public class AfficheDetailsReclamationsController implements Initializable {

    @FXML
    private Button tfretour;
    @FXML
    private Label tfTitre;
    @FXML
    private Label tfDescri;
    @FXML
    private Label tfid;
          private int idReclamation;

    
    Reclamation Rec =new Reclamation();
            ReclamationService SA =new ReclamationService();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          try {
            afficher_detail();
        } catch (SQLException ex) {
            Logger.getLogger(ModifierReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO
    }    
 
     public void setIdToEdit(int id) {

        this.idReclamation = id;
    }
  private void afficher_detail() throws SQLException{
        int idd = MenuReclamation.Recl1.getId();
        
       this.tfid.setText(String.valueOf(idd));
        Rec= SA.Get_Reclamation_by_id(idd);

        
        tfid.setText(String.valueOf(Rec.getId()));
        tfTitre.setText(Rec.getTitre());
        tfDescri.setText(Rec.getDescription()); }
    @FXML
    private void RetourMenu(ActionEvent event) throws IOException {
            Parent root1 = FXMLLoader.load(getClass().getResource("AfficherReclamation.fxml"));
                  tfretour.getScene().setRoot(root1);
    }
    
}
