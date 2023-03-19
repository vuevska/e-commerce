package com.example.eshopapplication.repository;

import com.example.eshopapplication.model.Product;
import com.example.eshopapplication.model.views.ProductsPerManufacturerView;
import com.example.eshopapplication.repository.views.ProductsPerManufacturerViewRepository;
import com.example.eshopapplication.service.CategoryService;
import com.example.eshopapplication.service.ManufacturerService;
import com.example.eshopapplication.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductsPerManufacturerViewRepositoryTest {

    @Autowired
    private ProductsPerManufacturerViewRepository productsPerManufacturerViewRepository;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ManufacturerService manufacturerService;

    @Autowired
    private ProductService productService;

    @Test
    public void testCreateNewProduct() {
        List<ProductsPerManufacturerView> list1 = this.productsPerManufacturerViewRepository.findAll();

        Product product = new Product();
        product.setName("Ski Jacket 2");
        product.setManufacturer(this.manufacturerService.findAll().get(0));
        product.setCategory(this.categoryService.listCategories().get(0));
        this.productService.save(product.getName(), product.getPrice(), product.getQuantity(), product.getCategory().getId(), product.getManufacturer().getId());

        List<ProductsPerManufacturerView> list2 = this.productsPerManufacturerViewRepository.findAll();

    }
}
