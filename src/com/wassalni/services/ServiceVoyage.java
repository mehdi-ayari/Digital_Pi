/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.services;

//import java.util.logging.Level;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.wassalni.Iservices.IVoyage;
import com.wassalni.entites.Voyage;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.sql.*;
import com.wassalni.utilits.DataBase;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

//import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class ServiceVoyage implements IVoyage{
    
    public Voyage findbyTitre(int reservation_id_res) {
        
        try {

            PreparedStatement pre = con.prepareStatement("Select * from Voyage  WHERE reservation_id_res =? ");
            pre.setInt(1, reservation_id_res);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
               int id_Voyage=rs.getInt(1);
               float distance=rs.getFloat("distance");
               Timestamp date_voyage=rs.getTimestamp("date_voyage");
               Voyage n=new Voyage( distance, reservation_id_res);
               return n;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return null;
    }

    String tri = " ORDER BY id_voyage " ;
    String ordre = " ASC" ;
    public void ordreASC () {
        ordre = " ASC" ; 
    }
     public void ordreDESC () {
        ordre = " DESC" ; 
    }
    

     public void triById() { 
        tri = " ORDER BY id_voyage ";
        }

    private Connection con;
    private Statement ste;

    public ServiceVoyage() {
        con = DataBase.getInstance().getConnection();

    }
   
   
    @Override
    public void ajouter(Voyage v) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `wassalni`.`voyage` (`distance`, `date_voyage`, `reservation_id_res`) VALUES ('" + v.getDistance()+ "', CURRENT_TIMESTAMP(), '" + v.getReservation_id_res()+ "');";
        ste.executeUpdate(requeteInsert);   
    }
            

    @Override
    public boolean delete(int id_news) throws SQLException {
        PreparedStatement pre=con.prepareStatement("DELETE FROM `wassalni`.`voyage` WHERE id_news=? ;");
                 pre.setInt(1, id_news);
                 if (pre.executeUpdate()!=0 )
                 {System.out.println ("Voyage Deleted");
                         return true ;
                         }
                 System.out.println(" Voyage not found!!!");
                 return false ;
    }

    
    @Override
    public List<Voyage> readAll() throws SQLException {
    List<Voyage> Voy=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select id_voyage , distance , date_voyage , reservation_id_res , destination from voyage v inner join reservation r where reservation_id_res = id_res"+ tri + ordre);
     while (rs.next()) {                
               int id_voyage=rs.getInt(1);
               float distance=rs.getFloat("distance");
               Timestamp date_voyage=rs.getTimestamp("date_voyage");
               int reservation_id_res=rs.getInt("reservation_id_res");
               String destination=rs.getString("destination");
               Voyage n=new Voyage(id_voyage, distance, date_voyage, reservation_id_res,destination);
     Voy.add(n);
     }
    return Voy;
    }
    
  /*      public List<Voyage> readByClient( ) throws SQLException {
    List<Voyage> Voy=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select id_voyage , distance , date_voyage , reservation_id_res , destination from voyage v inner join reservation r where user_id_client = "+ SignUpController.UserID + tri + ordre);
     while (rs.next()) {                
               int id_voyage=rs.getInt(1);
               float distance=rs.getFloat("distance");
               Timestamp date_voyage=rs.getTimestamp("date_voyage");
               int reservation_id_res=rs.getInt("reservation_id_res");
               String destination=rs.getString("destination");
               Voyage n=new Voyage(id_voyage, distance, date_voyage, reservation_id_res,destination);
     Voy.add(n);
     }
    return Voy;
    }*/
   
    public void pdf() throws FileNotFoundException, DocumentException
    {
        try {
            String file_name ="C:\\Users\\CHOUCHANE MD\\Desktop\\Jawhar\\Jawhar.pdf";
            Document document = new Document();
            //file_name.setReadable(true,false);
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            document.open();
            PreparedStatement pt = con.prepareStatement("select * from wassalni.voyage");
            ResultSet rs = pt.executeQuery();
            
            while (rs.next()) { 
                Paragraph para=new Paragraph("Voyage [ id_Voyage: " +rs.getInt(1) + " Distance : " + rs.getFloat(2) + " Date_Voyage: " + rs.getTimestamp(3)+" id_res: " + rs.getInt(4)+"]");
                //System.out.println("garage [ id_garage: " +rs.getInt(1) + " name : " + rs.getString(2) + " Address: " + rs.getString(3)+" id_service: " + rs.getInt(4)+"]");
                document.add(para);
                document.add(new Paragraph(" "));
            }
            document.close();
        } catch (SQLException ex) {
            Logger.getLogger(Voyage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Voyage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Voyage.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
    
   
}