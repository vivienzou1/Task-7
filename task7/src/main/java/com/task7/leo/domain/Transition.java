package com.task7.leo.domain;

import com.task7.leo.dto.TransitionForm;
import com.task7.leo.dto.UserRegisterForm;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@Table(name = "transition")
public class Transition {
    @Id
    @GeneratedValue
    private long id;

    @ManyToOne()
    private User user;

    @ManyToOne()
    private Fund fund;

//    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp timestamp;


    public Transition(User user, Fund fund) {
        this.user = user;
        this.fund = fund;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (int) (id ^ (id >>> 32));
        result = 31 * result + user.hashCode();
        result = 31 * result + fund.hashCode();
        return result;
    }
}
