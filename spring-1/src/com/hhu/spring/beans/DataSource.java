package com.hhu.spring.beans;

import java.util.Properties;

/**
 * Created by WeiguoLiu on 2018/2/26.
 */
public class DataSource {
    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "com.hhu.spring.beans.DataSource{" +
                "properties=" + properties +
                '}';
    }
}
