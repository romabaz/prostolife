package com.romabaz.prostolife.global;

import com.romabaz.prostolife.dao.CommentsDao;
import com.romabaz.prostolife.dao.DaoException;
import com.romabaz.prostolife.dao.EntriesDao;
import com.romabaz.prostolife.dao.UsersDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by roman.loyko on 16-Oct-16.
 */
public class DatabaseFactory {
    private static Logger logger = LoggerFactory.getLogger(DatabaseFactory.class);

    private static DatabaseFactory instance;
    private static DataSource dataSource;

    private volatile UsersDao usersDao;
    private volatile EntriesDao entriesDao;
    private volatile CommentsDao commentsDao;

    private DatabaseFactory() throws DaoException {
        Properties properties = new PropertiesLoader().load(Constants.DB_PROP_FILE);
        String jndiName = properties.getProperty("db-jndi");
        try {
            dataSource = DatasourceInitializer.initDS(jndiName);
        } catch (DatasourceInitializer.InitializationException e) {
            logger.error("Failed to initialize datasource {}", jndiName, e);
            throw new DaoException("Failed to initialize datasource", e);
        }
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

    public UsersDao getUsersDao() {
        if (usersDao == null) {
            synchronized (this) {
                if (usersDao == null) {
                    usersDao = new UsersDao(dataSource);
                }
            }
        }
        return usersDao;
    }

    public EntriesDao getEntriesDao() {
        if (entriesDao == null) {
            synchronized (this) {
                if (entriesDao == null) {
                    entriesDao = new EntriesDao(dataSource);
                }
            }
        }
        return entriesDao;
    }

    public CommentsDao getCommentsDao() {
        if (commentsDao == null) {
            synchronized (this) {
                if (commentsDao == null) {
                    commentsDao = new CommentsDao(dataSource);
                }
            }
        }
        return commentsDao;
    }


}
