package cryptotransaction.service;

import cryptotransaction.model.Transaction;
import cryptotransaction.model.TransactionType;

public class TransactionValidator {

  public static boolean validateTransaction(Transaction transaction) {
    if (transaction.getCryptoCurrency() == null
        || transaction.getCryptoCurrency().isEmpty()
        || transaction.getExchangeRate() <= 0
        || transaction.getQuantity() <= 0
        || (transaction.getTransactionType() != TransactionType.DEBIT
        && transaction.getTransactionType() != TransactionType.CREDIT)) {
      System.out.println("Please enter correct data.");
      return false;
    }
    return true;
  }
}
