package models;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

public class Bank {

    private List <Account> account;
    private List <Transaction> transaction;

    public Bank() {
        this.account = new ArrayList<>();
        this.transaction = new ArrayList<>();
    }

    public Account registerAccount (String document){
        String id = UUID.randomUUID().toString();
        Account account = new Account(id, 0, document);
        this.account.add(account);
        return account;
    }

    public void registertrasition (Transaction transaction){
        this.transaction.add(transaction);
    }

    public Optional <Account> getaccountById(String id){
        return this.account.stream().filter(
                Account -> Account.getAccountId().equals(id)
        ).findFirst();
    }

    public List<Transaction> getTrasationByAccountId(String id){
        return this.transaction.stream().filter(
                transaction -> transaction.getSouceAccount().getAccountId().equals(id)
                        || transaction.getTargetAccount().getAccountId().equals(id)
        ).collect(Collectors.toList());
    }
}

