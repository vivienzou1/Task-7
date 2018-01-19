package com.task7.leo.repositories;

import com.task7.leo.domain.Fund;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FundRepository extends JpaRepository<Fund, Long> {

    Fund findByFundName(String fundName);
    Fund findByFundSymbol(int fundSymbol);

}
