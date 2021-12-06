import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.*;
import java.io.File;
import java.io.IOException;
import java.util.Properties;


public class Emailer {
    //Instantiate variables for email logic
    private String to = "daveacenteno@gmail.com";
    private String from = "dalexander207@outlook.com";
    final private  String username = "dalexander207@outlook.com";
    final private String password = "Fireball21!";
    Properties properties = new Properties();

    //Email constructor that takes in a parameter for a TO Email address. Will throw a Messaging Exception and IO Exception
    public Emailer(){}

    public void sendEmail(String toAddress) throws MessagingException, IOException {
        //Email Property set up
        properties.put("mail.smtp.auth",true);
        properties.put("mail.smtp.host","smtp.office365.com");
        properties.put("mail.smtp.port",587);
        properties.put("mail.smtp.starttls.enable",true);
        properties.put("mail.transport.protocl","smtp");


        //Strats a new email session and authenticates the username and password
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("dalexander207@outlook.com","Fireball21!");
            }
        }); //End of session override

        //Message header information. Creates the email, has the to, from, and subject info
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(toAddress));
        message.setSubject("League of Legends Test Email");

        //Body of the email
        MimeBodyPart body = new MimeBodyPart();
        body.setText("This is a report from League of Graphs sent from my Java Web Scraper");

        //Champion attachment
        MimeBodyPart attachment1 = new MimeBodyPart();
        attachment1.attachFile(new File("leagueChampions.csv"));

        //top100 Player attachment
        MimeBodyPart attachment2 = new MimeBodyPart();
        attachment2.attachFile(new File("top100Players.csv"));

        //Merge of bodyparts
        Multipart merge = new MimeMultipart();
        merge.addBodyPart(body);
        merge.addBodyPart(attachment1);
        merge.addBodyPart(attachment2);

        //Finalizes the content and sends the email out
        message.setContent(merge);
        Transport.send(message);
    }
}
