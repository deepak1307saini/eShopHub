package com.ecommerce.storehub.config;

import com.ecommerce.storehub.util.Constants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@AllArgsConstructor
@Slf4j
public class JPAConfig {

    private final SQLLoggingInspector sqlLoggingInspector;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource){
        Properties properties = new Properties();

        /// Hibernate configuration
        properties.setProperty(Constants.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Constants.SHOW_SQL, "false");
        properties.put(Constants.SESSION_INSPECTOR, sqlLoggingInspector);
        properties.setProperty("hibernate.format_sql", "false");
        properties.setProperty("hibernate.default_batch_fetch_size", "100");


        return new LocalContainerEntityManagerFactoryBean(){{
            setDataSource(dataSource);
            setPackagesToScan(Constants.ENTITY_PKG);
            HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
            setJpaVendorAdapter(vendorAdapter);
            setJpaProperties(properties);
            setEntityManagerFactoryInterface(jakarta.persistence.EntityManagerFactory.class);
        }};
    }
}
