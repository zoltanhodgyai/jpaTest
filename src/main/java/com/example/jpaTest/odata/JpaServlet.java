package com.example.jpaTest.odata;

import org.apache.olingo.odata2.core.servlet.ODataServlet;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JpaServlet extends ODataServlet {

    private final JpaServiceFactory jpaServiceFactory;

    public JpaServlet(JpaServiceFactory productCategoryServiceFactory) {
        this.jpaServiceFactory = productCategoryServiceFactory;
    }

    @Override
    protected JpaServiceFactory getServiceFactory(HttpServletRequest request) {

        return jpaServiceFactory;
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException {

        req.setAttribute(JpaServiceFactory.FACTORY_INSTANCE_LABEL, jpaServiceFactory);
        super.service(req, res);
    }


}
