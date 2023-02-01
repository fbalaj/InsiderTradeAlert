# Insider Trade Alert

A Java app that allows the user to create a stock watchlist and then notifies the user of any stock trades by an insider of a company in the watchlist.
Uses the JSoup library to scrape recent SEC filings from https://finviz.com/insidertrading.ashx and uses the JavaMail API to send an email alert to the user if 
any insiders have made any recent stock trades.

## Sample run: 

Suppose the user wants to be notified of insider trades of Disney (NYSE: DIS). 

They can add "DIS" to the watchlist by inserting the following line into the main class 

![image](https://user-images.githubusercontent.com/105755993/216004644-d711eeca-46e1-4e16-9ed2-1345b2f2d339.png)

If a recent SEC filing for Disney is found on finviz, 

![finviz1](https://user-images.githubusercontent.com/105755993/216004956-2cb4b3a4-b2eb-4cd3-a39b-99b6d9a7b25a.PNG)

then the user is notified via email: 

![finviz2](https://user-images.githubusercontent.com/105755993/216005043-a8b72eb0-97df-472f-be69-c95e01ca939c.PNG)
