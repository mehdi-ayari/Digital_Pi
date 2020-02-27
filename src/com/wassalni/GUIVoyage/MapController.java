/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.GUIVoyage;

import com.teamdev.jxmaps.*;
import com.teamdev.jxmaps.ControlPosition;
import com.teamdev.jxmaps.LatLng;
import com.teamdev.jxmaps.Map;
import com.teamdev.jxmaps.MapOptions;
import com.teamdev.jxmaps.MapReadyHandler;
import com.teamdev.jxmaps.MapStatus;
import com.teamdev.jxmaps.MapTypeControlOptions;
import com.teamdev.jxmaps.examples.DirectionsExample;
import com.teamdev.jxmaps.javafx.MapView;
import com.wassalni.entites.Voyage;
import com.wassalni.services.ServiceVoyage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.print.attribute.standard.Destination;
import javax.swing.JOptionPane;

/**
 * Represents FXML control with MapViewer instance.
 */
public class MapController implements Initializable {
    @FXML
    private MapView mapView;
    private LatLng origin = new LatLng(36.8279141,10.2039551);
    private Voyage Voy = new Voyage();
    private ServiceVoyage V = new ServiceVoyage();
    public ObservableList<Voyage> data = FXCollections.observableArrayList();
    String desti=  VoyageController.dest;
    LatLng location = new LatLng(36.8992777,10.1874516);
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
       
        try {
            // Creation of a JavaFX map view
            //final MapView mapView = new MapView();
            V.readAll();
        } catch (SQLException ex) {
        }
        Voy.getDistination();
        // Setting of a ready handler to MapView object. onMapReady will be called when map initialization is done and
        // the map object is ready to use. Current implementation of onMapReady customizes the map object.
        mapView.setOnMapReadyHandler(new MapReadyHandler() {
            @Override
            public void onMapReady(MapStatus status) {
                // Check if the map is loaded correctly
                if (status == MapStatus.MAP_STATUS_OK) {
                    // Getting the associated map object
                    final Map map = mapView.getMap();
                    // Creating a map options object
                    MapOptions options = new MapOptions();
                    // Creating a map type control options object
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions();
                    // Changing position of the map type control
                    controlOptions.setPosition(ControlPosition.TOP_RIGHT);
                    // Setting map type control options
                    options.setMapTypeControlOptions(controlOptions);
                    // Setting map options
                    map.setOptions(options);
                    // Setting initial zoom value
                    map.setZoom(12.0);
                    
                    Marker mark = new Marker(map);
                    
                    mark.setPosition(origin);
                    
                    map.setCenter(new LatLng(36.8992777,10.1874516));
                     
                     
                    performGeocode(desti);
                }
            }
        });
    }
    private void performGeocode(String text) {
        // Getting the associated map object
        Map map = mapView.getMap();
        Marker mark = new Marker(map);
        // Creating a geocode request
        GeocoderRequest request = new GeocoderRequest();
        // Setting address to the geocode request
        request.setAddress(text);
        
        // Geocoding position by the entered address
        mapView.getServices().getGeocoder().geocode(request, new GeocoderCallback(map) {
            @Override
            public void onComplete(GeocoderResult[] results, GeocoderStatus status) {
                // Checking operation status
                if ((status == GeocoderStatus.OK) && (results.length > 0)) {
                    // Getting the first result
                    GeocoderResult result = results[0];
                    // Getting a location of the result
                    LatLng location = result.getGeometry().getLocation();
                    // Setting the map center to result location
                    map.setCenter(location);
                    mark.setPosition(location);
                }
            }
        });
    }
};

