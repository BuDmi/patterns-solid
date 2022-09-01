package org.example;

import java.util.Objects;

public class Product {
    private final float price;
    private final String name;
    private final Producer producer;

    Product(String name, float price, Producer producer) {
        this.name = name;
        this.price = price;
        this.producer = producer;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public Producer getProducer() {
        return producer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(product.price, price) == 0 && name.equals(product.name) && producer.equals(product.producer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name, producer);
    }

    @Override
    public String toString() {
        return name + ", " + producer.toString() + ", " + price + ".руб";
    }
}
