package com.codo.acodo.services;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.codo.acodo.entity.EmailMessage;

import org.springframework.stereotype.Component;



@Component
public class EmailserviceApplication {


    private String username;

    private String password;






    public void sendmail(EmailMessage emailmessage) throws AddressException, MessagingException, IOException {
        username="jorgenick69@gmail.com";

        password="gxmmrdfrxvlukwmm";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(username, false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailmessage.getTo_address()));
        msg.setSubject(emailmessage.getSubject());
        msg.setContent(emailmessage.getBody(), "text/html");
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(emailmessage.getBody(), "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        MimeBodyPart attachPart = new MimeBodyPart();
//
//        attachPart.attachFile("C:\\Users\\jorge\\Desktop\\Proyectos Ministerio\\vistas codo a codo\\274732567_10222135957800457_3697031897095642846_n.jpg");
//
//        multipart.addBodyPart(attachPart);
        msg.setContent(multipart);
        // sends the e-mail
        Transport.send(msg);

    }
}