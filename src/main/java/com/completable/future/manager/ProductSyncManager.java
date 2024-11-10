package com.completable.future.manager;


import com.completable.future.dto.ProductDetailDTO;
import com.completable.future.entity.Inventory;
import com.completable.future.entity.Price;
import com.completable.future.entity.Product;
import com.completable.future.service.InventoryService;
import com.completable.future.service.PriceService;
import com.completable.future.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductSyncManager {

    @Autowired
    private ProductService productService;
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private PriceService priceService;


    public ProductDetailDTO getProductDetails(long productId) {
        log.info("Sync product details for the product id {}",productId);
        Product product = productService.findById(productId);
        Price price = priceService.getPriceByProductId(productId);
        Inventory inventory = inventoryService.getInventoryByProductId(productId);
        return new ProductDetailDTO(productId, product.getCategory().getName(),
                product.getName(), product.getDescription(),
                inventory.getAvailableQuantity(), price.getPrice(),
                inventory.getStatus());
    }

}
