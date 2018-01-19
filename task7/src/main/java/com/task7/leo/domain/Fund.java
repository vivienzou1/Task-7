package com.task7.leo.domain;

import com.task7.leo.dto.FundCreateForm;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "fund")
public class Fund {
    @Id
    @GeneratedValue
    private long id;

    private String fundName;

    private int fundSymbol;

    private double price;

    public static final double PRICE_LIMIT = 100000;

    @Temporal(TemporalType.DATE)
    private Date lastTransition;

    @ManyToMany
    private Set<User> users;

    public Fund(FundCreateForm fundCreateForm) {
        this.fundName = fundCreateForm.getFundName();
        this.fundSymbol = fundCreateForm.getFundSymbol();
        this.price = fundCreateForm.getPrice();
        this.users = new HashSet<>();
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + (fundName != null ? fundName.hashCode() : 0);
        result = 31 * result + fundSymbol;
        result = 31 * result + (int) (price * 100);
        return result;
    }
}
