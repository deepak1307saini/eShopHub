package com.ecommerce.storehub.config;

import lombok.extern.slf4j.Slf4j;
import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SQLLoggingInspector implements StatementInspector {

    @Override
    public String inspect(String sql) {
        log.debug("SQL: {}", sql);
        return sql;
    }
}
