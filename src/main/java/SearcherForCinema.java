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


    public SearcherForCinema(String siteAddress) {
        this.siteAddress = siteAddress;
    }


    //TODO: Implement interactive chat with user

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("http://afisha.ru/msk")
                .userAgent("Mozilla").get();
        System.out.print(doc.html());
        Pattern pattern = Pattern.compile("(\\\\w*)cinema(\\\\w*)");

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

