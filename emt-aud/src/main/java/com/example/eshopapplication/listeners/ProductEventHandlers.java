package com.example.eshopapplication.listeners;

import com.example.eshopapplication.model.events.ProductCreatedEvent;
import com.example.eshopapplication.service.ProductService;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProductEventHandlers {

    private final ProductService productService;

    public ProductEventHandlers(ProductService productService) {
        this.productService = productService;
    }

    @EventListener
    public void onProductCreated(ProductCreatedEvent event) {
        this.productService.refreshMaterializedView();
    }
}
