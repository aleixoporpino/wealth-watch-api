package com.porpapps.wealthwatchapi.repository;

import com.porpapps.wealthwatchapi.model.PortfolioItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PortfolioItemRepository extends JpaRepository<PortfolioItem, Integer> {
}
