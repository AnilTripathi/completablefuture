package com.completable.future.service;

import com.completable.future.entity.Inventory;

public interface InventoryService {
    Inventory getInventoryByProductId(Long productId);
}
