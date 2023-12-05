package com.broit.components;

import com.broit.models.CartItem;
import com.codeborne.selenide.ElementsCollection;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutItemsComponent {
    private final ElementsCollection elements;

    public CheckoutItemsComponent(ElementsCollection elements)
    {
        this.elements = elements;
    }

    public List<CartItem> cartItems() {
        return elements.asFixedIterable().stream()
            .map(c -> new CheckoutItemComponent(c).cartItem())
            .collect(Collectors.toList());
    }
}
