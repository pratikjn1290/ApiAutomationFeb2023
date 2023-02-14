package com.qa.utility;

import com.github.javafaker.Faker;

import java.util.Locale;

public final class FakerUtils {

    public static Faker faker = new Faker();

    static int getNumber(int startValue, int endValue) {
        return faker.number().numberBetween(startValue, endValue);
    }

    static String getCity() {
        return faker.address().city();
    }

    static String getFirstName() {
        return faker.name().firstName().toLowerCase();
    }

    static String getLastName() {
        return faker.name().lastName().toLowerCase();

    }

}
