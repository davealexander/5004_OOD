import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class CSV_Creator {
    private FileWriter leagueChampions = new FileWriter("leagueChampions.csv");
    private FileWriter top100 = new FileWriter("top100Players.csv");
    WebConnection web = new WebConnection();

    //No parameter constructor
    public CSV_Creator() throws IOException {};

    //Abstract constructor
    public CSV_Creator(String filename, LinkedList<String> list) throws IOException{
        FileWriter newFile = new FileWriter(filename);
        for(String item : list){
            newFile.append(item);
            newFile.append("\n");
        }
    }

    public void leagueChampions(LinkedList<String> list) throws IOException {
        //Column Headers
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
        //Add list
        for (String champion : list) {
            leagueChampions.append(champion);
            leagueChampions.append("\n");
        }
            leagueChampions.flush();
            leagueChampions.close();
        }

    public void top100Players(LinkedList<String> list) throws IOException{
        //Column Headers
        top100.append("Name");
        top100.append(",");
        top100.append("Country");
        top100.append(",");
        top100.append("Rank");
        top100.append(",");
        top100.append("Tier");
        top100.append(",");
        top100.append("LP");
        top100.append(",");
        top100.append("LP Wins:");
        top100.append(",");
        top100.append("Wins");
        top100.append(",");
        top100.append("Win Percentage");
        top100.append("\n");

        //Iterates through the provided list of Top 100 ranked players
        for(String player: list){
            top100.append(player);
            top100.append("\n");
        }
        //Closes out the file
        top100.flush();
        top100.close();
    }
    }
