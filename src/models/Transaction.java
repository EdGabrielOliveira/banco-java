package models;

import java.util.Date;

public class Transaction {

    private Account souceAccount;
    private Account targetAccount;
    private Date date;
    private double value;
    private TransactionType type;

    public Transaction(Account souceAccount, Account targetAccount, double value, TransactionType type) {
        this.souceAccount = souceAccount;
        this.targetAccount = targetAccount;
        this.date = new Date();
        this.value = value;
        this.type = type;
    }

    public Account getSouceAccount() {
        return souceAccount;
    }

    public void setSouceAccount(Account souceAccount) {
        this.souceAccount = souceAccount;
    }

    public Account getTargetAccount() {
        return targetAccount;
    }

    public void setTargetAccount(Account targetAccount) {
        this.targetAccount = targetAccount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "souceAccount=" + souceAccount +
                ", targetAccount=" + targetAccount +
                ", date=" + date +
                ", value=" + value +
                ", type=" + type +
                '}';
    }
}
