package org.searchapp.core;

import org.jsoup.nodes.Document;

public abstract class Searcher {

    private String siteAddress;

    private int date;

    private String month;

    private String city;

    private String agent = "Chrome";

    abstract public Document InitializeDoc();
}
