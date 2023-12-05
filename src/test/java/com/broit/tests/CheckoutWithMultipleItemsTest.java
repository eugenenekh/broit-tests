package com.broit.tests;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.broit.forms.*;
import com.broit.models.CartItem;
import org.junit.jupiter.api.Test;

import com.broit.forms.CategoryForm;

import java.util.ArrayList;

public class CheckoutWithMultipleItemsTest extends BaseTest {

    @Test
    public void checkoutWithMultipleSameItemsInCart() {
        var addedItems = new ArrayList<CartItem>();

        HeaderForm.openRandomVisibleCategory();
        var product = CategoryForm.openRandomProduct();
        var cartItem = ProductForm.addToCart(product, 2);
        addedItems.add(cartItem);

        AddedToCartForm.proceedToCheckout();

        assertArrayEquals(addedItems.toArray(), CartForm.items().toArray());

        CartForm.proceedToCheckout();

        assertArrayEquals(addedItems.toArray(), CheckoutForm.items().toArray());
    }

    @Test
    public void checkoutWithDifferentItemsInCart() {
        var addedItems = new ArrayList<CartItem>();

        HeaderForm.openRandomVisibleCategory();
        var product = CategoryForm.openRandomProduct();
        var cartItem = ProductForm.addToCart(product);
        addedItems.add(cartItem);

        AddedToCartForm.continueShopping();

        HeaderForm.openRandomVisibleCategory();
        var product2 = CategoryForm.openRandomProductExcept(product);
        var cartItem2 = ProductForm.addToCart(product2);
        addedItems.add(cartItem2);

        AddedToCartForm.proceedToCheckout();

        assertArrayEquals(addedItems.toArray(), CartForm.items().toArray());

        CartForm.proceedToCheckout();

        assertArrayEquals(addedItems.toArray(), CheckoutForm.items().toArray());
    }
}
