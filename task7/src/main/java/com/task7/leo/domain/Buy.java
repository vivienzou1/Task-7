package com.task7.leo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@NoArgsConstructor
@Table(name = "buy")
public class Buy extends Transition {

    private double amount;

    public Buy(User user, Fund fund, double amount) {
        super(user, fund);
        this.amount = amount;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int)(amount * 100);
        return result;
    }
}
