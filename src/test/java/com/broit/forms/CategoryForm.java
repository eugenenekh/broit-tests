package com.broit.forms;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.broit.components.ProductsComponent;
import com.broit.models.Category;
import com.broit.models.Product;
import com.codeborne.selenide.SelenideElement;

public class CategoryForm {
    private final static SelenideElement titleLbl = $("h1");
    private final static ProductsComponent products = new ProductsComponent($$(".product"));

    private CategoryForm() {}

    public static Product openRandomProduct() {
        products.waitUntilVisible();

        var randomProduct = products.random();
        var product = new Product(randomProduct.title());
        randomProduct.open();
        ProductForm.waitForProductOpened(product);
        return product;
    }

    public static Product openRandomProductExcept(Product productToAvoid) {
        products.waitUntilVisible();

        int attempts = 5;
        while (attempts > 0) {
            var randomProduct = products.random();
            var product = new Product(randomProduct.title());

            if (product.equals(productToAvoid)) {
                attempts--;
                continue;
            }
            randomProduct.open();
            ProductForm.waitForProductOpened(product);
            return product;
        }

        throw new RuntimeException("Could not gen unique product in '%s' attempts".formatted(attempts));
    }

    public static void waitForCategoryOpened(Category category) {
        titleLbl.shouldHave(text(category.titleForCategoryForm()));
    }
}
