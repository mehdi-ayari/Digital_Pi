
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.test;

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
import com.wassalni.entites.Reservation;
import com.wassalni.services.ReservationService;
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
    private Reservation Voy = new Reservation();
    private ReservationService R = new ReservationService();
    public ObservableList<Reservation> data = FXCollections.observableArrayList();
    public static float dist;
    //String desti=  Res.dest;    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
       
        // Creation of a JavaFX map view
        //final MapView mapView = new MapView();
        R.readAll();
        //Voy.getDistination();
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
                    
                    map.setCenter(origin);
                     
                    
                    System.out.println(ReservationController.dest);
                     
                    performGeocode(ReservationController.dest);
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
                    dist = (float) distance(origin.getLat(), origin.getLng(), location.getLat(), location.getLng(), 'K');
                    System.out.println(dist);
                    
                }
            }
        });
    
    }
    
    
    private double distance(double lat1, double lon1, double lat2, double lon2, char unit) {
      double theta = lon1 - lon2;
      double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
      dist = Math.acos(dist);
      dist = rad2deg(dist);
      dist = dist * 60 * 1.1515;
      if (unit == 'K') {
        dist = dist * 1.609344;
      } else if (unit == 'N') {
        dist = dist * 0.8684;
        }
      return (dist);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts decimal degrees to radians             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double deg2rad(double deg) {
      return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts radians to decimal degrees             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double rad2deg(double rad) {
      return (rad * 180.0 / Math.PI);
    }

//    System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, 'M') + " Miles\n");
//    System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, 'K') + " Kilometers\n");
//    System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, 'N') + " Nautical Miles\n");
};