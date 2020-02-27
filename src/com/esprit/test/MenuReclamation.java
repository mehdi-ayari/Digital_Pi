/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

import com.itextpdf.text.DocumentException;
import com.wassalni.entites.Reclamation;
import com.wassalni.services.ReclamationService;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author User
 */
public class MenuReclamation implements Initializable {
    List<Reclamation> st = new ArrayList<>();
        
    @FXML
    private TableView<Reclamation> table;
          private String countrec;

    private final ObservableList<Reclamation> data = FXCollections.observableArrayList();
    ObservableList list = FXCollections.observableArrayList();

    @FXML
    private TableColumn<Reclamation, String> tftitre;
    @FXML
    private Button details;
    @FXML
    private Button tfadd;
    @FXML
    private Button tfmodif;
    @FXML
    private Button contactus1;
    public static Reclamation Recl1;
    @FXML
    private TableColumn<Reclamation, String> tfdate;
    @FXML
    private Label tfcount;//bdina
    
  
    @FXML
    private TextField rechnom;
    @FXML
    private Button PDF;
Reclamation recSel = new Reclamation();
ReclamationService recService = new ReclamationService();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        LoadData();
//   ch.getSelectionModel().selectLast();
           ReclamationService sp = new ReclamationService();
        try{
            st=sp.readAll();
            data.addAll(st);
            tftitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
            this.tfdate.setCellValueFactory(new PropertyValueFactory<>("datee"));


            
          
            
            table.setItems(data);
            
        } catch (SQLException ex) {
            Logger.getLogger(MenuReclamation.class.getName()).log(Level.SEVERE, null, ex);
        }
        
           try {
            count();
        } catch (SQLException ex) {
            Logger.getLogger(ModifierReclamationController.class.getName()).log(Level.SEVERE, null, ex);
        }
//           rechdate.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                ReclamationService recService = new ReclamationService();
//          try{
//                LocalDate date = dater.getValue();
//                recService.afficherByDate(date.toString());}
//          catch(Exception ex){
//              System.out.println("erreur");}
//            }
//        });
     

  table.setOnMouseClicked(event->{
              recSel=table.getItems().get(table.getSelectionModel().getSelectedIndex());
              //int id =recService.getId();
               
               PDF.setOnAction(new EventHandler<ActionEvent>() {
                  @Override
                  public void handle(ActionEvent event) {

                      try {
                          sp.pdf(recSel.getId());
                      } catch (FileNotFoundException ex) {
                          Logger.getLogger(MenuReclamation.class.getName()).log(Level.SEVERE, null, ex);
                      } catch (DocumentException ex) {
                          Logger.getLogger(MenuReclamation.class.getName()).log(Level.SEVERE, null, ex);
                      }
 }
              }
               
               );
              
               });
        } 
// private void LoadData(){ 
//        list.removeAll();
//        String a = "titre";
//        String b = "description";
//
//        
//        list.addAll(a,b);
//        ch.getItems().addAll(list);// TODO
//    }    
    
     private void count() throws SQLException{
        
       ReclamationService sp = new ReclamationService();

        countrec= sp.CountReclamation();

        
        tfcount.setText(String.valueOf(countrec));
        }

    @FXML
    private void showdetails(ActionEvent event) throws IOException {
           Recl1 = table.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficheDetailsReclamations.fxml"));
        Parent root;

        root = loader.load();
        details.getScene().setRoot(root);
    }

    @FXML
    private void SupprimerReclamation(ActionEvent event) throws SQLException {
             ReclamationService ms = new ReclamationService();
        ObservableList<Reclamation> ll, ttmission;//
        ttmission = table.getItems();
        // ta3tina les lignes selectionnés 
        ll = table.getSelectionModel().getSelectedItems();

        for (Reclamation m : ll) {
            ttmission.remove(m);
            ms.SupprimerReclamation(m.getId());
        }
        JOptionPane.showMessageDialog(null, "supprimer");
    }

    @FXML
    private void roadToajout(ActionEvent event) throws IOException {
        Parent reclam = FXMLLoader.load(getClass().getResource("AjouterReclamation.fxml"));
        Scene reclamV= new Scene(reclam);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();//thabtha
        window.setScene(reclamV);
        window.show();
    }

    @FXML
    private void GoModif(ActionEvent event) throws IOException {
                        Recl1 = table.getSelectionModel().getSelectedItem();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifierReclamation.fxml"));
        Parent root;

        root = loader.load();
        details.getScene().setRoot(root);}


    @FXML
    private void GoToAContactus1(ActionEvent event) {
    }

//    @FXML
//    private void recherche(MouseEvent event) {
//       
//         if ( ch.getSelectionModel().getSelectedItem() == "reference"){
//                              ReclamationService ms =  new ReclamationService();
//                             
//             ArrayList filteredData = (ArrayList) ms.afficherByTitre(rech.getText());
//               ObservableList obs =FXCollections.observableArrayList(filteredData);
//               table.setItems(obs);
//                 tftitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
//                
//              
//                
//      }
//
//      if ( ch.getSelectionModel().getSelectedItem() == "client_name"){
//                             ReclamationService   ms =  new ReclamationService();
//               ArrayList filteredData = (ArrayList) ms.afficherBydesc(rech.getText());
//             ObservableList obs =FXCollections.observableArrayList(filteredData);
//               table.setItems(obs);
//                 tftitre.setCellValueFactory(new PropertyValueFactory<>("reference"));
//                   
//               
//    }
//    }
        
  

//    @FXML
//    private void recherche(MouseEvent event) {
//    }
//
//    private void triebydate(MouseEvent event) {
//         String a = dater.getValue().toString();
// ReclamationService   ms =  new ReclamationService();
//               ArrayList listee = (ArrayList) ms.afficherByDate(a);
//               ObservableList obs =FXCollections.observableArrayList(listee);
//                 table.setItems(obs);
//                 tftitre.setCellValueFactory(new PropertyValueFactory<>("titre"));
//                tfdate.setCellValueFactory(new PropertyValueFactory<>("date_reclamation")); 
//    }
        
    @FXML
        public void smartsearchPrenom(){ 
           FilteredList<Reclamation> filteredData2 = new FilteredList<>(data, b -> true);
       // tbadél l predicate te3 l filtre selon tabdil l filtre
    rechnom.textProperty().addListener((observable, oldValue, newValue) -> {
filteredData2.setPredicate(affdetails -> {
	// ken l filtre (searchbox) feragh n'affichi kol chay			
	if (newValue == null || newValue.isEmpty()) {
					return true;
				}
                      // n9arén l predicate beli éna ktébtou selon date w etat
		String lowerCaseFilter = newValue.toLowerCase();
	if (affdetails.getTitre().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; 
				}
				     else  
				    	 return false; 
			});
		});
        		// n7ot FilteredList f SortedList. 
		SortedList<Reclamation> sortedData = new SortedList<>(filteredData2);
		
		// n9arén e sortedlist b tableview
		
		//n'ajouti tawa sortedlist l héya resultat te3 l filtre f tableview mte3i
		table.setItems(sortedData);
        
    }
    }
    

