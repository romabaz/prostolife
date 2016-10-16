package com.romabaz.prostolife.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.ResourceBundle;

/**
 * Created by roman.loyko on 16-Oct-16.
 */
public class DatabaseFactory {

    private static Logger logger = LoggerFactory.getLogger(DatabaseFactory.class);

    private static DatabaseFactory instance;
    private static DataSource dataSource;

    private DatabaseFactory() throws DaoException {
        ResourceBundle resources = ResourceBundle.getBundle("database");
        String jndiName = resources.getString("db-jndi");

        initDataSource(jndiName);
    }

    private static void initDataSource(String jndiName) throws DaoException {
        logger.debug("Initializing datasource {}", jndiName);
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/" + jndiName);
        } catch (NamingException e) {
            logger.error("Error initializing datasource {}", jndiName, e);
            throw new DaoException("Error initializing datasource", e);
        }
        logger.debug("Datasource initialized: {}", jndiName);
    }

    public static DatabaseFactory getInstance() throws DaoException {
        if (instance == null) {
            synchronized (DatabaseFactory.class) {
                if (instance == null) {
                    instance = new DatabaseFactory();
                }
            }
        }
        return instance;
    }

    public DataSource getDataSource() {
        return dataSource;
    }


}
