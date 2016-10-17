package com.romabaz.prostolife.service;

import com.google.inject.Inject;
import com.romabaz.prostolife.dao.DaoException;
import com.romabaz.prostolife.dao.UsersDao;
import com.romabaz.prostolife.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roman.loyko on 16-Oct-16.
 */
public class UserService implements Service {
    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Inject
    private UsersDao usersDao;

    public List<User> getAllUsers() {
        try {
            if (usersDao != null) {
                return usersDao.getAllUsers();
            }
        } catch (DaoException e) {
            logger.error("Failed to get all users", e);
        }
        return new ArrayList<>();
    }
}
