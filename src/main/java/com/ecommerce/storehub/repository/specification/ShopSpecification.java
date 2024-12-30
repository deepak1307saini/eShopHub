package com.ecommerce.storehub.repository.specification;

import com.ecommerce.storehub.entity.Shop;
import jakarta.persistence.criteria.JoinType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
public class ShopSpecification extends BaseSpecification<Shop>{
    public static Specification<Shop> hasShopId(String shopId) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("shopId"), shopId));
    }

    public static Specification<Shop> fetchProductCategories() {
        return (root, query, criteriaBuilder) -> {
            root.fetch("productCategories", JoinType.LEFT);
            return criteriaBuilder.conjunction();
        };
    }
}
