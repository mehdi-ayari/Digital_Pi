/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.wassalni.entites.WeatherModel;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;

import org.json.JSONException;
 import javafx.scene.image.ImageView; 
 import java.util.logging.Level;  
 import java.util.logging.Logger;  
 import javafx.application.Application;  
import static javafx.application.Application.launch;
 import javafx.beans.value.ObservableValue;  
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
 public class WeatherController implements Initializable {  
     
   WeatherModel wm;  
   int cityID=3204623;  
   
   @FXML  
   private ToggleGroup cityTg;  
   @FXML  
   private Label cityNameLbl;  
   @FXML  
   private Label descriptionLbl;  
   @FXML  
   private Label temperatureLbl;  
   @FXML  
   private Label pressureLbl;  
   @FXML  
   private Label humidityLbl;  
   @FXML  
   private Label windLbl;  
   @FXML  
   private Label iconLbl;  
   @FXML  
   private Button refreshBtn;  
   @FXML  
   private Label timeLbl;  
     
   @FXML  
   private void initialize() throws ClassNotFoundException, JSONException {  
       
     wm = new WeatherModel(cityID);  
     System.out.println(wm.toString());  
       
     cityNameLbl.textProperty().bindBidirectional(wm.cityNameProperty());  
     descriptionLbl.textProperty().bindBidirectional(wm.descriptionProperty());  
     temperatureLbl.textProperty().bindBidirectional(wm.temperatureProperty());  
     pressureLbl.textProperty().bindBidirectional(wm.pressureProperty());  
     humidityLbl.textProperty().bindBidirectional(wm.humidityProperty());  
     windLbl.textProperty().bindBidirectional(wm.windProperty());  
       
     iconLbl.setGraphic(new ImageView("http://openweathermap.org/img/w/"+wm.getIconID()+".png"));  
     iconLbl.setScaleX(1.5);  
     iconLbl.setScaleY(1.5);  
     refreshBtn.setGraphic(new ImageView("/refresh1.png"));  
     refreshBtn.setScaleX(0.8);  
     refreshBtn.setScaleY(0.8);  
     timeLbl.setText(new java.util.Date().toString());  
     cityTg.selectedToggleProperty().addListener((observable,  
       oldValue, newValue) -> {  
       try {  
         toggle(observable, oldValue, newValue);  
       } catch (JSONException ex) {  
         Logger.getLogger(WeatherController.class.getName()).log(Level.SEVERE, null, ex);  
       } catch (ClassNotFoundException ex) {  
         Logger.getLogger(WeatherController.class.getName()).log(Level.SEVERE, null, ex);  
       }  
     });  
   }  
     
   public void start(Stage primaryStage) throws Exception {      
     URL fxmlUrl = getClass().getClassLoader().getResource("weather.fxml");  
     AnchorPane root = FXMLLoader.<AnchorPane>load(fxmlUrl);  
     Scene scene = new Scene(root);  
     primaryStage.setScene(scene);  
     primaryStage.setTitle("MyWeather");  
     primaryStage.centerOnScreen();  
     primaryStage.setResizable(false);  
     primaryStage.setOpacity(0.9);  
     primaryStage.show();  
   }  
     
 //  public static void main(String[] args) {launch(args);}  
     
   private void toggle(ObservableValue<? extends Toggle> observable,  
     Toggle oldValue, Toggle newValue) throws JSONException, ClassNotFoundException {  
       
       ToggleButton tBtn = (ToggleButton) newValue;  
       switch(tBtn.getText()){  
         case "Tunis":  
           cityID=2464470; // City IDs provided by OWM ( not WOEID )  
           break;  
         case "Hammamet":  
           cityID=2473744;  
           break;  
         case "Sousse":  
           cityID=2464915;  
           break;  
       }  
       initialize();      
   }  

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
 }  