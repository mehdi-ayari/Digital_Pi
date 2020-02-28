/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.gui;

import com.wassalni.entites.User;
import com.wassalni.services.Password;
import com.wassalni.services.Role;
import com.wassalni.services.UserService;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author jawed
 */
public class SignInController implements Initializable {
    @FXML
    private TextField Email;
    @FXML
    private PasswordField mdp;
    @FXML
    private Button connecter;
    public static int userIden = 0;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void connecter(ActionEvent event) throws IOException {

        try {

            User u = new User();
            UserService ser = new UserService();
            u = ser.connecter(Email.getText());
            Password md = new Password();
            Boolean mdpCrypte = md.checkPassword(mdp.getText(), u.getMotDePasse());

            System.out.println(mdpCrypte);
            userIden = u.getId();
            System.out.println("userIdetifiant" + userIden);
             if (mdpCrypte == true) {

                System.out.println("authentification reussite");

                if (u.getRole().equals(Role.getChauffeur())){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/gui/PannelChauffeur.fxml"));
                    Parent root = loader.load();
                    mdp.getScene().setRoot(root);
                }else if(u.getRole().equals(Role.getClient())){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/gui/PannelClient.fxml"));
                    Parent root = loader.load();
                    mdp.getScene().setRoot(root);
                }else if(u.getRole().equals(Role.getAdministrateur())){
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/gui/pannelAdmin.fxml"));
                    Parent root = loader.load();
                    mdp.getScene().setRoot(root);}
             }

           
            }
        catch (SQLException ex) {

        }}
    
   // @FXML
    public void changeScreenButtonPushed(ActionEvent event) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("SelectRole.fxml"));
        Scene tableVeiwScene = new Scene(tableViewParent);
        
        // this gets the stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(tableVeiwScene);
        window.show();
    }
}
