package com.completable.future.service;

import com.completable.future.entity.Price;

public interface PriceService {
    Price getPriceByProductId(Long productId);
}
