/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.wassalni.entites.Reservation;
import com.wassalni.entites.Type;
import com.wassalni.services.ReservationService;
import java.sql.SQLException;
import java.util.List;
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
//        Parent root = FXMLLoader.load(getClass().getResource("Interface_reservation_client.fxml"));
        Parent root1 = FXMLLoader.load(getClass().getResource("Interface_reservation_business.fxml"));

    
        Scene scene1 = new Scene(root1);
//        Scene scene = new Scene(root);
        
        
        stage.setScene(scene1);
        stage.show();
        
        ////         ReservationService ser = new ReservationService();
////        Reservation r1 = new Reservation("mourouj 2","2/12/566",Type.valueOf("Taxi"),15.0f,1,1);
////          Reservation r1 = new Reservation();
////          r1.setDestination(dest);
//        try {
//         Interface_Res_Controller.ajouter(r);
//         List<Reservation> list = ser.readAll();
//            System.out.println(list);
//            
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
    
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch(args);
       
}}
