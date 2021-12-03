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

public class WebConnection{
    //url is a variable to connect ot the website
    private final String url = "https://www.leagueofgraphs.com/champions/builds";
    protected Document website;

    public WebConnection(){};

    //checks connectivity of the website before grabbing DOM
    private String checkConnectivity(){
        try{
           Connection testWebsite = Jsoup.connect(url);
           return "Connection Successful" + testWebsite;
        }
        catch(Exception e){
            return "Connection failed";
        }
    }

    //Method that will grab the DOM of the url var
    //MAYBE NOT NECESSARY
    public void getWebsiteDom(){
        try{
            website = Jsoup.connect(url).get();
            System.out.println(website.outerHtml());
        }
        catch(IOException e){
            System.err.println("Error: "+ e.getMessage());
        }
    }

    //Extract All data from DOM
    public String extractData() throws IOException {
        website = Jsoup.connect(url).get();
        return website.text();

    }




}
