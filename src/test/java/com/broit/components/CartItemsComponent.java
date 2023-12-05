package com.broit.components;

import com.broit.models.CartItem;
import com.codeborne.selenide.ElementsCollection;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;

public class CartItemsComponent {
    private final ElementsCollection elements;

    public CartItemsComponent(ElementsCollection elements)
    {
        this.elements = elements;
    }

    public List<CartItem> cartItems() {
        return elements.asFixedIterable().stream()
            .map(c -> new CartItemComponent(c).cartItem())
            .collect(Collectors.toList());
    }

    public void waitUntilVisible() {
        elements.shouldHave(sizeGreaterThan(0));
    }
}
