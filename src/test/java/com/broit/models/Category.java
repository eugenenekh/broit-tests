package com.broit.models;

public record Category(String name) {

    public String titleForCategoryForm() {
        return name.toUpperCase();
    }
}
