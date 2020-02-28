/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.wassalni.utilits.DataBase;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javax.activation.DataSource;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ChartController implements Initializable {

    @FXML
    private PieChart piechart;
    Connection con;
    ResultSet res;
    @FXML
    private Button bBack;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
piechart.setLabelLineLength(10);
        piechart.setLegendSide(Side.LEFT);

        String req="Select text,count(*) from commentaire GROUP BY text";  
         try {
             con = DataBase.getInstance().getConnection();
             res = con.createStatement().executeQuery(req);
            while (res.next()){
                  PieChart.Data slice = new PieChart.Data(res.getString(1),res.getInt(2));
                  piechart.getData().add(slice);                 
            }       
            


            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("AddNews.fxml"));
        Parent root = loader.load();
        AddNewsController spc = loader.getController();
       
        bBack.getScene().setRoot(root); 
    }
    
}
