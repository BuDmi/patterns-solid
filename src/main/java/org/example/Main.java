package org.example;

import org.example.inputs.ConsoleInputProcessor;
import org.example.inputs.InputsProcessor;
import org.example.menu.ConsoleMainMenu;
import org.example.menu.Menu;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producer> producers = getInitializedProducers();
        List<Product> products = getInitializedProducts(producers);

        Menu mainMenu = new ConsoleMainMenu();
        InputsProcessor inputsProcessor = new ConsoleInputProcessor();
        Shop shop = new Shop("Магнит", products, mainMenu, inputsProcessor);
        shop.run();
    }

    private static List<Product> getInitializedProducts(List<Producer> producers) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Конфеты", 6, producers.get(0)));
        products.add(new Product("Шоколад", 8, producers.get(0)));
        products.add(new Product("Хлопья", 14, producers.get(1)));
        products.add(new Product("Хлопья", 17, producers.get(2)));
        products.add(new Product("Чипсы", 50, producers.get(3)));
        return products;
    }

    private static List<Producer> getInitializedProducers() {
        List<Producer> producers = new ArrayList<>();
        producers.add(new Producer("Красный октябрь", Country.RUS));
        producers.add(new Producer("5 злаков", Country.RUS));
        producers.add(new Producer("Nestle", Country.USA));
        producers.add(new Producer("Duhast", Country.GER));
        return producers;
    }
}