package com.romabaz.prostolife.service;

import com.romabaz.prostolife.dao.DaoException;
import com.romabaz.prostolife.dao.UsersDao;
import com.romabaz.prostolife.global.DatabaseFactory;
import com.romabaz.prostolife.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roman.loyko on 16-Oct-16.
 */
public class UserService {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UsersDao obtainUsersDao() {
        try {
            return DatabaseFactory.getInstance().getUsersDao();
        } catch (DaoException e) {
            logger.error("Failed to obtain usersDao instance", e);
        }
        return null;
    }

    public List<User> getAllUsers() {
        UsersDao usersDao = obtainUsersDao();
        try {
            if (usersDao != null) {
                return usersDao.getAllUsers();
            } else {
                logger.error("Users Dao is null. No database access");
            }
        } catch (DaoException e) {
            logger.error("Failed to get all users", e);
        }
        return new ArrayList<>();
    }
}
