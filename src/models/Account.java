package models;

public class Account {

    private String account;
    private double amount;
    private String document;

    
    public Account(String account, double amount, String document) {
        this.account = account;
        this.amount = amount;
        this.document = document;
    }


    public String getAccountId() {
        return account;
    }


    public void setAccount(String account) {
        this.account = account;
    }


    public double getAmount() {
        return amount;
    }


    public void setAmount (double amount) {
        this.amount = amount;
    }


    public Account(String document) {
        this.document = document;
    }


    @Override
    public String toString() {
        return "account [account=" + account + ", amount=" + amount + ", document=" + document + "]";
    }


    
    
}
