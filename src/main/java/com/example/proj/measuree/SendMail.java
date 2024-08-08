package com.example.proj.measuree;//Email in java
//        Step 1: Add the Java.mail.jar and activation 1.1.1.jar
//        Step2: import the required packages

import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

//Step 3: add a function for sending mail

class SendMail {

    public static void SendMail(String to, String cname, String Subj, String emailBody) {
        String from = "kullumanali2746@gmail.com"; // sender's email
        final String username = "kullumanali2746@gmail.com"; // your Gmail address
        final String password = "xzlj qrqb vivq dkbw"; // your app password

        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject(Subj);
            message.setText(emailBody);
            Transport.send(message);

            System.out.println("Sent message successfully....");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String args[])
    {
        SendMail("omsharangupt@gmail.com","mail","java","Hello Programmer");
    }
}
//Step 4 : make sure that the Gmail account you are using should have enabled 2 step verification