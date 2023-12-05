package com.broit.forms;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.broit.models.CartItem;
import com.broit.models.Product;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

public class ProductForm {
    private final static SelenideElement titleLbl = $("h1");
    private final static SelenideElement quantityFld = $("#quantity_wanted");
    private final static SelenideElement addToCartBtn = $(".add-to-cart");

    private ProductForm() {}

    public static CartItem addToCart(Product product) {
        return addToCart(product, 1);
    }

    public static CartItem addToCart(Product product, int quantity) {
        quantityFld.shouldBe(visible);

        fillQuantity(quantity);
        addToCartBtn.click();
        AddedToCartForm.waitForProductAdded();

        return new CartItem(product, quantity);
    }

    private static void fillQuantity(int quantity) {
        quantityFld.doubleClick();
        quantityFld.sendKeys(Keys.BACK_SPACE);
        quantityFld.setValue(Integer.toString(quantity));
    }

    public static void waitForProductOpened(Product product) {
        titleLbl.shouldHave(text(product.titleForProductForm()));
    }
}
