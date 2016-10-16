package com.romabaz.prostolife.dao;

import com.google.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by roman.loyko on 13-Oct-16.
 */
public abstract class ApplicationDao {
    private final Logger logger = LoggerFactory.getLogger(ApplicationDao.class);

    @Inject
    protected DataSource dataSource;

    protected Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(true);
        logger.debug("Connection retrieved successfully");
        return connection;
    }

}
