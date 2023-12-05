package com.broit.components;

import com.broit.models.CartItem;
import com.broit.models.Product;
import com.codeborne.selenide.SelenideElement;

import java.util.Optional;
import java.util.function.Function;

public class CartItemComponent {
    private final SelenideElement element;

    private final Function<SelenideElement, SelenideElement> productLbl = el -> el.$(".product-line-info");
    private final Function<SelenideElement, SelenideElement> quantityFld = el -> el.$("input[class*='quantity']");

    public CartItemComponent(SelenideElement element) {
        this.element = element;
    }

    public CartItem cartItem() {
        var product = new Product(productLbl.apply(element).getText());
        var quantity = Optional.ofNullable(quantityFld.apply(element).getValue()).map(Integer::parseInt).orElse(0);
        return new CartItem(product, quantity);
    }
}
