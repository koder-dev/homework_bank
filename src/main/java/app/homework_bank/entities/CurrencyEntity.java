package app.homework_bank.entities;

import app.homework_bank.enums.CURRENCY_TYPE;
import jakarta.persistence.*;

@Entity
@Table(name = "Curencies", schema = "public")
public class CurrencyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CURRENCY_TYPE firstCurrencyType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CURRENCY_TYPE secondCurrencyType;

    @Column(nullable = false)
    private Double rate;

    public CurrencyEntity() {
    }

    public CurrencyEntity(CURRENCY_TYPE firstCurrencyType, CURRENCY_TYPE secondCurrencyType, Double rate) {
        this.firstCurrencyType = firstCurrencyType;
        this.secondCurrencyType = secondCurrencyType;
        this.rate = rate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstCurrencyType(CURRENCY_TYPE firstCurrencyType) {
        this.firstCurrencyType = firstCurrencyType;
    }

    public void setSecondCurrencyType(CURRENCY_TYPE secondCurrencyType) {
        this.secondCurrencyType = secondCurrencyType;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public CURRENCY_TYPE getFirstCurrencyType() {
        return firstCurrencyType;
    }

    public CURRENCY_TYPE getSecondCurrencyType() {
        return secondCurrencyType;
    }

    public Double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return "CurrencyEntity{" +
                "firstCurrencyType=" + firstCurrencyType +
                ", secondCurrencyType=" + secondCurrencyType +
                ", rate=" + rate +
                '}';
    }
}
