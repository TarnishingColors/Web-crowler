import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SearcherForCinema {

    final private String siteAddress;

    private int date;

    private String month;

    private String city;

    private String agent = "Chrome";


    public SearcherForCinema(String siteAddress,
                             int date,
                             String month,
                             String city) {

        this.siteAddress = siteAddress;
        this.date = date;
        this.month = month;
        this.agent = agent;

    }


    public Document InitializeDoc() {

        boolean flag = true;
        Document doc = new Document("");

        while (flag) {

            try {

                doc = Jsoup.connect("http://afisha.ru")
                        .userAgent("Mozilla").get();
                flag = false;

            } catch (Exception e) { continue; }

        }

        return doc;

    }


    //TODO: Implement interactive chat with user

    public static void main(String[] args) throws IOException {

        SearcherForCinema sfc = new SearcherForCinema(
                "afisha.ru",
                29,
                "august",
                "Moscow"
                );

        Document doc = sfc.InitializeDoc();

        System.out.print(doc.html());
        Pattern pattern = Pattern.compile("(\\w+\\.)*(\\w+)");

        for (Element e: doc.select("a[href]")) {

            Matcher matcher = pattern.matcher(e.attr("abs:href"));

            System.out.println(e.attr("abs:href"));
            System.out.println(e.text());
            System.out.println();

            if (matcher.matches()) {

                System.out.println(e.attr("abs:href"));
                System.out.println(e.text());
                System.out.println();

            }
        }
    }
}

