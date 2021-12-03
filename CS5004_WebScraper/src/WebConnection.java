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
import java.util.LinkedList;

public class WebConnection{
    //url is a variable to connect ot the website
    private final String url = "https://www.leagueofgraphs.com/champions/builds";
    protected Document website = Jsoup.connect(url).get();
    private LinkedList<String> champions = new LinkedList<>();
    private LinkedList<String> championName = new LinkedList<>();
    private Elements names = website.getElementsByClass("name");


    public WebConnection() throws IOException {};

    //Method that will grab the DOM of the url var
    //MAYBE NOT NECESSARY
    public void testConnection() {
            Connection testWebsite = Jsoup.connect(url);
            //write if statemnt for 200 success  and 500 error.
            System.out.println("Connection Successful");
    }

    //Extract All data from DOM
    public void extractData() throws IOException {
        System.out.println(website.outerHtml());
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

    public void pullTopWinrate(){
        Elements championInfo = website.getElementsByTag("tr");
        for(Element champion : championInfo){
            if(champion.hasText()) {
                System.out.println(champion.text());
                champions.add(champion.text());
            }
        }
    }
    //pulls in top 100 players from web page
    public void top100Players() throws IOException{
        final Document  playerDOM = Jsoup.connect("https://www.leagueofgraphs.com/rankings/summoners").get();
        Elements playerInfo = playerDOM.getElementsByTag("tr");
        for(Element player : playerInfo){
            if(player.hasText()){
                System.out.println(player.text());
            }
        }

    }





}
