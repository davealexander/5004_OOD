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
    private final String url = "https://www.leagueofgraphs.com/champions/builds";
    private final Document  playerDOM = Jsoup.connect("https://www.leagueofgraphs.com/rankings/summoners").get();
    protected Document website = Jsoup.connect(url).get();
    protected LinkedList<String> champions = new LinkedList<>();
    protected LinkedList<String> championName = new LinkedList<>();
    protected LinkedList<String> top100 = new LinkedList<>();
    private Elements names = website.getElementsByClass("name");
    String[] words = {"#", "Name", "Popularity", "Winrate", "BanRate", "KDA", "Pentas", "/", "match"};
    protected LinkedList<String[]> championInfo = new LinkedList<>();

    public WebConnection() throws IOException {};

    //Method that will grab the DOM of the url var
    //MAYBE NOT NECESSARY
    public void testConnection() {
            Connection testWebsite = Jsoup.connect(url);
            //write if statemnt for 200 success  and 500 error.
            System.out.println("Connection Successful");
    }

    //Site specific Method for leagueofgraphs.com a League of Legends Statisitics site.

    // Pulls in the most popular player from the list
    public void pullCharacterPopularity(){
    int rank = 0;
        for (Element name: names){
            //System out tests what is being pulled from site. Appends artificial rank to character
            System.out.println(rank +". " + name.text());
            championName.add(name.text());
            rank++;
        }
    }

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
        //filter out extra
        for(int i=0; i<157; i++){
            champions.add(temp.get(i));
        }
        for(String champion : champions){
            System.out.println(champion);
        }
//        for(Element champion : championInfo) {
//            if (champion.hasText()) {
//                //System.out.println(champion.text());
//                champions.add(champion.text());
//                System.out.println(champion.text());
//            }
        //}
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

    public void printChampions(){
        for(String champion : champions) {
            System.out.println(champion);
        }
        System.out.println(champions.get(2));
    }

    public void parser(){
        //ArrayList<String> content = new ArrayList<>();
        for (String champion : champions){
            championInfo.add(champion.split(" "));
        }


        //        for(String[] info : championInfo) {
//            for (String element : info) {
//                if(!element.contains("/") && !element.contains("#") && !element.contains("Name") && !element.contains("Popularity") && !element.contains("Winrate") && !element.contains("BanRate") && !element.contains("KDA")) {
//                    content.add(element);
//                    System.out.println(element);
//                }
//            }
//        }


    }
//NOT SURE IF I NEED THIS BUT HANDY FOR SELECTOR QUERIES
    //    public void playerName(){
//        Elements playerName = playerDOM.select("div.img-align-block span.name");
//        for(Element name :playerName){
//            System.out.println(name.text());
//        }
//    }





}
