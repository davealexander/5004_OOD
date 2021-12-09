/*
David Centeno
CS5004 OOD
Final Project
WebConnection Class handles establishing a connection to the website
 */
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class WebConnection{
    //url is a variable to connect ot the website
    private String webUrl;
    private Document doc;
    private final String url = "https://www.leagueofgraphs.com/champions/builds";
    private final Document  playerDOM = Jsoup.connect("https://www.leagueofgraphs.com/rankings/summoners").get();
    protected Document website = Jsoup.connect(url).get();
    protected LinkedList<String> champions = new LinkedList<>();
    protected LinkedList<String> championName = new LinkedList<>();
    protected LinkedList<String> top100 = new LinkedList<>();
    protected LinkedList<String[]> championInfo = new LinkedList<>();
    String[] words = {"#", "Name", "Popularity", "Winrate", "BanRate", "KDA", "Pentas", "/", "match"};


    //Used for static methods for League of Graphs example
    public WebConnection() throws IOException {};

    //Constructor that takes in requested webaddress
    public WebConnection(String webaddress) throws IOException{
        this.webUrl = webaddress;
        this.doc = Jsoup.connect(webUrl).get();
    }

    //returns the url of the webConnection object
    public String getUrl(){
        return this.webUrl;
    }

    //Tests the connection of a website
    public void testConnection(String url) {
        try{
            Connection testWebsite = Jsoup.connect(url);
            testWebsite.response().parse();
            System.out.println("Success: Connection was successful");
        }
        catch (IOException e) {
            System.out.println("Error: Connection could not be established");
            e.printStackTrace();
        }
    }

    //Method that specficially extracts the text of HTML div tags
    public void extractDivs(){
        Elements divTag = doc.getElementsByTag("div");
        for(Element element : divTag){
            if(element.hasText())
            System.out.println(element.text());
        }
    }

    //Method that extracts text based off the html passed to the method.
    public void extractTags(String tag){
        Elements divTag = doc.getElementsByTag(tag);
        for(Element element : divTag){
            System.out.println(element.text());
        }
    }

    //Site specific Method for leagueofgraphs.com a League of Legends Statisitics site.

    //pulls in champions ordered from the most popular to least popular and adds them to the champion list
    public void pullPopularChampion(){
        Elements championInfo = website.getElementsByTag("tr");
        LinkedList<String> temp = new LinkedList<>();

        for(String word: words){
            for(Element champion : championInfo){
                if(!champion.text().contains(word) && champion.hasText()){
                   temp.add(champion.text());
                }
            }
        }
        //filter out extra lines
        for(int i=0; i<157; i++){
            champions.add(temp.get(i));
        }
        for(String champion : champions){
            System.out.println(champion);
        }
    }

    //pulls in top 100 players and adds them to the linked list.
    public void top100Players() {
        Elements playerInfo = playerDOM.getElementsByTag("tr");
        for(Element player : playerInfo){
            if(player.hasText()){
                System.out.println(player.text());
                top100.add(player.text());
            }
        }
    }

}
