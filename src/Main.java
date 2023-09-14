import java.util.Optional;
import java.util.Scanner;
import models.Bank;
import models.Account;
import useCases.CashMachine;

public class Main {

    public static void main(String[] args) {

        Bank bank = new Bank();
        CashMachine machine = new CashMachine(bank);

        String option = "";

        while (!option.equals("0")) {

            System.out.println("BEM-VINDOS AO BANCO");
            System.out.println("DIGITE UMA OPÇÃO");
            System.out.println("1 - REGISTRAR");
            System.out.println("2 - DEPOSITAR");
            System.out.println("3 - TRANSFERIR");
            System.out.println("4 - EXTRATO");
            System.out.println("5 - SACAR");
            System.out.println("0 - SAIR");

            Scanner scanner = new Scanner(System.in);
            option = scanner.nextLine();

            switch (option) {

                case "1": {
                    System.out.println("DIGITE O DOCUMENTO");
                    String document = scanner.nextLine();
                    Account newacount = bank.registerAccount(document);
                    System.out.println(newacount);

                    break;
                }
                case "2": {
                    System.out.println("DIGITE O ID DA CONTA");
                    String id = scanner.nextLine();
                    Optional<Account> account = bank.getaccountById(id);

                    if (account.isEmpty()) {
                        System.out.println("CONTA NÃO ENCONTRADA");
                    }
                    System.out.println("DIGITE O VALOR: ");
                    double valor = scanner.nextDouble();
                    machine.deposit(account.get(), valor);

                    break;
                }
                case "3": {

                    System.out.println("DIGITE O ID DA SUA CONTA");
                    String sourceid = scanner.nextLine();
                    Optional<Account> source = bank.getaccountById(sourceid);
                    if (source.isEmpty()) {
                        System.out.println("CONTA NÃO ENCONTRADA");
                    }
                        System.out.println("DIGITE O ID DA SUA CONTA");
                        String targetid = scanner.nextLine();
                        Optional<Account> target = bank.getaccountById(targetid);
                        if (target.isEmpty()) {
                            System.out.println("CONTA NÃO ENCONTRADA");
                        }

                        System.out.println("DIGITE O VALOR: ");
                        double value = scanner.nextDouble();

                        machine.transfer(source.get(), target.get(), value);

                        break;
                    }
                    case "4": {

                        System.out.println("DIGITE O ID DA CONTA");
                        String id = scanner.nextLine();
                        Optional<Account> account = bank.getaccountById(id);

                        if (account.isEmpty()) {
                            System.out.println("CONTA NÃO ENCONTRADA");
                        }
                        machine.showBalanceAndStatement(account.get());

                        break;
                    }

                    case "5": {

                        System.out.println("DIGITE O ID DA CONTA");
                        String withdrawid = scanner.nextLine();
                        Optional <Account> account = bank.getaccountById(withdrawid);

                        if (account.isEmpty()) {
                            System.out.println("CONTA NÃO ENCONTRADA");
                        }

                        System.out.println("DIGITE O VALOR: ");
                        double value = scanner.nextDouble();
                        machine.withdraw(account.get(), value);

                    }
                }
            }
        }
    }