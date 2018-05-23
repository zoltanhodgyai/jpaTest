package com.example.jpaTest.odata;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaServletConfiguration {

    private final JpaServiceFactory jpaServiceFactory;

    public JpaServletConfiguration(JpaServiceFactory jpaServiceFactory) {
        this.jpaServiceFactory = jpaServiceFactory;
    }

    @Bean
    @SuppressWarnings("unchecked")
    public ServletRegistrationBean productServletJpa() {
        ServletRegistrationBean bean = new ServletRegistrationBean(new JpaServlet(jpaServiceFactory), "/JpaTest.svc/*");
        bean.setLoadOnStartup(1);
        return bean;
    }

}
