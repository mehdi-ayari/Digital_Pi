/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wassalni.utilits;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author UnKnOWn
 */
public class MailPromotion {
    
    public static void sendMail(String recipient,String description) throws Exception{
        Properties properties = new Properties();
        //mail.smtp.auth    
        //mail.smtp.starttls.enable
        //mail.smtp.host=smtp.gmail.com
        //mail.smtp.port=587
        properties.put("mail.smtp.auth" , true);
        properties.put("mail.smtp.starttls.enable", true);
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        String email ="amir.horchani@esprit.tn";
        String password="95870165a";
        Session session = Session.getDefaultInstance(properties, new Authenticator(){
        protected PasswordAuthentication getPasswordAuthentication(){
        return new PasswordAuthentication(email, password);
        }
        });
        String desc=description;
        Message message = prepareMessage(session,email,recipient,desc);
        Transport.send(message);
    }

    private static Message prepareMessage(Session session, String email, String recipient,String desc) throws MessagingException {
        try {
            Message message = new MimeMessage(session);
            
            message.setFrom(new InternetAddress(email));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
            message.setSubject("Promotion");
            message.setText(desc);
            return message;
            
        } catch (AddressException ex) {
            Logger.getLogger(MailPromotion.class.getName()).log(Level.SEVERE, null, ex);
        }
                    return null;

        }
    
}
