package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class ProductFilter {
    ProductFilter() {}

    public List<Product> filterProductsByName(List<Product> products, String name) {
        return products.stream().filter(product -> name.equals(product.getName())).collect(Collectors.toList());
    }

    public List<Product> filterProductsByPrice(List<Product> products, int price) {
        return products.stream().filter(product -> price == product.getPrice()).collect(Collectors.toList());
    }

    public List<Product> filterProductsByProducer(List<Product> products, String producerName) {
        return products.stream().filter(product -> producerName.equals(product.getProducer().getName()))
            .collect(Collectors.toList());
    }
}
