/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.wassalni.entites.Reclamation;
import  com.esprit.test.MenuReclamation;
import com.wassalni.services.ReclamationService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author User
 */
public class ModifierReclamationController implements Initializable {

    @FXML
    private TextField fetitre;
    @FXML
    private TextArea fedesciption;
      private int idReclamation;
      Reclamation Rec =new Reclamation();
            ReclamationService SA =new ReclamationService();
    @FXML
    private Label idrec;
    @FXML
    private Button tfReturn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
              try {
            afficher_detail();
        } catch (SQLException ex) {
            Logger.getLogger(ModifierReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setIdToEdit(int id) {

        this.idReclamation = id;
    }
  private void afficher_detail() throws SQLException{
        int idd = MenuReclamation.Recl1.getId();
        
       this.idrec.setText(String.valueOf(idd));
        Rec= SA.Get_Reclamation_by_id(idd);

        
        idrec.setText(String.valueOf(Rec.getId()));
        fetitre.setText(Rec.getTitre());
        fedesciption.setText(Rec.getDescription()); }
    @FXML
    private void ModifierReclamation(ActionEvent event) throws SQLException, IOException {
       List<Reclamation> list = new ArrayList<>();
     int idd = MenuReclamation.Recl1.getId();
       

                        
         
          Reclamation s = new Reclamation();
          ReclamationService sa = new ReclamationService();
          list=sa.Get_Reclamation_by_Id(idd);
          s=list.get(0);
          
        s.setTitre(fetitre.getText());
        s.setDescription(fedesciption.getText());
        
        
        
        
        ReclamationService sp = new ReclamationService();
        try {
            sp.ModifierReclamation(s);
        } catch (SQLException ex) {
        }
        Parent root1 = FXMLLoader.load(getClass().getResource("AfficherReclamation.fxml"));
      
      
          tfReturn.getScene().setRoot(root1);
    }

    @FXML
    private void Retour(ActionEvent event) throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("AfficherReclamation.fxml"));
                  tfReturn.getScene().setRoot(root1);
    }
    
}
