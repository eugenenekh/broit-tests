package com.broit.components;

import com.broit.constants.Attributes;
import com.codeborne.selenide.SelenideElement;

import java.util.Optional;
import java.util.function.Function;

public class ProductComponent {
    private final SelenideElement element;

    private final Function<SelenideElement, SelenideElement> image = el -> el.$("img");
    private final Function<SelenideElement, SelenideElement> titleLbl = el -> el.$(".product-title");

    public ProductComponent(SelenideElement element) {
        this.element = element;
    }

    // FIXME need to discuss when text is actually trimmed with devs.
    public String title() {
        String title = titleLbl.apply(element).getText();
        return title.endsWith("...")
            ? Optional.ofNullable(image.apply(element).getAttribute(Attributes.ALT)).orElse("")
            : title;
    }

    public void open() {
        element.click();
    }
}
