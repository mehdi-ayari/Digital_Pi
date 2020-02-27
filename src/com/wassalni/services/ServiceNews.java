/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.services;


import com.wassalni.Iservices.INews;
import com.wassalni.entites.News;
import com.wassalni.utilits.DataBase;
import doryan.windowsnotificationapi.fr.Notification;
import java.awt.AWTException;
import java.awt.TrayIcon;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.net.MalformedURLException;

import java.sql.SQLException;
import java.util.List;
import java.sql.*;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author House
 */
public class ServiceNews implements INews<News> {
    
    public News findbyTitre(String title) {
        
        try {

            PreparedStatement pre = con.prepareStatement("Select * from news  WHERE titre =? ");
            pre.setString(1,title);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                  int id_news=rs.getInt(1);
               String titre=rs.getString("titre");
               String desc=rs.getString("desc");
               String comm=rs.getString("comm");
               String image=rs.getString("image");
               News n=new News(titre, desc, image);
               return n;
            }
        } catch (SQLException ex) {
            ex.getMessage();
        }

        return null;
    }

   

    private Connection con;
    private Statement ste;

    public ServiceNews() {
        con = DataBase.getInstance().getConnection();

    }
    
    @Override
    public void ajouter(News t) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `wassalni`.`news` (`titre`, `desc`, `image`) VALUES ('" + t.getTitre() + "', '" + t.getDesc() + "', '" + t.getImage() + "');";
        ste.executeUpdate(requeteInsert);   
        try {
            Notification.sendNotification("module News", "NEWS ADDED ",TrayIcon.MessageType.INFO);
        } catch (AWTException ex) {
            java.util.logging.Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            java.util.logging.Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void ajouter1(News n) throws SQLException
    {
    PreparedStatement pre=con.prepareStatement("INSERT INTO `wassalni`.`news` ( `titre`, `desc`,  `image`) VALUES ( ?, ?, ?);");
    pre.setString(1, n.getTitre());
    pre.setString(2, n.getDesc());
    pre.setString(3, n.getImage());
    pre.executeUpdate();
    }
            

    @Override
    public boolean delete(int id_news) throws SQLException {
        PreparedStatement pre=con.prepareStatement("DELETE FROM `wassalni`.`news` WHERE id_news=? ;");
                 pre.setInt(1, id_news);
                 if (pre.executeUpdate()!=0 )
                 {System.out.println ("NEWS Deleted");
            try {
                Notification.sendNotification("module News", "NEWS DELETED ",TrayIcon.MessageType.INFO);
            } catch (AWTException ex) {
                java.util.logging.Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                java.util.logging.Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
            }
                         return true ;
                         }
                 System.out.println(" News not found!!!");
                 return false ;
    }

       public void updateNews(News n) {
        try {
         
            PreparedStatement pre = con.prepareStatement("UPDATE news SET TITRE=?,DESC=?,IMAGE = ?  WHERE id_news=? ");
         
            pre.setString(1, n.getTitre());
            pre.setString(2, n.getDesc() );
            pre.setString(3, n.getImage());
            pre.setInt(4, n.getId_news());
           

            pre.executeUpdate();

        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public boolean updateimage(int id_news, String Image) throws SQLException, AWTException {
        PreparedStatement pre = con.prepareStatement("UPDATE `wassalni`.`news` SET IMAGE = ? WHERE id_news=? ;");
        pre.setString(1, Image);
        pre.setInt(2, id_news);
        if (pre.executeUpdate() != 0) {
            System.out.println("NEWS Updated");
            try {
                Notification.sendNotification("module News", "NEWS UPDATED ",TrayIcon.MessageType.INFO);
            } catch (MalformedURLException ex) {
                java.util.logging.Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        System.out.println("NEWS not found!!!");
        return false;
    }

      public boolean updatedesc(int id_news, String desc) throws SQLException {
        PreparedStatement pre = con.prepareStatement("UPDATE `wassalni`.`news` SET DESC = ? WHERE id_news=? ;");
        pre.setString(1, desc);
        pre.setInt(2, id_news);
        if (pre.executeUpdate() != 0) {
            System.out.println("NEWS Updated");
            try {
                Notification.sendNotification("module News", "NEWS UPDATED ",TrayIcon.MessageType.INFO);
            } catch (AWTException ex) {
                java.util.logging.Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                java.util.logging.Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        System.out.println("NEWS not found!!!");
        return false;
    }
       public boolean updatetitre(int id_news, String titre) throws SQLException {
        PreparedStatement pre = con.prepareStatement("UPDATE `wassalni`.`news` SET TITRE = ? WHERE id_news=? ;");
        pre.setString(1, titre);
        pre.setInt(2, id_news);
        if (pre.executeUpdate() != 0) {
            System.out.println("NEWS Updated");
            try {
                Notification.sendNotification("module News", "NEWS UPDATED ",TrayIcon.MessageType.INFO);
            } catch (AWTException ex) {
                java.util.logging.Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MalformedURLException ex) {
                java.util.logging.Logger.getLogger(ServiceNews.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        System.out.println("NEWS not found!!!");
        return false;
    }

    @Override
    public List<News> readAll() throws SQLException {
    List<News> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from news");
     while (rs.next()) {                
               int id_news=rs.getInt(1);
               String titre=rs.getString("titre");
               String desc=rs.getString("desc");
               String image=rs.getString("image");
               News n=new News(id_news,titre, desc, image);
     arr.add(n);
     }
    return arr;
    }
     @Override
    public boolean update(News t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
      @Override
    public News readID(News ns) throws SQLException {
    //News arr=new News();
    ste=con.createStatement();
    News n=new News();
    ResultSet rs=ste.executeQuery("select * from news where id_news ='"+ns.getId_news()+"'");
     while (rs.next()) {                
               int id_news=rs.getInt(1);
             
               n.setTitre(rs.getString("titre"));
               n.setDesc(rs.getString("desc"));
               n.setImage( rs.getString("image"));
               System.out.println(rs.getString("desc")+"ghig");
     
     }
    return n;
    }
   
}

