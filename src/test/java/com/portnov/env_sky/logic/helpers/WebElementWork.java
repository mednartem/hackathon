package com.portnov.env_sky.logic.helpers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.Random;

public class WebElementWork {
    public static SelenideElement getRandomElementFromList(ElementsCollection collection) {
        return collection.get(new Random().nextInt(collection.size()));
    }
}
