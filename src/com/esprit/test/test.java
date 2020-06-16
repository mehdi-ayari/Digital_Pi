/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.itextpdf.text.DocumentException;
import com.wassalni.entites.Voyage;
import com.wassalni.services.ServiceVoyage;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Mahdi
 */
public class test extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        //launch(args);
        
        Voyage voy = new Voyage(1, 1);
        ServiceVoyage v= new ServiceVoyage();
        
        try {
            v.ajouter(voy);
        } catch (SQLException ex) {
        }
    }
    
}
