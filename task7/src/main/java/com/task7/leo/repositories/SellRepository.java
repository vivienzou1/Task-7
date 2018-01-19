package com.task7.leo.repositories;

import com.task7.leo.domain.Fund;
import com.task7.leo.domain.Sell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellRepository extends JpaRepository<Sell, Long> {

}
