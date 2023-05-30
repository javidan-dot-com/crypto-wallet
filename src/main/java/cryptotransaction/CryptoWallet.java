package cryptotransaction;

import static cryptotransaction.service.TransactionService.enterTransactions;
import static cryptotransaction.service.TransactionService.loadTransaction;

import cryptotransaction.model.Transaction;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CryptoWallet {

  public static void main(String[] args) {
    List<Transaction> transactions = new ArrayList<>();
    Scanner in = new Scanner(System.in);
    boolean quitApplication = false;

    System.out.println("Welcome to CryptoWallet system!");

    while (!quitApplication) {
      printMenu();
      String userAction = in.nextLine();

      switch (userAction) {
        case "1":
          enterTransactions(transactions, in);
          break;
        case "2":
          loadTransaction(transactions);
          break;
        case "3":
          quitApplication = true;
          break;
        default:
          System.out.println("Wrong input");
      }
    }
  }

  private static void printMenu() {
    System.out.println("Please choose one operation");
    System.out.println();

    System.out.println("1 Add transaction");
    System.out.println("2 Load transaction");
    System.out.println("3 Exit");
  }

}
