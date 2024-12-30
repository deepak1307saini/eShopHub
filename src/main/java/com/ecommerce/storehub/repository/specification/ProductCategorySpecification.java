package com.ecommerce.storehub.repository.specification;

import com.ecommerce.storehub.entity.ProductCategory;
import jakarta.persistence.criteria.JoinType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
public class ProductCategorySpecification extends BaseSpecification<ProductCategory> {
    public static Specification<ProductCategory> hasProductCategoryId(String productCategoryId) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("productCategoryId"), productCategoryId));
    }

    public static Specification<ProductCategory> fetchProducts() {
        return (root, query, criteriaBuilder) -> {
            root.fetch("productCategories", JoinType.LEFT);
            return criteriaBuilder.conjunction();
        };
    }
}
