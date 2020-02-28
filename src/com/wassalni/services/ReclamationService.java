/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.services;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.wassalni.entites.Reclamation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.wassalni.utilits.DataBase;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 *
 * @author user
 */
public class ReclamationService  {
    
    
    private Connection con =DataBase.getInstance().getConnection();
    private Statement ste;
        private int idReclamation;

    
    public ReclamationService (){
      try {  
        ste = con.createStatement();
    }
    catch (SQLException ex){
    System.out.println(ex);
}
}

    
    
     public void ajouter(Reclamation R) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "INSERT INTO `reclamation` ( `titre`, `description`, `user_id`) VALUES ( '" + R.getTitre() + "', '" + R.getDescription() + "', '" + R.getuser_id() + "');";
        ste.executeUpdate(requeteInsert);
    }
     
        public void ModifierReclamation(Reclamation R) throws SQLException {
        ste = con.createStatement();
        String requeteInsert = "UPDATE reclamation SET titre ='"+R.getTitre()+"',description='"+R.getDescription()+"' WHERE reclamation.id_reclamation='"+R.getId()+"';";
        ste.executeUpdate(requeteInsert);
    }
        
           public void SupprimerReclamation(int id) throws SQLException {
      String requete = "DELETE FROM reclamation WHERE reclamation.id_reclamation =" + id;
        ste.executeUpdate(requete);
        System.out.println("elment supprimmé");
    }
                   public List<Reclamation> AfficherReclamation(Reclamation R) throws SQLException {
       List<Reclamation> arr=new ArrayList<>();
    ste=con.createStatement();
    ResultSet rs=ste.executeQuery("select * from reclamation");
     while (rs.next()) {                
               int id=rs.getInt("id");
               String titre=rs.getString("titre");
               String prenom=rs.getString("description");
               
               Reclamation p=new Reclamation(id, titre, prenom);
     arr.add(p);
     }
    return arr;
    }
                      public List<Reclamation> readAll() throws SQLException {
        List<Reclamation> list = new ArrayList<>();
        ResultSet res = ste.executeQuery("select * from reclamation");
        Reclamation ann = null;
        while (res.next()) {
            ann = new Reclamation(res.getInt(1),  res.getString(2), res.getString(3),res.getString(4));
            list.add(ann);
        }
        return list;
    }
                          public List<Reclamation> Get_Reclamation_by_Id(int id) throws SQLException {
        ResultSet res = null;
        List<Reclamation> list = new ArrayList<>();
        String resq = "select id_reclamation,titre,description from reclamation where id_reclamation ='" + id + "'";
        PreparedStatement pstmt = con.prepareStatement(resq);
        res = pstmt.executeQuery();
        Reclamation as = null;
        while (res.next()) {
            as = new Reclamation(
                    res.getInt("id_reclamation"),
                    res.getString("titre"),
                    res.getString("description"));
            list.add(as);

        }
        return list;


    }
         public Reclamation Get_Reclamation_by_id(int id) throws SQLException {
        ResultSet res = null;
        PreparedStatement pstmt = null;
        String resq = "select id_reclamation,titre,description from reclamation where id_reclamation ='" + id + "'";
        pstmt = con.prepareStatement(resq);
        res = pstmt.executeQuery();
        while (res.next()) {
            return new Reclamation(
                    res.getInt("id_reclamation"),
                    res.getString("titre"),
                    res.getString("description"));

        }
        return new Reclamation();
    }
      public void setIdToEdit(int id) {

        this.idReclamation = id;
    }

       public String CountReclamation() throws SQLException {
        String req = "SELECT COUNT(id_reclamation) FROM reclamation ";
        Statement stm = con.createStatement();//googliha
        ResultSet rst = stm.executeQuery(req);
        while (rst.next()) {
            String reclamation = rst.getString("COUNT(id_reclamation)");
            System.out.println(reclamation);
            return (reclamation);

        }

        return (null);



    }
       
        public List<Reclamation> Get_Reclamation_by_IdClient(int id) throws SQLException {
        ResultSet res = null;
        List<Reclamation> list = new ArrayList<>();
        String resq = "select id_reclamation,titre,description from reclamation where id_user ='" + id + "'";
        PreparedStatement pstmt = con.prepareStatement(resq);
        res = pstmt.executeQuery();
        Reclamation as = null;
        while (res.next()) {
            as = new Reclamation(
                    res.getInt("id_reclamation"),
                    res.getString("titre"),
                    res.getString("description"));
            list.add(as);

        }
        return list;

}
//public List<Reclamation> afficherByTitre(String n) {
//        List<Reclamation> myList = new ArrayList<Reclamation>();
//        try {
//
//            String requete2 = "SELECT * FROM reclamation WHERE titre LIKE '%" + n + "%'";
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(requete2);
//
//            while (rs.next()) {
//                Reclamation u = new Reclamation();
//                u.setId(rs.getInt(1));
//                u.setTitre(rs.getString(2));
//                u.setDescription(rs.getString(3));
//                u.setDatee(rs.getString(4));
//                u.setuser_id(rs.getInt(5));
//              
//  
//
//                myList.add(u);
//            }
//
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//        return myList;
//    }  
//     
//      public List<Reclamation> afficherBydesc( String n) {
//        List<Reclamation> myList = new ArrayList<Reclamation>();
//        try {
//
//    String requete2 = "SELECT * FROM reclamation WHERE description LIKE '%" + n + "%'";
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(requete2);
//
//            while (rs.next()) {
//                Reclamation u = new Reclamation();
//                u.setId(rs.getInt(1));
//                u.setTitre(rs.getString(2));
//                u.setDescription(rs.getString(3));
//                u.setDatee(rs.getString(4));
//                u.setuser_id(rs.getInt(5));
//              
//                   myList.add(u);
//            }
//
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//        return myList;
//    }
//      
//      public List<Reclamation> afficherByDate(String a) {
//        List<Reclamation> myList = new ArrayList<Reclamation>();
//        try {
//
//            String requete2 = "SELECT * FROM reclamation WHERE date_reclamation LIKE '%" + a + "%'";
//            Statement st = con.createStatement();
//            ResultSet rs = st.executeQuery(requete2);
//
//            while (rs.next()) {
//                Reclamation u = new Reclamation();
//               u.setId(rs.getInt(1));
//                u.setTitre(rs.getString(2));
//                u.setDescription(rs.getString(3));
//                u.setDatee(rs.getString(4));
//                u.setuser_id(rs.getInt(5));
//            }
//
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//        return myList;
//    }

      public void pdf(int id) throws FileNotFoundException, DocumentException 
    {try {
            String file_name ="C:\\Users\\user\\Desktop\\PDF\\Seif.pdf";
            Document document = new Document();
            //file_name.setReadable(true,false);
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            document.open();
            ste=con.createStatement();
            ResultSet rs =ste.executeQuery("SELECT `titre`,`description`,`date_reclamation` FROM `reclamation` WHERE `id_reclamation`= "+id+ "");
           
            
            while (rs.next()) { 
                Paragraph para=new Paragraph((" Titre: " +rs.getString(1) + "\n  Description : " + rs.getString(2)+ "\n Date reclamation : " + rs.getString(3)));
                     
                        
                document.add(para);
                document.add(new Paragraph(" "));
            }
            document.close();
        } catch (SQLException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReclamationService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
}
}

