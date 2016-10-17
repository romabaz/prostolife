package com.romabaz.prostolife.dao;

import com.romabaz.prostolife.model.Entry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roman.loyko on 13-Oct-16.
 */
public class EntriesDao extends ApplicationDao {
    private final Logger logger = LoggerFactory.getLogger(EntriesDao.class);

    public EntriesDao(DataSource dataSource) {
        super(dataSource);
    }

    public List<Entry> getAllEntries() throws DaoException {
        final List<Entry> entries = new ArrayList<>();
        ResultSet rs = null;
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            String sql = "select topic, text from Entries";
            rs = statement.executeQuery(sql);
            String topic;
            String text;
            Entry entry;
            while (rs.next()) {
                topic = rs.getString("Topic");
                text = rs.getString("Text");
                logger.debug(String.format("User: %-15s %s", topic, text));
                entry = new Entry();
                entry.setTopic(topic);
                entry.setText(text);
                entries.add(entry);
            }
        } catch (SQLException e) {
            logger.error("Error retrieving blog entries", e);
            throw new DaoException("Error retrieving blog entries", e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    logger.error("Error closing result set", e);
                }
            }
        }
        return entries;
    }

}
