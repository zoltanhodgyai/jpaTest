package com.example.jpaTest.odata;

import lombok.extern.slf4j.Slf4j;
import org.apache.olingo.odata2.api.ODataCallback;
import org.apache.olingo.odata2.api.ODataDebugCallback;
import org.apache.olingo.odata2.api.commons.HttpStatusCodes;
import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.exception.ODataApplicationException;
import org.apache.olingo.odata2.api.processor.ODataErrorCallback;
import org.apache.olingo.odata2.api.processor.ODataErrorContext;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAContext;
import org.apache.olingo.odata2.jpa.processor.api.ODataJPAServiceFactory;
import org.apache.olingo.odata2.jpa.processor.api.exception.ODataJPARuntimeException;
import org.apache.olingo.odata2.jpa.processor.api.model.JPAEdmExtension;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;
import javax.validation.constraints.Null;

@Component
@Slf4j
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
            oDataJPAContext.setJPAEdmExtension(new JpaExtension());
            return oDataJPAContext;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T extends ODataCallback> T getCallback(Class<T> callbackInterface) {

        return (T) (callbackInterface.isAssignableFrom(ScenarioErrorCallback.class) ? new ScenarioErrorCallback()
                : callbackInterface.isAssignableFrom(ODataDebugCallback.class) ? new ScenarioDebugCallback()
                : super.getCallback(callbackInterface));

    }

    private final class ScenarioDebugCallback implements ODataDebugCallback {

        @Override
        public boolean isDebugEnabled() {
            return true;
        }
    }

    private class ScenarioErrorCallback implements ODataErrorCallback {

        @Override
        public ODataResponse handleError(final ODataErrorContext context) throws ODataApplicationException {
            if (context.getHttpStatus() == HttpStatusCodes.INTERNAL_SERVER_ERROR) {
                log.error("Internal Server Error: " + context.getException().toString());
            }

            return EntityProvider.writeErrorDocument(context);
        }
    }
}
