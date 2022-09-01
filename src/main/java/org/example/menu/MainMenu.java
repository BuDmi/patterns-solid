package org.example.menu;

import org.example.Product;

import java.util.List;

public interface MainMenu {
    void printMainMenu(String shopName);
    void printShopProducts(List<Product> products);
    void printGoodBye();
    void printCustomMessage(String msg);
}
