package com.portnov.env_sky.logic.data;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.UUID;

public class RandomData {
    public static final String PATTER_EMAIL = "_autotest@test.test";
    public static final String PATTER_DATA = "autotest ";

    public static String randomAlphabetic(final int symbolsCount) {
        return RandomStringUtils.randomAlphabetic(symbolsCount);
    }

    public static String generateUniqEmail() {
        return randomAlphabetic(15).concat(PATTER_EMAIL).toLowerCase();
    }

    public static String generatePassword() {
        return generateString(10);
    }
    public static UUID generateUUID() {
        return UUID.randomUUID();
    }

    public static String generateString(int count) {
        return randomAlphabetic(count);
    }

    private static String templateAutotestGenerate(String entity) {
        return PATTER_DATA + entity + ": " + randomAlphabetic(5);
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

    public static String generateNameProductAttribute() {
        return templateAutotestGenerate("product attribute");
    }

    public static String generateDescriptionProductAttribute() {
        return templateAutotestGenerate("description product attribute");
    }

    public static String generateNameCheckoutAttribute() {
        return templateAutotestGenerate("checkout attribute");
    }

    public static String generateDescriptionCheckoutAttribute() {
        return templateAutotestGenerate("description checkout attribute");
    }

    public static String generateFirstName() {
        return templateAutotestGenerate("first name");
    }

    public static String generateLastName() {
        return templateAutotestGenerate("last name");
    }

    public static String generateCompanyName() {
        return templateAutotestGenerate("company name");
    }
}
