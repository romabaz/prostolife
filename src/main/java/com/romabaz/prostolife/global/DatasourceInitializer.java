package com.romabaz.prostolife.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by roman.loyko on 17-Oct-16.
 */
public final class DatasourceInitializer {
    private static Logger logger = LoggerFactory.getLogger(DatasourceInitializer.class);

    public static final class InitializationException extends Exception {
        public InitializationException(String msg, Exception exc) {
            super(msg, exc);
        }
    }

    private DatasourceInitializer(){
    }

    public static DataSource initDS(String jndiName) throws InitializationException {
        logger.debug("Initializing datasource {}", jndiName);
        try {
            Context ctx = new InitialContext();
            return (DataSource) ctx.lookup("java:comp/env/" + jndiName);
        } catch (NamingException e) {
            logger.error("Error initializing datasource {}", jndiName, e);
            throw new InitializationException("Error initializing datasource", e);
        }
    }
}
