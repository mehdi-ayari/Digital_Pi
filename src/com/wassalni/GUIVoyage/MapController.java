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
import com.teamdev.jxmaps.javafx.MapView;
import com.wassalni.entites.Voyage;
import com.wassalni.services.ServiceVoyage;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.*;
import java.nio.charset.Charset;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

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
                    MapOptions mapOptions = new MapOptions();
                    // Creating a map type control options object
                    MapTypeControlOptions controlOptions = new MapTypeControlOptions();
                    // Changing position of the map type control
                    controlOptions.setPosition(ControlPosition.TOP_RIGHT);
                    // Setting map type control options
                    mapOptions.setMapTypeControlOptions(controlOptions);
                    // Setting map options
                    map.setOptions(mapOptions);
                    // Setting initial zoom value
                    map.setZoom(12.0);
                    
                    Marker mark = new Marker(map);
                    Marker mark2 = new Marker(map);
                    
                    mark.setPosition(origin);
                    
                    map.setCenter(new LatLng(36.8992777,10.1874516));
                    
                    mark.setPosition(origin);

                    // Creating a geocode request
                    GeocoderRequest request = new GeocoderRequest();
                    // Setting address to the geocode request
                    request.setAddress(desti);
                    
                    

                    // Geocoding position by the entered address
                    mapView.getServices().getGeocoder().geocode(request, new GeocoderCallback(map) {
                        @Override
                        public void onComplete(GeocoderResult[] results, GeocoderStatus status) {
                            // Checking operation status
                                        if ((status == GeocoderStatus.OK) && (results.length > 0)) {
                                            try {
                                                // Getting the first result
                                                GeocoderResult result = results[0];
                                                // Getting a location of the result
                                                LatLng location = result.getGeometry().getLocation();
                                                // Setting the map center to result location
                                                map.setCenter(location);
                                                mark2.setPosition(location);
                                                
                                                
                                                
                                                //System.out.println(getDirections(origin, location).length());
                                                
                                             
                                                    JSONArray coordinat = getDirections(origin, location);
                                                    
                                                    
                                            
                                                    for (int i = 0; i < getDirections(origin, location).length(); i++) {
                                                    
                                                LatLng[] path = {new LatLng((double) getDirections(origin, location).getJSONArray(i).get(1),(double) getDirections(origin, location).getJSONArray(i).get(0)),
                                                                new LatLng((double) getDirections(origin, location).getJSONArray(i+1).get(1),(double) getDirections(origin, location).getJSONArray(i+1).get(0))};
                                                    
                                                // Creating a new polygon object
                                                Polygon polygon = new Polygon(map);
                                                // Initializing the polygon with the created path
                                                polygon.setPath(path);
                                                // Creating a polyline options object
                                                PolygonOptions options = new PolygonOptions();
                                                // Setting fill color value
                                                options.setFillColor("#FF0000");
                                                // Setting fill opacity value
                                                options.setFillOpacity(0.35);
                                                // Setting stroke color value
                                                options.setStrokeColor("#FF0000");
                                                // Setting stroke opacity value
                                                options.setStrokeOpacity(0.8);
                                                // Setting stroke weight value
                                                options.setStrokeWeight(2.0);
                                                // Applying options to the polygon
                                                polygon.setOptions(options);}
                                            } catch (IOException ex) {
                                            } catch (JSONException ex) {
                                                Logger.getLogger(MapController.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                
                            }
                        }
                    });
                    
                    
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
                    
                    try {
                        // Getting the first result
                        GeocoderResult result = results[0];
                        // Getting a location of the result
                        LatLng location = result.getGeometry().getLocation();
                        // Setting the map center to result location
                        map.setCenter(location);
                        mark.setPosition(location);
                        getDirections(origin, location);
                    } catch (IOException ex) {
                    }
                    
                }
            }
        });
        
        
    }


    public JSONArray getDirections(LatLng origin, LatLng destination) throws IOException {
        JSONArray coords = null;
        Double coord = null;
        List<Double> coordsi = null;
        try {
            JSONObject json = readJsonFromUrl("https://api.mapbox.com/directions/v5/mapbox/driving/"+origin.getLng()+"%2C"+origin.getLat()+"%3B"+destination.getLng()+"%2C"+destination.getLat()+"?alternatives=true&geometries=geojson&steps=true&access_token=pk.eyJ1IjoiamF3aGFyY2giLCJhIjoiY2s2dGVvOGlpMDB3NDNtcHVzcmxhdmR2YyJ9.VHALBLsdspgxm5eIuC270Q");
            //JSONObject jo=json.getJSONObject(json.length()-1);
            JSONObject routes = (JSONObject) json.getJSONArray("routes").get(0);
            JSONObject geo = routes.getJSONObject("geometry");
                        //System.out.println(geo.getJSONArray("coordinates")); 
            coords = geo.getJSONArray("coordinates");
            coord = (Double) coords.getJSONArray(0).get(0);
            //System.out.println(coord);

            
        } catch (JSONException e) {
        }
        
                                             

         return coords;
        
    }
    
    private static String readAll(Reader rd) throws IOException {
    StringBuilder sb = new StringBuilder();
    int cp;
    while ((cp = rd.read()) != -1) {
        sb.append((char) cp);
    }
    return sb.toString();
}
    
    public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
    InputStream is = new URL(url).openStream();
    try {
        BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
        String jsonText = readAll(rd);
        JSONObject jsonArray = new JSONObject(jsonText);
        return jsonArray;
    } finally {
        is.close();
    }
}
};

