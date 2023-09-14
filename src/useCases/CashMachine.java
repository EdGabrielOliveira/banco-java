package useCases;

import models.Account;
import models.Bank;
import models.Transaction;
import models.TransactionType;

import java.util.List;

public class CashMachine {

    private Bank bank;

    public CashMachine(Bank bank){
        this.bank = bank;
    }

    public void deposit(Account account, double value){

            double currentAmount = account.getAmount();
            double newAmount = currentAmount + value;
            account.setAmount(newAmount);
            Transaction transaction = new Transaction(account, account, value, TransactionType.DEPOSIT);
            this.bank.registertrasition(transaction);

            System.out.println("Depositado " + value + " na conta " + account.getAccountId());

    }

    public void transfer(Account source, Account target, double value){

        if (source.getAmount() < value){
            System.out.println("SALDO INSUFICIENTE");
            return;
        }

        source.setAmount(source.getAmount() - value);
        target.setAmount(target.getAmount() + value);
        Transaction transaction = new Transaction(source, target, value, TransactionType.TRANSFER);

        this.bank.registertrasition(transaction);
        System.out.println("TRANSFERIDO " + value + " DE " + source.getAccountId() + " PARA " + target.getAccountId());

    }

    public void withdraw(Account account, double value){

        if (account.getAmount() < value){
            System.out.println("SALDO INSUFICIENTE!");
            return;
        }

        double withdrawAmount = account.getAmount();
        double newAmount = withdrawAmount - value;
        account.setAmount(newAmount);
        Transaction transaction = new Transaction(account, account, value, TransactionType.WITHDRAW);
        this.bank.registertrasition(transaction);

        System.out.println("SAQUE DE " + value + " DA CONTA " + account.getAccountId());
    }

        public void showBalanceAndStatement(Account account){
        List<Transaction> transactions = this.bank.getTrasationByAccountId(account.getAccountId());

        System.out.println("\tSALDO ATUAL: " + account.getAmount());

        transactions.forEach(transaction ->{
            boolean isSource = transaction.getSouceAccount().getAccountId().equals(account.getAccountId());
            boolean isDeposit = transaction.getType().equals(TransactionType.DEPOSIT);
            boolean isWithdraw = transaction.getType().equals(TransactionType.WITHDRAW);

            String type;
            switch (transaction.getType()) {
                case DEPOSIT:
                    type = "DEPOSITADO";
                    break;
                case TRANSFER:
                    type = "ENVIADO";
                    break;
                case WITHDRAW:
                    type = "SACADO";
                    break;
                default:
                    type = "RECEBIDO";
                    break;
            }

            System.out.println("\t"+ type + " " + transaction.getValue() + " NO DIA " + transaction.getDate().toString());
             });
        }
    }