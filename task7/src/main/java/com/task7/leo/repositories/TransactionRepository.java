package com.task7.leo.repositories;

import com.task7.leo.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByIdAfter(Long id);
}
