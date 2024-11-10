package com.completable.future.service.impl;

import com.completable.future.entity.Inventory;
import com.completable.future.repository.InventoryRepository;
import com.completable.future.service.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory getInventoryByProductId(Long productId) {
        log.info("Getting inventory for the productId {}", productId);
        return inventoryRepository.findByProductId(productId);
    }
}
