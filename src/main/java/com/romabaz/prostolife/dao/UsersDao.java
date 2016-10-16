package com.romabaz.prostolife.dao;

import com.romabaz.prostolife.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roman.loyko on 13-Oct-16.
 */
public class UsersDao extends AbstractDao {
    private final Logger log = LoggerFactory.getLogger(UsersDao.class);

    public List<User> getAllUsers() throws DaoException {
        final List<User> users = new ArrayList<>();
        ResultSet rs = null;
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "select Username, Email from Users";
            rs = statement.executeQuery(sql);
            String username;
            String email;
            User user;
            while (rs.next()) {
                username = rs.getString("Username");
                email = rs.getString("Email");
                log.debug(String.format("User: %-15s %s", username, email));
                user = new User();
                user.setUsername(username);
                user.setEmail(email);
                users.add(user);
            }
        } catch (SQLException e) {
            log.error("Error retrieving users", e);
            throw new DaoException("Error retrieving users", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    log.error("Error closing result set", e);
                }
            }
        }
        return users;
    }

}
