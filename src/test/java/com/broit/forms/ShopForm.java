package com.broit.forms;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

import com.codeborne.selenide.SelenideElement;

public class ShopForm {
    private static final SelenideElement shopIFrame = $(byId("framelive"));

    private ShopForm() {}

    public static void switchToShop() {
        shopIFrame.shouldBe(visible);
        switchTo().frame(shopIFrame);
    }
}
