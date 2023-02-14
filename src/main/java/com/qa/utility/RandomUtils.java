package com.qa.utility;

public class RandomUtils {

    public void RandomUtils() {

    }

    public static int getId() {
        return FakerUtils.getNumber(1, 3000);
    }

    public static String getCity() {
        return FakerUtils.getCity();
    }

    public static String getFirstName() {
        return FakerUtils.getFirstName();
    }

    public static String getLastName() {
        return FakerUtils.getLastName();
    }
}
