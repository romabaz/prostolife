package com.romabaz.prostolife.servlet;

import com.romabaz.prostolife.service.EntryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by roman.loyko on 18-Oct-16.
 */
@WebServlet(name="EntriesServlet", urlPatterns = "/entries")
public class EntriesServlet extends HttpServlet {
    private static final Logger logger = LoggerFactory.getLogger(EntriesServlet.class);

    private static EntryService obtainEntryService() {
        return new EntryService();
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
