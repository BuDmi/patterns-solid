package org.example;

import java.util.HashMap;
import java.util.Map;

public class ProductBasket {
    private final Map<Product, Integer> productsMap;

    ProductBasket() {
        this.productsMap = new HashMap<>();
    }

    public void addProduct(Product product, int count) {
        Integer productCount = productsMap.get(product);
        if (productCount == null) {
            productCount = count;
        } else {
            productCount += count;
        }
        productsMap.put(product, productCount);
    }

    public void removeProduct(Product product, int count) {
        Integer productCount = productsMap.get(product);
        if (productCount == null) {
            return;
        } else {
            productCount -= count;
        }
        if (count <= 0) {
            productsMap.remove(product);
        } else {
            productsMap.put(product, productCount);
        }
    }

    public Boolean isEmpty() {
        return productsMap.isEmpty();
    }

    public Map<Product, Integer> getProducts() {
        return productsMap;
    }
}
