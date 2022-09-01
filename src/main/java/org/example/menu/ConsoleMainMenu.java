package org.example.menu;

import org.example.Product;
import org.example.ProductBasket;

import java.util.List;
import java.util.Map;

public class ConsoleMainMenu implements Menu {
    @Override
    public void printMainMenu(String shopName) {
        System.out.println("Welcome to shop: " + shopName);
        System.out.println("Please enter number of neccesary action from the list:");
        System.out.println("1. Show all shop products");
        System.out.println("2. Show shop products filtered by parameters");
        System.out.println("3. Go to basket");
        System.out.println();
    }

    @Override
    public void printFilterMenu() {
        System.out.println("You are now in filter menu");
        System.out.println("Please enter number of filter parameters from the list:");
        System.out.println("1. Filter by name");
        System.out.println("2. Filter by price");
        System.out.println("3. Filter by producer");
        System.out.println("4. Return to main menu");
    }

    @Override
    public void printMenuToAddProduct() {
        System.out.println("Please enter index of product and it's quantity OR 'end' to return to main menu:");
    }

    @Override
    public void printShopProducts(List<Product> products) {
        System.out.println("List of products:");
        for(int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).toString());
        }
        System.out.println();
    }

    @Override
    public void printGoodBye() {
        System.out.println("Now you can go to the cashbox and pay for product. Thank you!");
    }

    @Override
    public void printCustomMessage(String msg) {
        System.out.println(msg);
    }

    @Override
    public void printProductBasket(ProductBasket productBasket) {
        if (productBasket.isEmpty()) {
            System.out.println("Your basket is empty");
        } else {
            float totalCost = 0;
            System.out.println("Your basket contains of:");
            System.out.println("№  Product                                Quantity    Cost");
            Map<Product, Integer> products = productBasket.getProducts();
            var i = 0;
            for(Map.Entry<Product, Integer> product: products.entrySet()) {
                i++;
                float curCost = product.getKey().getPrice() * product.getValue();
                System.out.println(i + ". " + product.getKey().toString() + " x " +
                    product.getValue() + " =   " + curCost);
                totalCost += curCost;
            }
            System.out.println("Total cost = " + totalCost);
        }
        System.out.println();
        System.out.println("Please choose your action:");
        System.out.println("1. Add product to basket");
        System.out.println("2. Return to main menu");
        System.out.println("3. Pay on cashbox");
    }

    @Override
    public void printActions() {
        System.out.println("Please choose your action:");
        System.out.println("1. Add product to basket");
        System.out.println("2. Return to main menu");
    }
}
