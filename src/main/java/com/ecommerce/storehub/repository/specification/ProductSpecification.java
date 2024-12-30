package com.ecommerce.storehub.repository.specification;

import com.ecommerce.storehub.entity.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
public class ProductSpecification extends BaseSpecification<Product> {
    public static Specification<Product> hasProductId(String productId) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("productId"), productId));
    }
}
