import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


class WebCrawler {

    private Queue<String> queue;
    private HashSet<String> discovered_websites;


    public WebCrawler()
    {
        this.queue = new LinkedList<>();

        this.discovered_websites = new HashSet<>();
    }


    public void discover(String root)
    {

        this.queue.add(root);
        this.discovered_websites.add(root);

        while (!queue.isEmpty()) {

            String v = queue.remove();
            String raw = readUrl(v);
            String regex = "https://(\\w+\\.)*(\\w+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(raw);

            while (matcher.find()) {

                String actual = matcher.group();

                if (!discovered_websites
                        .contains(actual)) {

                    discovered_websites.add(actual);
                    System.out.println("Website found: " + actual);
                    queue.add(actual);
                }
            }
        }
    }

    public String readUrl(String v)
    {

        String raw = "";

        try {

            URL url = new URL(v);

            BufferedReader bufferedReader =
                    new BufferedReader(
                    new InputStreamReader(
                            url.openStream()));

            String input = "";

            while ((input = bufferedReader.readLine()) != null) {
                raw += input;
            }
            bufferedReader.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return raw;
    }

    public static void main(String[] args) throws IOException {

        WebCrawler webCrawler = new WebCrawler();
        String root = "https://www.habr.com";

        webCrawler.discover(root);

    }
}

