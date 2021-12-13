/*
David Centeno
CS5004 OOD
Final Project

Emailer class will set up the configuration needed for emails and have a parameter that will send to any email address
given to it.

Used https://www.baeldung.com/java-email as inspiration in trying to figure out how to set up the email properties and
email anatomy. Found that javax.mail is no longer supported which lead to a list of errors. Adding jakarta.activation.jar
resolved the issue.
 */

import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class Emailer {
    //Instantiate variables for email logic
    private String from = "dalexander207@outlook.com";
    final private  String username = "dalexander207@outlook.com";
    final private String password = "NOPE!";

    Properties properties = new Properties();


    /**
     * Email constructor that takes in a parameter for a TO Email address and will send an email. Will throw a Messaging Exception and IO Exception
     * @param emailAddress defines the users email address
     * @param Subject defines the subject of the email
     * @throws MessagingException throws an exception if there is something wrong with the email configuration or
     * something is passed to the method incorrectly
     * @throws IOException throws an error if there is something passed to the method incorrectly
     */
    public Emailer(String emailAddress, String Subject) throws MessagingException, IOException {
        this.sendEmail(emailAddress, Subject);
    }


    /**
     * sendEmail method will set email properties, send to a specific email address with attachments created by the
     * CSV_Creator class
     * @param toAddress String that defines the users email address
     * @param subject String that defines the subject of the email
     * @throws MessagingException throws an exception if there is something wrong with the email configuration or
     * something is passed to the method incorrectly
     * @throws IOException throws an error if there is something passed to the method incorrectly
     */
    public void sendEmail(String toAddress, String subject) throws MessagingException, IOException {
        //Email Property set up
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.host","smtp.office365.com");
        properties.put("mail.smtp.port",587);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.transport.protocol","smtp");


        //Strats a new email session and authenticates the username and password
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        }); //End of session override

        //Message header information. Creates the email, has the to, from, and subject info
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
        message.setSubject(subject);

        //Body of the email
        MimeBodyPart body = new MimeBodyPart();
        body.setText("This is an automated message with attachment from Web Scraper program");

        //Champion attachment
        MimeBodyPart attachment1 = new MimeBodyPart();
        attachment1.attachFile(new File("leagueChampions.csv"));
        //top100 Player attachment
        MimeBodyPart attachment2 = new MimeBodyPart();
        attachment2.attachFile(new File("top100Players.csv"));

        //UserCreated Attachment
        MimeBodyPart userAttachment = new MimeBodyPart();
        userAttachment.attachFile(new File("webScraper.csv"));


        //Merge of bodyparts
        Multipart merge = new MimeMultipart();
        if(subject.equals("League of Legends Scrape")){
            merge.addBodyPart(body);
            merge.addBodyPart(attachment1);
            merge.addBodyPart(attachment2);
            message.setContent(merge);
            Transport.send(message);
            System.out.println("Message Sent!");
        }

        else {
            merge.addBodyPart(body);
            merge.addBodyPart(userAttachment);
            message.setContent(merge);
            Transport.send(message);
            System.out.println("Message Sent!");
        }
    }
}
