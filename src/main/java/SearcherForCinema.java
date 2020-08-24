import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class SearcherForCinema {

    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("http://afisha.yandex.com").userAgent("Opera").get();
        System.out.print(doc.html());
        for (Element e: doc.select("a[href]")) {
            System.out.println(e.attr("abs:href"));
            System.out.println(e.text());
            System.out.println();
        }

    }
}

