import  java.util.Scanner;
public class main {
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        System.out.println("WebScraoer 1.0" + "\n========" + "\nSelect one of the options below:" +"\n1.Pre-Made Web Scraper" + "\n2.Custom Web Scraper");
        int userSelection = Integer.parseInt(input.nextLine());

        if(userSelection == 2) {
            System.out.println("Please enter a url:");
            String userUrl = input.nextLine();

            System.out.println("Select an option:" + "\n1.Grab majority of text from the requested website" + "\n2.Enter a HTML tag to extract text");
            int textSelection = Integer.parseInt(input.nextLine());
            if (textSelection == 2) {
                System.out.println("Enter an HTML Tag:");
                String htmlTag = input.nextLine();
                System.out.println("Extraction complete");
            } else {
                System.out.println("Extraction complete");
            }
            System.out.println("Select output file:" + "\n1.Text file" + "\n2.CSV file");
            int fileSelection = Integer.parseInt(input.nextLine());
            if (fileSelection == 2) {
                System.out.println("CSV file created!");
            } else {
                System.out.println("Text file created");
            }
            System.out.println("Enter email address: ");
            String emailAddress = input.nextLine();
            System.out.println("Scraping complete! Program now exiting");
        }
        else{
            System.out.println("Pre-Made Scraper has emailed the creator");
        }


    }
}
