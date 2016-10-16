package com.romabaz.prostolife.configuration;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;

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
        bind(DataSource.class).toProvider(fromJndi(DataSource.class, "java:comp/env/" + jndiName)).in(Singleton.class);
    }
}
