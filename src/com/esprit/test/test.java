/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.wassalni.services.MailService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 *
 * @author user
 */
public class test extends Application  {
     @Override
     public void start(Stage primaryStage) throws IOException{
     // Parent root = FXMLLoader.load(getClass().getResource("AjouterAnnonce.fxml"));
      Parent root1 = FXMLLoader.load(getClass().getResource("AfficherReclamation.fxml"));
      
      
     /* Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();*/
            
            Scene scene1 = new Scene(root1);
            primaryStage.setScene(scene1);
            primaryStage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    

    
}
