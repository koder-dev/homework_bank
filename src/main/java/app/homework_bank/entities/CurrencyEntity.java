package app.homework_bank.entities;

import app.homework_bank.enums.CurrencyType;
import jakarta.persistence.*;

@Entity
@Table(name = "Curencies", schema = "public")
public class CurrencyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyType firstCurrencyType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CurrencyType secondCurrencyType;

    @Column(nullable = false)
    private Double rate;

    public CurrencyEntity() {
    }

    public CurrencyEntity(CurrencyType firstCurrencyType, CurrencyType secondCurrencyType, Double rate) {
        this.firstCurrencyType = firstCurrencyType;
        this.secondCurrencyType = secondCurrencyType;
        this.rate = rate;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstCurrencyType(CurrencyType firstCurrencyType) {
        this.firstCurrencyType = firstCurrencyType;
    }

    public void setSecondCurrencyType(CurrencyType secondCurrencyType) {
        this.secondCurrencyType = secondCurrencyType;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public CurrencyType getFirstCurrencyType() {
        return firstCurrencyType;
    }

    public CurrencyType getSecondCurrencyType() {
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
