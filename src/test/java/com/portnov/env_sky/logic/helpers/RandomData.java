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

    private static String templateAutotestGenerate(String entity) {
        return "autotest " + entity + ": " + randomAlphabetic(5);
    }

    public static String generateNameCategory() {
        return templateAutotestGenerate("category");
    }

    public static String generateDescriptionCategory() {
        return templateAutotestGenerate("description category");
    }

    public static String generateNameProduct() {
        return templateAutotestGenerate("product");
    }

    public static String generateDescriptionProduct() {
        return templateAutotestGenerate("description product");
    }

    public static String generateNameManufacturer() {
        return templateAutotestGenerate("manufacturer");
    }

    public static String generateDescriptionManufacturer() {
        return templateAutotestGenerate("description manufacturer");
    }
}
