package app.homework_bank.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Transactions")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "account_sender_id", nullable = false)
    private AccountEntity sender;

    @OneToOne
    @JoinColumn(name = "account_receiver_id", nullable = false)
    private AccountEntity receiver;

    private Date transactionDate;

    private Double amount;

    public TransactionEntity() {
    }

    public TransactionEntity(AccountEntity sender, AccountEntity receiver, Date transactionDate, Double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public AccountEntity getSender() {
        return sender;
    }

    public AccountEntity getReceiver() {
        return receiver;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSender(AccountEntity sender) {
        this.sender = sender;
    }

    public void setReceiver(AccountEntity receiver) {
        this.receiver = receiver;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", receiver=" + receiver +
                ", sender=" + sender +
                '}';
    }
}
