package com.task7.leo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Table(name = "sell")
public class Sell extends Transition {

    private double share;

    public Sell(User user, Fund fund, double share) {
        super(user, fund);
        this.share = share;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int)(share * 1000);
        return result;
    }
}
