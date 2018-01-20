package com.task7.leo.repositories;

import com.task7.leo.domain.Fund;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;

public interface FundRepository extends JpaRepository<Fund, Long> {

    Fund findByFundName(String fundName);
    Fund findByFundSymbol(int fundSymbol);

    @Modifying
    @Query("update Fund as f set f.price = ?1 where f.fundSymbol = ?2")
    int updatePriceBySymbol(double price, int fundSymbol);

}
