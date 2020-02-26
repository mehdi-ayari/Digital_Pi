/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.wassalni.entites.Comment;
import com.wassalni.entites.News;
import com.wassalni.services.ServiceComment;
import com.wassalni.services.ServiceNews;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ConsulterController implements Initializable {

    public ObservableList<News> data = FXCollections.observableArrayList();
    private int id;
    @FXML
    private Button cBack;
    private TextArea tfComment;
    @FXML
    private TextArea tfcomment;
    @FXML
    private Button bComment;
    @FXML
    private ImageView image;
    @FXML
    private TextArea descrip;
    @FXML
    private Label titre;
    @FXML
    private TextArea affiche;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    
    } 
    
    public void setContent(int id)
    {
        
         News n = new News();
        n.setId_news(id);
        System.out.println(id);
        ServiceNews sn= new ServiceNews();
        try {
            n= sn.readID(n);
            image.setImage(new Image(n.getImage()));
            titre.setText(n.getTitre());
            descrip.setText(n.getDesc());
        } catch (SQLException ex) {
            Logger.getLogger(ConsulterController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cback(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("AddNews.fxml"));
        Parent root = loader.load();
        AddNewsController spc = loader.getController();
        cBack.getScene().setRoot(root);   
    }
    
   public void setid(int id)
   { 
       this.id=id;
   }

    @FXML
    private void bcomment(ActionEvent event) throws SQLException {
        
        String comment = tfcomment.getText();
        ServiceComment sc = new ServiceComment();
        Comment c = new Comment(comment);
        sc.ajouter(c);

       // tfComment.setText(comment);
      //  tfComment.appendText(comment + "\n");
     // sc.readAll();
      
            
    }
    
    
}
