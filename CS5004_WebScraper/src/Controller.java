/*
David Centeno
CS5004 OOD
Final Project

Controller handles the passing of data from the viewer to the model which the WebConnection class.
 */
import javax.mail.MessagingException;
import java.io.IOException;

public class Controller {
    //Variables to instantiate WebConnection and Program Viewer
    private WebConnection webConnection;
    private ProgramViewer programViewer;

    //Constructor that will take in user defined parameters from the viewer

    /**
     * Controller constructor that will take in a web and viewer parameter that will help pass information to
     * WebConnection(model). This allows the user to define what url needs to be scraped of text
     * @param web is expecting a string that is a url
     * @param viewer is expecting the ProgramViewer class
     * @throws IOException constructor will throw an exception if it cannot connect to the URL or an invalid parameter is passed
     */
    public Controller(String web, ProgramViewer viewer) throws IOException {
        this.webConnection = new WebConnection(web);
        this.programViewer = viewer;
    };

    /**
     * Controller constructor that uses pre-defined methods to scrape the league of graphs website
     * @throws IOException constructor will throw an exception it cannot connect to the URL or an invalid parameter is passed
     * @throws MessagingException constructor will throw an exception if something fails in the email process.
     */
    public Controller() throws IOException, MessagingException {
        this.webConnection = new WebConnection();
        webConnection.pullPopularChampion();
        new CSV_Creator().leagueChampions(webConnection.champions);
        webConnection.top100Players();
        new CSV_Creator().top100Players(webConnection.top100);
        new Emailer("daveacenteno@gmail.com","League of Legends Scrape");
    }


    /**
     * extractDivText method uses the url provided in the constructor to extract any text that are within the div tags of a website
     */
    public void extractDivText(){
        this.webConnection.extractDivs();
    }

    /**
     * extractTagText method will extract the text from the provided HTML tag. Will default to div
     */
    public void extractTagText(){
        if(programViewer.htmlTag != "")
            this.webConnection.extractTags(programViewer.htmlTag);
        else{
            this.webConnection.extractTags("div");
        }
    }


    /**
     * createFile method will create a CSV with the contents of extractDivText or extractTagText
     * @throws IOException method will throw an error if an invalid parameter is passed or if there is an invalid file path
     * to pick up the CSV file.
     */
    public void createFile() throws IOException {
        if (programViewer.textSelection == 2){
            new CSV_Creator("webScraper.csv", webConnection.tagList);
        }
        else{
            new CSV_Creator("webScraper.csv",webConnection.divList);
        }
    }

    /*crerateEmail method will create an email with a pre-determined subject and body.
      Create email will also send an attachment of a csv that was created in the createFile method.
     */

    /**
     * createEmail method will create an email with a pre-determined subject and body.
     * Create email will also send an attachment of a csv that was created in the createFile method.
     * @throws IOException method will throw an error if any value is not expected or invalid
     * @throws MessagingException method will throw an exception if it cannot create or process the email.
     */
    public void createEmail() throws IOException, MessagingException {
        new Emailer(programViewer.emailAddress, "Java WebScraper");
    }
}
