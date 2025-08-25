package bankexercise.entity;

public class Transaction {

    // DEPOSIT, WITHDRAW, TRANSFER
    private final long id;
    private final TransactionType transactionType;
    private final BankAccount from; // if deposit -> null
    private final BankAccount to;  // if withdraw -> null
    private long amount;
    /*
    Currency (tien te) -> BigDecimal
     */

    public Transaction(long id, TransactionType transactionType, BankAccount from, BankAccount to, long amount) {
        this.id = id;
        this.transactionType = transactionType;
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public BankAccount getFrom() {
        return from;
    }

    public BankAccount getTo() {
        return to;
    }

    public long getAmount() {
        return amount;
    }
}
