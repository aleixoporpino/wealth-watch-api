package com.porpapps.wealthwatchapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioItem extends JpaRepository<PortfolioItem, Integer> {
}
