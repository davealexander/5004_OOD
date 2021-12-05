import java.io.IOException;

public class main {
    public static void main(String args[]) throws IOException {
        WebConnection web = new WebConnection();
        //web.pullCharacterPopularity();
        web.pullPopularChampion();
        //web.top100Players();
        //web.playerName();
       //web.printChampions();
        web.parser();
        CSV_Creator csv = new CSV_Creator(web.champions);

    }
}
