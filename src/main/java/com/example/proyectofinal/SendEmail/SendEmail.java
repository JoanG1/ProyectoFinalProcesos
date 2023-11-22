package com.example.proyectofinal.SendEmail;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

public class SendEmail implements Runnable {

    private String emailAddressTo = "";
    private String msgSubject = "";
    private String msgText = "";

    final String USER_NAME = "joangomezusma5@gmail.com";   //User name of the Goole(gmail) account
    final String PASSSWORD = "xwzk sfya jbne gnso";  //Password of the Goole(gmail) account
    final String FROM_ADDRESS = "joangomezusma5@gmail.com";  //From addresss

    private int tiempoEnMinutos;
    private int tiempoEnMilisegundos;

    public SendEmail(int tiempoEnMinutos) {

        this.tiempoEnMinutos = tiempoEnMinutos;
        this.tiempoEnMilisegundos = tiempoEnMinutos * 60 * 1000;
    }

    public void createEmail(String emailAddressTo, String msgSubject, String msgText) {
        this.emailAddressTo = emailAddressTo;
        this.msgSubject = msgSubject;
        this.msgText = msgText;
    }


    private void sendEmailMessage() {

        //Create email sending properties
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("joangomezusma5@gmail.com", "xwzk sfya jbne gnso");
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("joangomezusma5@gmail.com")); //Set from address of the email
            message.setContent(msgText,"text/html"); //set content type of the email

            message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("joangomezusma5@gmail.com")); //Set email recipient

            message.setSubject("Hello World"); //Set email message subject
            Transport.send(message); //Send email message

            System.out.println("sent email successfully!");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void setEmailAddressTo(String emailAddressTo) {
        this.emailAddressTo = emailAddressTo;
    }

    public void setSubject(String subject) {
        this.msgSubject = subject;
    }

    public void setMessageText(String msgText) {
        this.msgText = msgText;
    }


    @Override
    public void run() {

        while (true) {
            try {
                Thread.sleep(tiempoEnMilisegundos);
                // Llama al método que deseas ejecutar
               sendEmailMessage();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
