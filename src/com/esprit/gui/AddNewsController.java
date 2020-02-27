/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;



import com.wassalni.entites.News;
import com.wassalni.services.ServiceNews;
import com.wassalni.utilits.ControleSaisie;
import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;


/**
 * FXML Controller class
 *
 * @author House
 */
public class AddNewsController implements Initializable {
    
  /* File f  = new File("C:\\Users\\ASUS\\Documents\\NetBeansProjects\\wassalni\\src\\com\\esprit\\gui\\img\\interdit.png");
   Image image2 = new Image(f.toURI().toString()); */
   ServiceNews sn = new ServiceNews();
   private int id;
    @FXML
    private TextField tfImage;
    @FXML
    private Button bValider;
    @FXML
    private TextField tfTitre;
    @FXML
    private TextField tfDesc;
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
    private Button bBack;
    @FXML
    private ImageView pdp;
    @FXML
    private Button bConsulter;
    private Button bMail;
    @FXML
    private Button bStat;
    @FXML
    private Label erreurtitre;
    public static News myNews;
    
    boolean titreok=true;

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
    private void ajouter(ActionEvent event) throws SQLException {


     // try {
        ControleSaisie.effacerControleSaisie(erreurtitre);
        titreok = ControleSaisie.controleTextFieldVide(tfTitre, "ECRIRE....", erreurtitre);
            String titre = tfTitre.getText();
            String desc = tfDesc.getText();
            String image = tfImage.getText();
            ServiceNews sn = new ServiceNews();
            News n = new News(titre, desc,image );
            sn.ajouter(n) ;          
             Alert succDeleteBookAlert = new Alert(Alert.AlertType.INFORMATION);
            succDeleteBookAlert.setTitle("Delete Blog");
            succDeleteBookAlert.setHeaderText("Results:");
            succDeleteBookAlert.setContentText("ADDED successfully!");
            succDeleteBookAlert.showAndWait();
        
    data.clear();
    data.addAll(sn.readAll());
    

   

  
        
}
     @FXML
    private void upload(ActionEvent event) {
        
        FileChooser fc = new FileChooser();
        String imageFile = "";
        File f = fc.showOpenDialog(null);

        if (f != null) {
            imageFile = f.toURI().toString();
            tfImage.setText(imageFile);
        }
    }



    @FXML
    private void select(ActionEvent event) {
         News n= tabviewnews.getSelectionModel().getSelectedItem();
         myNews = n;
        tfTitre.setText(n.getTitre());
        tfDesc.setText(n.getDesc());
        tfImage.setText(n.getImage()); 
        id= n.getId_news();
        System.out.println(n.getId_news());
        
    }
    @FXML
    private void delete(ActionEvent event) throws SQLException {
         if (tabviewnews.getSelectionModel().getSelectedItem() != null) {
            Alert deleteBookAlert = new Alert(Alert.AlertType.CONFIRMATION);
            deleteBookAlert.setTitle("Delete ");
            deleteBookAlert.setHeaderText(null);
            deleteBookAlert.setContentText("Are you sure  you want to delete ?");
            Optional<ButtonType> optionDeleteBookAlert = deleteBookAlert.showAndWait();
            if (optionDeleteBookAlert.get() == ButtonType.OK) {

                News n = tabviewnews.getSelectionModel().getSelectedItem();
                sn.delete(n.getId_news());
                data.clear();
                data.addAll(sn.readAll());

                //Alert Delete Blog :
                Alert succDeleteBookAlert = new Alert(Alert.AlertType.INFORMATION);
                succDeleteBookAlert.setTitle("Delete ");
                succDeleteBookAlert.setHeaderText("Results:");
                succDeleteBookAlert.setContentText("NEWS deleted successfully!");

                succDeleteBookAlert.showAndWait();
            } else if (optionDeleteBookAlert.get() == ButtonType.CANCEL) {

            }

        } else {

            //Alert Select BOOK :
            Alert selectBookAlert = new Alert(Alert.AlertType.WARNING);
            selectBookAlert.setTitle("Select a NEWS");
            selectBookAlert.setHeaderText(null);
            selectBookAlert.setContentText("You need to select a NEWS first!");
            selectBookAlert.showAndWait();
            //Alert Select Book !

        }
    }

    @FXML
    private void updaate(ActionEvent event) throws SQLException, AWTException {
        
        if (tabviewnews.getSelectionModel().getSelectedItem() != null) {

            News n = tabviewnews.getSelectionModel().getSelectedItem();

            //sn.update(n);
            sn.updatetitre(n.getId_news(), n.getTitre());
            sn.updateimage(n.getId_news(), n.getImage());
            sn.updatedesc(n.getId_news(), n.getDesc());
            
            Alert BookAlert = new Alert(Alert.AlertType.INFORMATION);
            BookAlert.setTitle("edit");
            BookAlert.setHeaderText(null);
            BookAlert.setContentText("The NEWS was successfully UPDATED");
            BookAlert.showAndWait();

        } else {
            //Alert Select BOOK :
            Alert selectBookAlert = new Alert(Alert.AlertType.WARNING);
            selectBookAlert.setTitle("Select a NEWS");
            selectBookAlert.setHeaderText(null);
            selectBookAlert.setContentText("You need to select a NEWS first!");
            selectBookAlert.showAndWait();
            //Alert Select Book !
        }
    }

    @FXML
    private void changeDescCellEvent(CellEditEvent edittedCell) {
        News newsSelected = tabviewnews.getSelectionModel().getSelectedItem();
        newsSelected.setTitre(edittedCell.getNewValue().toString());
    }

    @FXML
    private void changeDescrCellEvent(CellEditEvent edittedCell) {
        News newsSelected = tabviewnews.getSelectionModel().getSelectedItem();
        newsSelected.setDesc(edittedCell.getNewValue().toString());
    }

   @FXML
    private void changeImgCellEvent(CellEditEvent edittedCell) {
        News newsSelected = tabviewnews.getSelectionModel().getSelectedItem();
        newsSelected.setImage(edittedCell.getNewValue().toString());
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
    private void ShowPhoto(MouseEvent event) {
        
        News n = tabviewnews.getSelectionModel().getSelectedItem();
        pdp.setImage(new Image(n.getImage()));
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
    private void stat(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("chart.fxml"));
        Parent root = loader.load();
        ChartController spc = loader.getController();
       
        bStat.getScene().setRoot(root);   
    }

 
    
    
    


}
