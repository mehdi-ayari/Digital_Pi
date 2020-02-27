/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.GUIVoyage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author CHOUCHANE MD
 */
public class VerifVoyageController implements Initializable {

    @FXML
    private Button accept;
    @FXML
    private Button Refuse;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onClickAcc(ActionEvent event) {
                        try {
            Parent root = FXMLLoader
        .load(getClass().getResource("voyage.fxml"));
            
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("WASSALNI");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
    }

    @FXML
    private void onClickRef(ActionEvent event) {
                        try {
            Parent root = FXMLLoader
        .load(getClass().getResource("Map.fxml"));
            
            Scene scene = new Scene(root);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("WASSALNI");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
    }
    }
    
}
