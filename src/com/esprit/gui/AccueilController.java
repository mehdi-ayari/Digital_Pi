/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.wassalni.entites.News;
import com.wassalni.services.ServiceNews;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AccueilController implements Initializable {

    
     ServiceNews sn = new ServiceNews();
   private int id;
 
     public ObservableList<News> data = FXCollections.observableArrayList();
    @FXML
    private TableView<News> tabviewnews;
    @FXML
    private TableColumn<News, String> resTitre;
    @FXML
    private TableColumn<News, String>resDesc;
   @FXML
    private TableColumn <News, String> resImage;
    @FXML
    private TextField tfsearch;

    @FXML
    private ImageView pdp;
    @FXML
    private Button bConsulter;
    @FXML
    private Button bweather;
    
    

    public TableColumn<News, String> getResTitre() {
        return resTitre;
    }

    public void setResTitre(TableColumn<News, String> resTitre) {
        this.resTitre = resTitre;
    }

    public TableColumn<News, String> getResDesc() {
        return resDesc;
    }

    public void setResDesc(TableColumn<News, String> resDesc) {
        this.resDesc = resDesc;
    }

    public TableColumn<News, String> getResImage() {
        return resImage;
    }

    public void setResImage(TableColumn<News, String> resImage) {
        this.resImage = resImage;
    }
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             
        try {
            data.addAll(sn.readAll());
           
        } catch (SQLException ex) {
            Logger.getLogger(AddNewsController.class.getName()).log(Level.SEVERE, null, ex);
        }
       

        this.resTitre.setCellValueFactory(new PropertyValueFactory<>("titre"));

        this.resDesc.setCellValueFactory(new PropertyValueFactory<>("desc"));

    //    this.resImage.setCellValueFactory(new PropertyValueFactory<>("image"));

        this.tabviewnews.setItems(data);
        this.tabviewnews.setEditable(true);
         this.resTitre.setCellFactory(TextFieldTableCell.forTableColumn());
         this.resDesc.setCellFactory(TextFieldTableCell.forTableColumn());
         this.resImage.setCellFactory(TextFieldTableCell.forTableColumn());
        // TODO
    
       
    }    

    @FXML
    private void ShowPhoto(MouseEvent event) {
         News n = tabviewnews.getSelectionModel().getSelectedItem();
        pdp.setImage(new Image(n.getImage()));
    }

       @FXML
    private void filter(ActionEvent event) throws SQLException {
         data.clear();
        data.addAll(sn.readAll().stream().filter((art)
                -> art.getTitre().toLowerCase().contains(tfsearch.getText().toLowerCase())
                || art.getDesc().toLowerCase().contains(tfsearch.getText().toLowerCase())
                || art.getImage().toLowerCase().contains(tfsearch.getText().toLowerCase())
                ).collect(Collectors.toList()));
    }

    @FXML
    private void consulter(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("consulter.fxml"));
        Parent root = loader.load();
        ConsulterController spc = loader.getController();
        spc.setid(id);
        spc.setContent(id);
        bConsulter.getScene().setRoot(root);   
    }

    @FXML
    private void weather(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("weather.fxml"));
        Parent root = loader.load();
        WeatherController spc = loader.getController();
      
        bweather.getScene().setRoot(root);   
         
    }

    
}