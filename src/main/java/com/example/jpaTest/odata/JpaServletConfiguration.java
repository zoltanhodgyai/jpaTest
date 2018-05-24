package com.example.jpaTest.odata;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JpaServletConfiguration {

    @Bean
    @SuppressWarnings("unchecked")
    public ServletRegistrationBean productServletJpa(JpaServlet jpaServlet) {
        ServletRegistrationBean bean = new ServletRegistrationBean(jpaServlet, "/JpaTest.svc/*");
        bean.setLoadOnStartup(1);
        return bean;
    }

}
