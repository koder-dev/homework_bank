package app.homework_bank.entities;

import app.homework_bank.enums.CurrencyType;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "Accounts", schema = "public")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    private Long balance;

    private String hashCVV;

    private Date expireDate;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void setHashCVV(String hashCVV) {
        this.hashCVV = hashCVV;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    public Long getId() {
        return id;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public UserEntity getUser() {
        return user;
    }

    public Long getBalance() {
        return balance;
    }

    public String getHashCVV() {
        return hashCVV;
    }

    public Date getExpireDate() {
        return expireDate;
    }

    @Override
    public String toString() {
        return "AccountEntity{" +
                "currencyType=" + currencyType +
                ", balance=" + balance +
                '}';
    }

    public AccountEntity(CurrencyType currencyType, UserEntity user, Long balance, String hashCVV) {
        this.currencyType = currencyType;
        this.user = user;
        this.balance = balance;
        this.hashCVV = hashCVV;
    }

    public AccountEntity() {
    }
}
