package com.romabaz.prostolife.servlet;

import com.romabaz.prostolife.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by roman.loyko on 14-Oct-16.
 */
@WebServlet(name="UsersServlet", urlPatterns = "/users")
public class UsersServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(UsersServlet.class);

    private UserService userService;

    @Override
    public void init() {
        userService = new UserService();
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) {
        userService.getAllUsers();
    }
}
