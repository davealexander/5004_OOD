import java.io.IOException;

public class main {
    public static void main(String args[]) throws IOException {
        WebConnection web = new WebConnection();

        //web.pullTopWinrate();
        web.top100Players();
    }
}
