package com.ecommerce.storehub.repository.specification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
public class BaseSpecification<T> {
    public static <T> Specification<T> hasAttribute(String attribute, Object value) {
        return (root, query, cb) -> cb.equal(root.get(attribute), value);
    }

    public static <T> Specification<T> isDeleted(Boolean deleted) {
        return (root, query, cb) -> cb.equal(root.get("deleted"), deleted);
    }

    public static <T> Specification<T> isNotDeleted() {
        return isDeleted(false);
    }
}
