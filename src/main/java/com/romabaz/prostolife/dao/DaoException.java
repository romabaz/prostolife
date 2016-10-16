package com.romabaz.prostolife.dao;

/**
 * Created by roman.loyko on 15-Oct-16.
 */
public final class DaoException extends Exception {
    public DaoException(String s, Exception e) {
        super(s, e);
    }
}
