package com.example.jpaTest.odata;

import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

@Component
public class JpaServiceFactory extends ODataJPAServiceFactory {

    private static final String PERSISTENCE_UNIT_NAME = "jpaTest";

    private final EntityManagerFactory entityManagerFactory;

    public JpaServiceFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public ODataJPAContext initializeODataJPAContext() throws ODataJPARuntimeException {
        ODataJPAContext oDataJPAContext = this.getODataJPAContext();
        try {
            oDataJPAContext.setEntityManagerFactory(entityManagerFactory);
            oDataJPAContext.setPersistenceUnitName(PERSISTENCE_UNIT_NAME);
//            setJPAEdmExtension
            return oDataJPAContext;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
