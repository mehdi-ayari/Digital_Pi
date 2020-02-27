/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author jawed
 */
public class PannelAdminController implements Initializable {

    @FXML
    private AnchorPane container_Admin;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    public AnchorPane getContainer_admin() {
        return container_Admin;
    }

    public void setContainer_admin(AnchorPane container_Admin) {
        this.container_Admin = container_Admin;
    }
     @FXML
    private void profil(ActionEvent event) throws IOException {
        
        
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/wassalni/gui/signIn.fxml"));
            Parent root = loader.load();       
            container_Admin.getChildren().setAll(root);
    }
    
}
