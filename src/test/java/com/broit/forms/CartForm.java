package com.broit.forms;

import com.broit.components.CartItemsComponent;
import com.broit.models.CartItem;
import com.codeborne.selenide.SelenideElement;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CartForm {
    private final static CartItemsComponent cartItemsCpt = new CartItemsComponent($$(".cart-item"));
    private final static SelenideElement proceedToCheckoutBtn = $("a[href$='order']");

    private CartForm() {}

    public static List<CartItem> items() {
        cartItemsCpt.waitUntilVisible();

        return cartItemsCpt.cartItems();
    }

    public static void proceedToCheckout() {
        proceedToCheckoutBtn.click();
    }
}
