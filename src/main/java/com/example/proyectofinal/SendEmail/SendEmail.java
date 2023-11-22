package com.example.proyectofinal.SendEmail;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail {

    public String to = "joangomezusma3@gmail.com"; // Dirección de correo electrónico del destinatario
    public String from = "joangomezusma4@gmail.com"; // Dirección de correo electrónico del remitente
    public String host = "smtp.example.com"; // Servidor SMTP

    public SendEmail (){

    }
    public void envioCorreo (){

        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        Session session = Session.getDefaultInstance(properties);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("Asunto del correo electrónico");
            message.setText("Contenido del correo electrónico");
            Transport.send(message);
            System.out.println("Correo electrónico enviado satisfactoriamente...");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }


}
