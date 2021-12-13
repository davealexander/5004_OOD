/*
David Centeno
CS5004 OOD
Final Project

CSV_Creator class takes in data from WebConnections and will turn that data into a CSV that will create the file within
the project directory
*/
import java.io.FileWriter;
import java.io.IOException;

public class CSV_Creator {
    //Variables that instantiate pre-determined csv files and webconnection
    private FileWriter leagueChampions = new FileWriter("leagueChampions.csv");
    private FileWriter top100 = new FileWriter("top100Players.csv");
    WebConnection web = new WebConnection();

    /**
     * CSV_Creator constructor with no parameters is used with pre-defined methods
     * @throws IOException
     */
    public CSV_Creator() throws IOException {};

    //Constructor that will take in the user defined filname and list to produce a csv

    /**
     * CSV_Creator method takes in two parameters that will use the data passed in to create a CSV file and add the data
     * to the CSV file
     * @param filename expects a string that will name the csv file
     * @param list expects a filled linkedlist from WebListImpl
     * @throws IOException throws an exception if the parameters are not met or the file cannot be created
     */
    public CSV_Creator(String filename, WebListImpl list) throws IOException{
        FileWriter newFile = new FileWriter(filename);
        for(int i =0; i< list.count(); i++){
            newFile.append(list.getData(i));
            newFile.append("\n");
        }
        newFile.flush();
        newFile.close();
    }

    /**
     * leagueChampions is a pre-defined method that sets the headers of the CSV file and expects
     * the pull of data from pullPopularChampion method in WebConnection.
     * @param list expects the data pullPopularChampion method
     * @throws IOException throws an exception if it is unable to create the file or something is wrong with the data
     * passed to the method
     */
    public void leagueChampions(WebListImpl list) throws IOException {
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
        for(int i =0; i< list.count(); i++) {
            leagueChampions.append(list.getData(i));
            leagueChampions.append("\n");
        }
            leagueChampions.flush();
            leagueChampions.close();
    }

    /**
     * top100Players is a pre-defined method that will use the top100Players method in WebConnection
     * and create a csv based off of the information provided in the list.
     * @param list
     * @throws IOException
     */
    public void top100Players(WebListImpl list) throws IOException{
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
        for(int i =0; i< list.count(); i++){
            top100.append(list.getData(i));
            top100.append("\n");
        }
        //Closes out the file
        top100.flush();
        top100.close();
    }

}
