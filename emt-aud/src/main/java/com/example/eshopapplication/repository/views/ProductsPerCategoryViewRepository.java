package com.example.eshopapplication.repository.views;

import com.example.eshopapplication.model.views.ProductsPerCategoryView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductsPerCategoryViewRepository extends JpaRepository<ProductsPerCategoryView, Long> {
}
