package com.romabaz.prostolife.servlet;

import com.romabaz.prostolife.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by roman.loyko on 14-Oct-16.
 */
public class UsersServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(UsersServlet.class);

    private UserService obtainUserService() {
        return new UserService();
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) {
        logger.debug("Incoming request from {}", request.getRequestURI());
        obtainUserService().getAllUsers();
    }
}