package com.romabaz.prostolife.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

/**
 * Created by roman.loyko on 13-Oct-16.
 */
public class CommentsDao extends ApplicationDao{
    private final Logger logger = LoggerFactory.getLogger(CommentsDao.class);

    public CommentsDao(DataSource dataSource) {
        super(dataSource);
    }
}
