/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.GUIVoyage;

import com.wassalni.entites.Voyage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
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
 * @author CHOUCHANE MD
 */
public class HomePage extends Application {
    
        private Connection con;
        private Statement ste;
    
    @Override
    public void start(Stage primaryStage) {
        //List<Timestamp> dateR=new ArrayList<>();
          /*  try {
                
                ste=con.createStatement();
                ResultSet rs=ste.executeQuery("select date_reservation from reservation r inner join voyage v where date_reservation between ( CURRENT_TIMESTAMP() - 00000000000001 and  CURRENT_TIMESTAMP() + 00000000000001 ) ");
                while (rs.next()) {
                    Timestamp dateRes=rs.getTimestamp(1);
                    dateR.add(dateRes);
                }
                            } catch (SQLException ex) {
                Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
            } */
         //   System.out.println(dateR);
                    
          //  if(dateR != null){
            
                    try {
                        
                        
                        Parent root = FXMLLoader
                                .load(getClass().getResource("VerifVoyage.fxml"));
                        
                        Scene scene = new Scene(root);
                        
                        primaryStage.setTitle("WASSALNI!");
                        primaryStage.setScene(scene);
                        primaryStage.show();
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }
             //   }
    }
    
                
                /**
                 * @param args the command line arguments
                 */

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
