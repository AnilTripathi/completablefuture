package com.completable.future.repository;

import com.completable.future.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    Price findByProductId(Long productId);
}
