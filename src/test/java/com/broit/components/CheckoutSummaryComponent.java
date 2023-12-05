package com.broit.components;

import com.broit.constants.Attributes;
import com.broit.models.CartItem;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.function.Function;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;

public class CheckoutSummaryComponent {
    private final SelenideElement element;

    private final Function<SelenideElement, CheckoutItemsComponent> checkoutItemsComponent = el -> new CheckoutItemsComponent(el.$$(".media"));
    private final Function<SelenideElement, SelenideElement> showDetailsTgl = el -> el.$(".js-show-details");

    public CheckoutSummaryComponent(SelenideElement element) {
        this.element = element;
    }

    public List<CartItem> cartItems() {
        expandDetails();

        return checkoutItemsComponent.apply(element).cartItems();
    }

    private void expandDetails() {
        var showDetails = showDetailsTgl.apply(element);
        showDetails.shouldBe(visible);

        if (Boolean.parseBoolean(showDetails.getAttribute(Attributes.ARIA_EXPANDED))) {
            return;
        }

        showDetails.click();
        showDetails.shouldHave(attribute(Attributes.ARIA_EXPANDED, "true"));
    }
}
