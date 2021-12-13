/*
David Centeno
CS5004 OOD
Final Project

Webconnection class that creates a connection to a pre-defined or user defined website and scrapes
text from the provided HTML tags.
 */
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class WebConnection{

    private String webUrl;
    private Document doc;
    private Document doc2;
    private final String url = "https://www.leagueofgraphs.com/champions/builds";
    private final Document  playerDOM = Jsoup.connect("https://www.leagueofgraphs.com/rankings/summoners").get();
    protected Document website = Jsoup.connect(url).get();
    protected WebListImpl champions = new WebListImpl();
    protected WebListImpl top100 = new WebListImpl();
    protected WebListImpl divList = new WebListImpl();
    protected WebListImpl tagList= new WebListImpl();
    String[] words = {"#", "Name", "Popularity", "Winrate", "BanRate", "KDA", "Pentas", "/", "match"};


    /**
     * WebConnection constructor Used for League of Graphs example (pre-defined run of program)
     * @throws IOException will throw an exception if the URL is unreachable or is invalid
     */
    public WebConnection() throws IOException {
        this.doc = website;
        this.doc2 = playerDOM;
    };

    /**
     * WebConnection constructor Used for League of Graphs example (pre-defined run of program)
     * @throws IOException will throw an exception if the URL is unreachable or is invalid
     */    public WebConnection(String webaddress) throws IOException{
        this.webUrl = webaddress;
        this.doc = Jsoup.connect(webUrl).get();
    }

    /**
     * getUrl is used for testing if url in constructor is set correctly
     * @return returns the url from the constructor
     */
    public String getUrl(){
        return url;
    }

    /**
     * getUserUrl is used for testing if url in constructor is set correctly
     * @return returns the webUrl from the constructor
     */
    public String getUserUrl(){
        return this.webUrl;
    }

    /**
     * extractDivs is a method that specifically extracts the text of HTML div tags
     */
    public void extractDivs(){
        Elements divTag = doc.getElementsByTag("div");
        for(Element element : divTag){
            if(element.hasText())
            divList.addData(element.text());
        }
    }

    /**
     * extractTags is a method that extracts text based off the HTML tag passed to the method.
     * If no valid tag is passed it will default to div HTML tag
     */
    public void extractTags(String tag){
        if(tag != ""){
            Elements htmlTag = doc.getElementsByTag(tag);
            for (Element element : htmlTag) {
                if (element.hasText()) {
                    tagList.addData(element.text());
                    System.out.println(element.text());
                }
            }
        }
        else{
            Elements divTag = doc.getElementsByTag("div");
            for (Element element : divTag) {
                tagList.addData(element.text());
            }
        }
    }


    //Site specific Method for leagueofgraphs.com a League of Legends Statisitics site.

    /**
     * pullPopularChampion method pulls in champions ordered from the most popular to least popular
     * and adds them to the champion list
     */
    public void pullPopularChampion(){
        Elements championInfo = website.getElementsByTag("tr");
        WebListImpl temp = new WebListImpl();

        //Outer loop iterates through words to filter out of text extraction
        for(String word: words){
            for(Element champion : championInfo){
                if(!champion.text().contains(word) && champion.hasText()){
                    //Sets the champion data from type Element to String/text
                   temp.addData(champion.text());
                }
            }
        }
        //filter out extra/duplicate lines from filtering
        for(int i=3; i<161; i++){
            //champions.add(temp.get(i));
            champions.addData(temp.getData(i));
        }
        //Test for loop to see what is being put in the final linked list
        for(int i= 0; i<157; i++) {
            System.out.println(champions.getData(i));
        }
    }

    /**
     * top100Players method pulls in top 100 players and adds them to the linked list.
     */
    public void top100Players() {
        Elements playerInfo = playerDOM.getElementsByTag("tr");
        WebListImpl playerTemp = new WebListImpl();

        for(Element player : playerInfo){
            if(player.hasText()){
                playerTemp.addData(player.text());
            }
        }
        //Refines what is being put in the final linked list
        for(int i=4; i< 104; i++) {
            top100.addData(playerTemp.getData(i));
        }
        //Test to print all text extracted into linked list.
        for(int i=0; i< 100; i++) {
            System.out.println(top100.getData(i));
        }
    }
}
