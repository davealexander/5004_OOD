import javax.mail.MessagingException;
import java.io.FileWriter;
import java.io.IOException;

public class main {
    public static void main(String args[]) throws IOException, MessagingException {
        WebConnection web = new WebConnection();
        //web.pullCharacterPopularity();
        web.pullPopularChampion();
        //web.top100Players();
        //web.playerName();
       //web.printChampions();
        //web.parser();
//        CSV_Creator csv = new CSV_Creator();
//        csv.leagueChampions(web.champions);
//        csv.top100Players(web.top100);
//        Emailer email = new Emailer();
//        email.sendEmail("daveacenteno@gmail.com");
    }
}
