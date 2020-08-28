package org.searchapp.core;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SearcherForCinema extends Searcher {

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

    @Override
    public Document InitializeDoc() throws InterruptedException {

        boolean flag = true;
        Document doc = null;

        while (flag) {

            try {

                doc = Jsoup.connect(siteAddress)
                        .userAgent(agent).get();
                flag = false;

            } catch (Exception e) { Thread.sleep(10); }

        }

        return doc;

    }


    //TODO: Implement interactive chat with user

    public static void main(String[] args) throws IOException, InterruptedException {

        SearcherForCinema sfc = new SearcherForCinema(
                "https://afisha.ru/",
                29,
                "august",
                "Moscow"
                );

        Document doc = sfc.InitializeDoc();

        System.out.print(doc.html());
        Pattern pattern = Pattern.compile("cinema");

        for (Element e: doc.select("a[href]")) {

            Matcher matcher = pattern.matcher(e.attr("abs:href"));

//            System.out.println(e.attr("abs:href"));
//            System.out.println(e.text());
//            System.out.println();

            if (e.attr("abs:href").matches("^.*?(movie|cinema).*$")) {

                System.out.println(e.attr("abs:href"));
                System.out.println(e.text());
                System.out.println();

            }
        }
    }
}

