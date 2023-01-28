package org.main;

public class SECFiling {
    private String ticker, owner, relationship, date, transaction, cost, shares, value, sharesTotal;

    public SECFiling(String ticker, String owner, String relationship, String date, String transaction,
                     String cost, String shares, String value, String sharesTotal) {
        this.ticker = ticker;
        this.owner = owner;
        this.relationship = relationship;
        this.date = date;
        this.transaction = transaction;
        this.cost = cost;
        this.shares = shares;
        this.value = value;
        this.sharesTotal = sharesTotal;
    }

    public String getTicker() {
        return ticker;
    }

    public String getOwner() {
        return owner;
    }

    public String getRelationship() {
        return relationship;
    }

    public String getDate() {
        return date;
    }

    public String getTransaction() {
        return transaction;
    }

    public String getCost() {
        return cost;
    }

    public String getShares() {
        return shares;
    }

    public String getValue() {
        return value;
    }

    public String getSharesTotal() {
        return sharesTotal;
    }
}
