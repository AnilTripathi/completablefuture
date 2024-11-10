package com.completable.future.service.impl;

import com.completable.future.entity.Product;
import com.completable.future.repository.ProductRepository;
import com.completable.future.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findById(Long id) {
        log.info("Service request to fetch product by id: {}", id);
        addDelay();
        return productRepository.findById(id).orElse(null);
    }

    private void addDelay() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
