package com.porpapps.wealthwatchapi.repository;

import com.porpapps.wealthwatchapi.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Integer> {
}
