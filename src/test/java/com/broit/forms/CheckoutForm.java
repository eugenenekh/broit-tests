package com.broit.forms;

import com.broit.components.CheckoutSummaryComponent;
import com.broit.models.CartItem;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class CheckoutForm {
    private static final CheckoutSummaryComponent checkoutSummaryCpt = new CheckoutSummaryComponent($("#js-checkout-summary"));

    private CheckoutForm() {}

    public static List<CartItem> items() {
        return checkoutSummaryCpt.cartItems();
    }
}
