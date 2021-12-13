/*
David Centeno
CS5004 OOD
Final Project
December 12th 2021

Main class initializes the webscraping program.
 */
import javax.mail.MessagingException;
import java.io.IOException;

public class main {
    public static void main(String args[]) throws IOException, MessagingException {

        //Starts the program text UI which interacts with the user to take in parameters to process webscraping
        ProgramViewer viewer = new ProgramViewer();
        //conditional statement if 1 is selected launches the pre-made output.
        if(viewer.userSelection == 1){
            /*No parameter controller constructor that scrapes League of graphs website for popular characters
            and top 100 highest ranked players
             */
            new Controller();
        }
        //Else condition starts the custom WebScraping process
        else {
            //Controller constructor uses the user defined url to determine webscraping options
            Controller controller = new Controller(viewer.userUrl, viewer);

            if (viewer.textSelection == 1) {
                controller.extractDivText();
            } else if (viewer.textSelection == 2) {
                controller.extractTagText();
            }
            //Creates csv file with user defined extraction
            controller.createFile();
            //sends an email out to the user defined email address
            controller.createEmail();
        }
    }
}
