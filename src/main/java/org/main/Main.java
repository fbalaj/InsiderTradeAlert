package org.main;

import javax.mail.MessagingException;
import javax.mail.Transport;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) throws MessagingException, IOException {
        Timer timer = new Timer();
        Scraper initialScraper = new Scraper();
        Scraper repeatedScraper = new Scraper();
        EmailAlert alert = new EmailAlert();
        alert.setUp();
        initialScraper.scrape(); //get the initial state of the website (finviz)

        // Scrape finviz every hour and compare it to the initial state. If no changes, do not send email alert.
        // If changes occurred, set the new state as the initial state, and send an email alert.
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {
                    repeatedScraper.scrape();
                    if (!initialScraper.tickerList.equals(repeatedScraper.tickerList)) {
                        initialScraper.scrape();
                        for (int i = 0; i < repeatedScraper.list.size(); i++) {
                            if (repeatedScraper.watchList.contains(repeatedScraper.list.get(i).getTicker())) {
                                alert.message.setSubject("Insider Trade Alert: " +
                                        repeatedScraper.list.get(i).getTicker());

                                alert.message.setText("Ticker: " + repeatedScraper.list.get(i).getTicker() +
                                        "\nOwner: " + repeatedScraper.list.get(i).getOwner() +
                                        "\nRelationship: " + repeatedScraper.list.get(i).getRelationship() +
                                        "\nDate: " + repeatedScraper.list.get(i).getDate() +
                                        "\nTransaction: " + repeatedScraper.list.get(i).getTransaction() +
                                        "\nCost: " + repeatedScraper.list.get(i).getCost() +
                                        "\n# Shares: " + repeatedScraper.list.get(i).getShares() +
                                        "\nValue: " + repeatedScraper.list.get(i).getValue() +
                                        "\n# Shares owned: " + repeatedScraper.list.get(i).getSharesTotal() +
                                        "\nThis information was automatically retrieved " +
                                        "from https://finviz.com/insidertrading.ashx");

                                System.out.println();
                                Transport.send(alert.message);
                            }
                        }
                    }
                } catch (MessagingException | IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }, 0, 3600*1000);
    }
}