package com.broit.forms;

import com.broit.components.CategoriesComponent;
import com.broit.models.Category;

import static com.codeborne.selenide.Selenide.$$;

public class HeaderForm {
    private final static CategoriesComponent visibleCategories = new CategoriesComponent($$(".category"));

    private HeaderForm() {}

    public static void openRandomVisibleCategory() {
        visibleCategories.waitUntilVisible();

        var visibleCategory = visibleCategories.randomVisible();
        var category = new Category(visibleCategory.title());
        visibleCategory.open();
        CategoryForm.waitForCategoryOpened(category);
    }
}
