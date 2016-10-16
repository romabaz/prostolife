package com.romabaz.prostolife.listener;

import com.romabaz.prostolife.configuration.GuiceInitializer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by roman.loyko on 16-Oct-16.
 */
@WebListener
public class ProstolifeServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        GuiceInitializer.init();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
