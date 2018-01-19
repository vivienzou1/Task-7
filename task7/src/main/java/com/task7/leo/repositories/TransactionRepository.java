package com.task7.leo.repositories;

import com.task7.leo.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Transaction findById(Long id);
    List<Transaction> findByIdAfter(Long id);

    @Modifying
    @Query("update Transaction as t set t.date = ?1 where t.id = ?2")
    int updateDateById(Date date, long id);
}
