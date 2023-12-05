package com.broit.models;

import java.util.Objects;

public record Product(String name) {

    public String titleForProductForm() {
        return name.toUpperCase();
    }

    // FIXME Product title is different in different pages. Need to clarify with devs.
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof Product product)) {
            return false;
        }

        return product.name.equalsIgnoreCase(this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name.toLowerCase());
    }
}
