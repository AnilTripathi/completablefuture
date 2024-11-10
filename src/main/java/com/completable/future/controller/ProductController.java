package com.completable.future.controller;


import com.completable.future.dto.ProductDetailDTO;
import com.completable.future.manager.ProductASyncManager;
import com.completable.future.manager.ProductSyncManager;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
public class ProductController {

    @Autowired
    private ProductSyncManager productSyncFacade;

    @Autowired
    private ProductASyncManager productASyncFacade;

    @GetMapping("/{id}/sync")
    public ResponseEntity<ProductDetailDTO> getProductSync(@PathVariable Long id) {
        log.info("Rest request to get product by id sync: {}", id);
        return ResponseEntity.ok(productSyncFacade.getProductDetails(id));
    }

    @GetMapping("/{id}/async")
    public ResponseEntity<ProductDetailDTO> getProductAsync(@PathVariable Long id) {
        log.info("Rest request to get product by id async: {}", id);
        return ResponseEntity.ok(productASyncFacade.getProductDetails(id));
    }
}
