package com.task7.leo.repositories;

import com.task7.leo.domain.Buy;
import com.task7.leo.domain.Transition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransitionRepository extends JpaRepository<Transition, Long> {

}
