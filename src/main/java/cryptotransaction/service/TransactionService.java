package cryptotransaction.service;

import cryptotransaction.model.Transaction;
import cryptotransaction.model.TransactionType;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class TransactionService {

   public static void enterTransactions(List<Transaction> transactions, Scanner in) {
    boolean quitInput = false;

    while (!quitInput) {
      Transaction transaction = readTransaction();

      if (TransactionValidator.validateTransaction(transaction)) {
        transactions.add(transaction);
        System.out.println("Transaction data is correct. Transaction successfully added");
      } else {
        System.out.println("Input is incorrect! Transaction was not added,");
      }

      System.out.println("Press S to stop add transaction operation or any key to continue ...");
      String userInput = in.nextLine();

      if (userInput.equals("S")) {
        quitInput = true;
      }
    }
  }

   public static Transaction readTransaction() {
    Scanner in = new Scanner(System.in);
    Transaction transaction = new Transaction();

    System.out.println("Please enter new transaction data.");

    System.out.println("Enter transaction CryptoCurrency ...");
    transaction.setCryptoCurrency(in.nextLine());

    System.out.println("Enter transactionType DEBIT/CREDIT ...");

    String inputTransactionType = in.nextLine();

    switch (inputTransactionType) {
      case "DEBIT":
        transaction.setTransactionType(TransactionType.DEBIT);
        break;
      case "CREDIT":
        transaction.setTransactionType(TransactionType.CREDIT);
        break;
    }

    System.out.println("Enter exchange rate: ");
    transaction.setExchangeRate(in.nextDouble());

    System.out.println("Enter quantity: ");
    transaction.setQuantity(in.nextDouble());

    transaction.setTransactionDate(LocalDate.now());

    return transaction;
  }

   public static void loadTransaction(List<Transaction> transactions) {
    double totalDebit = calculateTotalByTransactionType(transactions, TransactionType.DEBIT);
    double totalCredit= calculateTotalByTransactionType(transactions, TransactionType.CREDIT);

    System.out.println("Total transaction count:"+transactions.size());
    System.out.println();

    for (Transaction transaction : transactions) {
      System.out.println(transaction.toString());
    }

    System.out.println();

    System.out.println("Total debit is " + totalDebit);
    System.out.println("Total credit is " + totalCredit);
  }

  public static double calculateTotalByTransactionType(List<Transaction> transactions, TransactionType type) {
    double total = 0;
    for (Transaction transaction : transactions) {
      if (transaction.getTransactionType() == type) {
        total += transaction.getQuantity() * transaction.getExchangeRate();
      }
    }
    return total;
  }

}
