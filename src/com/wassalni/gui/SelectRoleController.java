/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.gui;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author jawed
 */
public class SelectRoleController implements Initializable {

    @FXML
    private JFXButton drive;
    @FXML
    private JFXButton ride;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void goChauffeur(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/wassalni/gui/SignUPChauffeur.fxml"));
            drive.getScene().setRoot(root);
    }
    @FXML
    private void goClient(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/com/wassalni/gui/SignUpClient.fxml"));
            ride.getScene().setRoot(root);
    }
}
