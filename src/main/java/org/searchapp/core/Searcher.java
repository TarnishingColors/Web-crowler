package org.searchapp.core;

import org.jsoup.nodes.Document;

public interface Searcher {

    abstract public Document InitializeDoc() throws InterruptedException;

}