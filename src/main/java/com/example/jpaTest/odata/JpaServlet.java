package com.example.jpaTest.odata;

import org.apache.olingo.odata2.core.servlet.ODataServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JpaServlet extends ODataServlet {

    private final transient ApplicationContext applicationContext;

    public JpaServlet(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    protected JpaServiceFactory getServiceFactory(HttpServletRequest request) {

        return applicationContext.getBean(JpaServiceFactory.class);
    }
}
