package cryptotransaction.model;

import java.time.LocalDate;

public class Transaction {

  private String cryptoCurrency;
  private double exchangeRate;
  private double quantity;
  private TransactionType transactionType;
  private LocalDate transactionDate;

  public String getCryptoCurrency() {
    return cryptoCurrency;
  }

  public void setCryptoCurrency(String cryptoCurrency) {
    this.cryptoCurrency = cryptoCurrency;
  }

  public double getExchangeRate() {
    return exchangeRate;
  }

  public void setExchangeRate(double exchangeRate) {
    this.exchangeRate = exchangeRate;
  }

  public double getQuantity() {
    return quantity;
  }

  public void setQuantity(double quantity) {
    this.quantity = quantity;
  }

  public TransactionType getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(TransactionType transactionType) {
    this.transactionType = transactionType;
  }

  public LocalDate getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(LocalDate transactionDate) {
    this.transactionDate = transactionDate;
  }

  @Override
  public String toString() {
    return "Transaction{" +
        "cryptoCurrency='" + cryptoCurrency + '\'' +
        ", exchangeRate=" + exchangeRate +
        ", quantity=" + quantity +
        ", transactionType=" + transactionType +
        ", transactionDate=" + transactionDate +
        '}';
  }
}
