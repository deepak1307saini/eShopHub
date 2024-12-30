package com.ecommerce.storehub.repository.specification;

import com.ecommerce.storehub.entity.User;
import jakarta.persistence.criteria.JoinType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.domain.Specification;

@Slf4j
public class AdminSpecification extends BaseSpecification<User> {

    public static Specification<User> hasUserId(String userId) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("userId"), userId));
    }

    public static Specification<User> hasUserName(String userName) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("username"), userName));
    }


    public static Specification<User> fetchUserAddresses() {
        return (root, query, criteriaBuilder) -> {
            root.fetch("addresses", JoinType.LEFT);
            return criteriaBuilder.conjunction();
        };
    }
}
