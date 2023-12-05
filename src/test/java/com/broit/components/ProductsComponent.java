package com.broit.components;

import com.broit.utils.RandomUtils;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;

public class ProductsComponent {
    private final ElementsCollection elements;

    public ProductsComponent(ElementsCollection elements)
    {
        this.elements = elements;
    }

    public ProductComponent random() {
        return new ProductComponent(RandomUtils.fromIterable(elements));
    }

    public void waitUntilVisible() {
        elements.shouldHave(sizeGreaterThan(0));
    }
}
