package com.qa.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;

public final class PropertyUtils {

    public PropertyUtils() {

    }

    private static Properties properties = new Properties();
    private static Map<String, String> MAP = new HashMap<String, String>();

    static {

        try (FileInputStream fis = new FileInputStream("src/test/resources/config.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        properties.entrySet().forEach(e -> MAP.put(String.valueOf(e.getKey()), String.valueOf(e.getValue())));

    }

    public static String getValues(PropertyType key) {
        return MAP.get(key.name().toLowerCase());
    }
}
