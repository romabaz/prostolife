package com.romabaz.prostolife.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.romabaz.prostolife.service.Service;
import com.romabaz.prostolife.service.UserService;
import com.romabaz.prostolife.servlet.UsersServlet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import static com.google.inject.jndi.JndiIntegration.fromJndi;

/**
 * Created by roman.loyko on 16-Oct-16.
 */
public class AppInjector extends AbstractModule {
    private String jndiName;

    public AppInjector(String jndiName) {
        super();
        this.jndiName = jndiName;
    }

    @Override
    protected void configure() {
        bind(Context.class).to(InitialContext.class);
        bind(DataSource.class).toProvider(fromJndi(DataSource.class, "java:comp/env/" + jndiName)).in(Singleton.class);
        bind(Service.class).to(UserService.class).in(Singleton.class);
        bind(HttpServlet.class).to(UsersServlet.class).in(Singleton.class);
    }
}
