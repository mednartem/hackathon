package com.portnov.env_sky.logic.helpers;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {

    public static String randomAlphabetic(final int symbolsCount) {
        return RandomStringUtils.randomAlphabetic(symbolsCount);
    }

    public static String generateUniqEmail() {
        return randomAlphabetic(15).concat("@test.test").toLowerCase();
    }

    public static String generatePassword() {
        return generateString(10);
    }

    public static String generateString(int count) {
        return randomAlphabetic(count);
    }

    public static String generateNameCategory() {
        return "autotest category: " + randomAlphabetic(5);
    }

    public static String generateDescriptionCategory() {
        return "autotest description category: " + randomAlphabetic(10);
    }

    public static String generateNameProduct() {
        return "autotest product: " + randomAlphabetic(5);
    }

    public static String generateDescriptionProduct() {
        return "autotest description product: " + randomAlphabetic(10);
    }
}
