package com.ecommerce.storehub.repository;

import com.ecommerce.storehub.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory, String>, JpaSpecificationExecutor<ProductCategory> {
}
