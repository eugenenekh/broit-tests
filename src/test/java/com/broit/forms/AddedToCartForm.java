package com.broit.forms;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;

// FIXME Looks like this is just a modal that might appear in different places as well. Need to clarify with devs.
public class AddedToCartForm {
    private static final SelenideElement productAddedLbl = $("#myModalLabel");
    // FIXME If we do not use components locators will look like this, which is ok if form is small enough.
    private static final SelenideElement proceedToCheckoutBtn = $(".cart-content-btn").$("[href$='cart?action=show']");
    private static final SelenideElement continueShoppingBtn = $(".cart-content-btn").$("[data-dismiss]");

    private AddedToCartForm() {}

    public static void waitForProductAdded() {
        productAddedLbl.shouldBe(visible);
    }

    public static void proceedToCheckout() {
        proceedToCheckoutBtn.click();
    }

    public static void continueShopping() {
        continueShoppingBtn.click();
    }
}
