package com.romabaz.prostolife.servlet;

import com.romabaz.prostolife.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by roman.loyko on 10/18/2016.
 */
public class CommentsServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(CommentsServlet.class);

    private static CommentService obtainEntryService() {
        return new CommentService();
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) {
        logger.debug("Incoming request from {}", request.getRequestURI());
        logger.debug("Context path: {}", request.getContextPath());
        logger.debug("Servlet path: {}", request.getServletPath());
        logger.debug("Path info: {}", request.getPathInfo());

    }

}
