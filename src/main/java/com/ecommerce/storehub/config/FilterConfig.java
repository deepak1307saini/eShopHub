package com.ecommerce.storehub.config;

import com.ecommerce.storehub.security.JwtAuthenticationFilter;
import com.ecommerce.storehub.security.JwtTokenUtil;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<JwtAuthenticationFilter> jwtAuthenticationFilter() {
        FilterRegistrationBean<JwtAuthenticationFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtAuthenticationFilter(new JwtTokenUtil()));  // Pass required dependencies
        registrationBean.addUrlPatterns("/admin/*", "/user/*");  // Define the URL patterns where this filter applies
        return registrationBean;
    }
}

