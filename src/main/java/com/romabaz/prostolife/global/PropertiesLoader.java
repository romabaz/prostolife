package com.romabaz.prostolife.global;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by roman.loyko on 17-Oct-16.
 */
public class PropertiesLoader {
    private static Logger logger = LoggerFactory.getLogger(PropertiesLoader.class);

    public Properties load(String propFileName) {
        Properties prop = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {
            if (inputStream == null) {
                throw new IOException("Failed to open resource " + propFileName);
            }
            prop.load(inputStream);
        } catch (FileNotFoundException e) {
            logger.error("Resource {} not found", propFileName, e);
        } catch (IOException e) {
            logger.error("Failed to read {} file", propFileName, e);
        }
        return prop;
    }
}
