package com.broit.components;

import com.broit.models.CartItem;
import com.broit.models.Product;
import com.broit.utils.RegexUtils;
import com.codeborne.selenide.SelenideElement;

import java.util.function.Function;

import static com.codeborne.selenide.Condition.visible;

public class CheckoutItemComponent {
    private final SelenideElement element;

    private final Function<SelenideElement, SelenideElement> titleLnk = el -> el.$(".product-name");
    private final Function<SelenideElement, SelenideElement> quantityLbl = el -> el.$(".product-quantity");

    public CheckoutItemComponent(SelenideElement element) {
        this.element = element;
    }

    public CartItem cartItem() {
        var titleEl = titleLnk.apply(element);
        titleEl.shouldBe(visible);

        var title = titleEl.getText();
        var quantity = extractQuantity(quantityLbl.apply(element).getText());

        return new CartItem(new Product(title), quantity);
    }

    private int extractQuantity(String quantityStr) {
        return RegexUtils.getNumber(quantityStr).orElse(0);
    }
}
