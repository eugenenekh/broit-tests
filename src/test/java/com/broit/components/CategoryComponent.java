package com.broit.components;

import com.codeborne.selenide.SelenideElement;

public class CategoryComponent {
    private final SelenideElement element;

    public CategoryComponent(SelenideElement element) {
        this.element = element;
    }

    public String title() {
        return element.getText();
    }

    public void open() {
        element.click();
    }
}
