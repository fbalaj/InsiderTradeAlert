package org.main;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Scraper {
    protected ArrayList<SECFiling> list = new ArrayList<>();
    protected ArrayList<String> watchList = new ArrayList<>();
    protected ArrayList<String> tickerList = new ArrayList<>();
    protected ArrayList<Element> elements = new ArrayList<>();

    public void scrape() throws IOException {
        elements.clear();
        list.clear();
        tickerList.clear();
        String url = "https://finviz.com/insidertrading.ashx";
        Document doc = Jsoup.connect(url).get();
        Elements buyRow1 = doc.getElementsByClass("insider-buy-row-1 cursor-pointer align-top");
        Elements buyRow2 = doc.getElementsByClass("insider-buy-row-2 cursor-pointer align-top");
        Elements saleRow1 = doc.getElementsByClass("insider-sale-row-1 cursor-pointer align-top");
        Elements saleRow2 = doc.getElementsByClass("insider-sale-row-2 cursor-pointer align-top");
        elements.addAll(buyRow1);
        elements.addAll(buyRow2);
        elements.addAll(saleRow1);
        elements.addAll(saleRow2);

        for (Element y : elements) {
            list.add(new SECFiling(y.children().get(0).text(), y.children().get(1).text(), y.children().get(2).text(),
                    y.children().get(3).text(), y.children().get(4).text(), y.children().get(5).text(),
                    y.children().get(6).text(), y.children().get(7).text(), y.children().get(8).text()));
            tickerList.add(y.children().get(0).text());
        }
    }
}
