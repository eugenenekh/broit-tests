package com.broit.components;

import com.broit.utils.RandomUtils;
import com.codeborne.selenide.ElementsCollection;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.visible;

public class CategoriesComponent {
    private final ElementsCollection elements;

    public CategoriesComponent(ElementsCollection elements)
    {
        this.elements = elements;
    }

    public CategoryComponent randomVisible() {
        return new CategoryComponent(RandomUtils.fromIterable(elements.filter(visible)));
    }

    public void waitUntilVisible() {
        elements.shouldHave(sizeGreaterThan(0), Duration.ofMillis(10000));
    }
}
