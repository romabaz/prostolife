package com.romabaz.prostolife.configuration;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.romabaz.prostolife.service.UserService;

import java.util.ResourceBundle;

/**
 * Created by roman.loyko on 16-Oct-16.
 */
public class GuiceInitializer {
    private GuiceInitializer(){}

    public static UserService init() {
        ResourceBundle resources = ResourceBundle.getBundle("database");
        String jndiName = resources.getString("db-jndi");
        Injector injector = Guice.createInjector(new AppInjector(jndiName));
        return injector.getInstance(UserService.class);
    }
}
