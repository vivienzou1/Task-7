package com.task7.leo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "transaction")
public class Transaction {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne()
    private User user;

    @ManyToOne()
    private Fund fund;

    private double amount;

    private double share;

//    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private String type;

    public Transaction(User user, Fund fund, double amount, double share, String type) {
        this.user = user;
        this.fund = fund;
        this.amount = amount;
        this.share = share;
        this.type = type;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + user.hashCode();
        result = 31 * result + fund.hashCode();
        result = 31 * result + (int) (amount * 100);
        result = 31 * result + (int) (share * 1000);
        result = 31 * result + type.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return type + "(" + id + " " + user.getUsername() + " " + (fund == null ? "null" : fund.getFundSymbol()) + " " +
                amount + " " + share + " "  + (date == null ? "null" : date.toString()) +  ")";
    }
}
