package com.romabaz.prostolife.dao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by roman.loyko on 13-Oct-16.
 */
public abstract class ApplicationDao {

    protected DataSource dataSource;

    public ApplicationDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected Connection getConnection() throws SQLException {
        Connection connection = dataSource.getConnection();
        connection.setAutoCommit(true);
        return connection;
    }

}
