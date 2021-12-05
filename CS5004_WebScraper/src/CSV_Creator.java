import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class CSV_Creator {
    FileWriter leagueChampions = new FileWriter("leagueChampions.csv");
    WebConnection web = new WebConnection();


    public CSV_Creator(LinkedList<String> list) throws IOException {
        leagueChampions.append("Name");
        leagueChampions.append(",");
        leagueChampions.append("Position");
        leagueChampions.append(",");
        leagueChampions.append("Kill Avg");
        leagueChampions.append(",");
        leagueChampions.append("Death Avg");
        leagueChampions.append(",");
        leagueChampions.append("Assist Avg");
        leagueChampions.append(",");
        leagueChampions.append("Pentakill Avg");
        leagueChampions.append("\n");

        for (String champion : list) {
            leagueChampions.append(champion);
            leagueChampions.append("\n");
        }
            leagueChampions.flush();
            leagueChampions.close();

        }
    }
