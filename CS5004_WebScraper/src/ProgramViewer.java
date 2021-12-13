
/*
David Centeno
CS5004 OOD
Final Project

ProgramViewer is a class that launches the text view of the program and will eventually pass user defined information
to the controller class
 */

import java.util.Scanner;

public class ProgramViewer {
    //Initializes variables to be passed to the controller
    protected String userUrl;
    protected String htmlTag;
    protected String emailAddress;
    protected int textSelection;
    protected int userSelection;

    /**
     * ProgramViewer is a constructor that starts the program and allows the user to define what content they would like
     * to scrape from the web. The info defined here will be sent to the controller for processing.
     */
    public ProgramViewer() {
        Scanner input = new Scanner(System.in);
        //Initializes the text UI and asks user for pre-made condition output or Customized output
        System.out.println("WebScraper 1.0" + "\n========" + "\nSelect one of the options below:" + "\n1.Pre-Made Web Scraper" + "\n2.Custom Web Scraper");
        userSelection = Integer.parseInt(input.nextLine());

        //Brings user to customization questions
        if (userSelection == 2) {
            //Asks user for URL to scrape info from
            System.out.println("Please enter a url:");
            userUrl = input.nextLine();

            //Asks user to select extracting text from Div tag or custom HTML Tag
            System.out.println("Select an option:" + "\n1.Grab majority of text from the requested website (Div Tag)" + "\n2.Enter a HTML tag to extract text");
            textSelection = Integer.parseInt(input.nextLine());
            if (textSelection == 2) {
                System.out.println("Enter an HTML Tag:");
                htmlTag = input.nextLine();
                System.out.println(htmlTag + " extraction complete!");
            } else {
                System.out.println("Div Tag extraction complete");
            }

            //Asks user for email address for sending information
            System.out.println("Enter email address: ");
            emailAddress = input.nextLine();
            System.out.println("Scraping complete! Program now exiting");
        } else {
            //All content is pre-made and exits the program
            System.out.println("Pre-Made Scraper has emailed the creator");
        }
    }
}
