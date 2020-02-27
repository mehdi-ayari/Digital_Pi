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
import com.wassalni.utilits.ControleSaisie;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import com.wassalni.utilits.ControleSaisie;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class ConsulterController implements Initializable {

    public static int idn;
    public ObservableList<News> data = FXCollections.observableArrayList();
    public ObservableList<Comment> datac = FXCollections.observableArrayList();
    private int id;
    @FXML
    private Button cBack;
    private TextArea tfComment;
    @FXML
    private TextField tfcomment;
    @FXML
    private Button bComment;
    @FXML
    private ImageView image;
    @FXML
    private TextArea descrip;
    @FXML
    private Label titre;
    private TextArea resComment;
    @FXML
    private PieChart piechart;
    @FXML
    private TableView<Comment> tabcomment;
    // @FXML
    //   private TableColumn<User, String> resnom;
    @FXML
    private TableColumn<Comment, String> rescomment;
    @FXML
    private TableColumn<?, ?> resnom;
    @FXML
    private Button meteo;
    @FXML
    private Label erreurcomment;
    boolean commentok=true;

    public void setRescomment(TableColumn<Comment, String> rescomment) {
        this.rescomment = rescomment;
    }

    public void setResComment(TextArea resComment) {
        this.resComment = resComment;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ServiceComment sc = new ServiceComment();
        try {
            datac.addAll(sc.getComments(AddNewsController.myNews));
            this.rescomment.setCellValueFactory(new PropertyValueFactory<>("text"));
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        this.tabcomment.setItems(datac);
        this.tabcomment.setEditable(true);
        this.rescomment.setCellFactory(TextFieldTableCell.forTableColumn());
        
    }

    public void setContent(int id) {

        News n = new News();
        idn = id;
        n.setId_news(id);
        System.out.println(id);
        ServiceNews sn = new ServiceNews();
        try {
            n = sn.readID(n);
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

    public void setid(int id) {
        this.id = id;
    }

    @FXML
    private void bcomment(ActionEvent event) throws SQLException {

        String comment = tfcomment.getText();
        ServiceComment sc = new ServiceComment();
        Comment c = new Comment(comment);
        ControleSaisie.effacerControleSaisie(erreurcomment);
        commentok = ControleSaisie.controleTextFieldVide(tfcomment, "COMMENT MISSED..", erreurcomment);
        //commentok = ControleSaisie.controleTextFieldOnlyLetters(tfcomment, "", erreurcomment);
        sc.ajouter(c);
         datac.clear();
    datac.addAll(sc.getComments(AddNewsController.myNews));
            this.rescomment.setCellValueFactory(new PropertyValueFactory<>("text"));
        // tfComment.setText(comment);
        //  tfComment.appendText(comment + "\n");
        // sc.readAll();
    }

    @FXML
    private void meteoac(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("owm.fxml"));
        Parent root = loader.load();
        OwmController spc = loader.getController();
      
        meteo.getScene().setRoot(root);   
    }
    

}
