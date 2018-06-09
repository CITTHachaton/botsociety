/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author benja
 */
public class ControladorCorreo {
    String Username = "botsociety2018@gmail.com";
    String PassWord = "hackathon";
    String host = "smtp.gmail.com";
    String port = "587";
    
    
    public int enviar(String correoDestinatario, String mensaje, String asunto) {  
        String Subject = asunto;
        String Mensaje = mensaje;

        String To = correoDestinatario; //correo destinatario      

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        Session session;

        session = Session.getInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Username, PassWord);
            }
        }
        );

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(To));
            message.setSubject(Subject);
            message.setContent(Mensaje,"text/html; charset=utf-8");

            Transport.send(message);

        } catch (MessagingException e) {
            return -1;
        }
        return 1;
    } 
    
    
    //Predeterminado 
    public String mensaje(){
        String mensaje = "";
        return mensaje;
    }
}
