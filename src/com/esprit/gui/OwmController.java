/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;


import com.wassalni.entites.WeatherModel;
 import java.net.URL;  
 import java.util.logging.Level;  
 import java.util.logging.Logger;  
 import javafx.application.Application;  
 import javafx.beans.value.ObservableValue;  
 import javafx.fxml.FXML;  
 import javafx.fxml.FXMLLoader;  
 import javafx.scene.Scene;  
 import javafx.scene.control.Button;  
 import javafx.scene.control.Label;  
 import javafx.scene.control.Toggle;  
 import javafx.scene.control.ToggleButton;  
 import javafx.scene.control.ToggleGroup;  
 import javafx.scene.image.ImageView;  
 import javafx.scene.layout.AnchorPane;  
 import javafx.stage.Stage;  

 import org.json.JSONException;  
   
 /**  
  *  
  * @author djordje gavrilovic  
  */  
 public class OwmController extends Application {  
     
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
     refreshBtn.setGraphic(new ImageView("/recherche.png"));  
     refreshBtn.setScaleX(0.8);  
     refreshBtn.setScaleY(0.8);  
     timeLbl.setText(new java.util.Date().toString());  
     cityTg.selectedToggleProperty().addListener((observable,  
       oldValue, newValue) -> {  
       try {  
         toggle(observable, oldValue, newValue);  
       } catch (JSONException ex) {  
       
       } catch (ClassNotFoundException ex) {  
             Logger.getLogger(OwmController.class.getName()).log(Level.SEVERE, null, ex);
         }  
     });  
   }  
     
//   @Override  
//   public void start(Stage primaryStage) throws Exception {      
//     URL fxmlUrl = getClass().getClassLoader().getResource("owm.fxml");  
//     AnchorPane root = FXMLLoader.<AnchorPane>load(fxmlUrl);  
//     Scene scene = new Scene(root);  
//     primaryStage.setScene(scene);  
//     primaryStage.setTitle("MyWeather");  
//     primaryStage.centerOnScreen();  
//     primaryStage.setResizable(false);  
//     primaryStage.setOpacity(0.9);  
//     primaryStage.show();  
//   }  
     
   //public static void main(String[] args) {launch(args);}  
     
   private void toggle(ObservableValue<? extends Toggle> observable,  
     Toggle oldValue, Toggle newValue) throws JSONException, ClassNotFoundException {  
       
       ToggleButton tBtn = (ToggleButton) newValue;  
       switch(tBtn.getText()){  
         case "Bajina Basta":  
           cityID=3204623; // City IDs provided by OWM ( not WOEID )  
           break;  
         case "Belgrade":  
           cityID=792680;  
           break;  
         case "Zrenjanin":  
           cityID=783814;  
           break;  
       }  
       initialize();      
   }  

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     
 }  

