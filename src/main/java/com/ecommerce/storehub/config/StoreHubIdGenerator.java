package com.ecommerce.storehub.config;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.UUID;

@Component
public class StoreHubIdGenerator implements IdentifierGenerator {
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 26);
    }

    public static String generateId() {
        return UUID.randomUUID().toString().replace("-", "").substring(0, 26);
    }
}
