package org.example;

import org.example.inputs.InputsProcessor;
import org.example.menu.Menu;

import java.util.List;

public class Shop {
    private final String name;
    private final List<Product> products;
    private final Menu menu;
    private final InputsProcessor inputsProcessor;
    private final ProductBasket productBasket;
    private final ProductFilter productFilter;

    public Shop(String name, List<Product> products, Menu menu, InputsProcessor inputsProcessor) {
        this.name = name;
        this.products = products;
        this.menu = menu;
        this.inputsProcessor = inputsProcessor;
        this.productBasket = new ProductBasket();
        this.productFilter = new ProductFilter();
    }

    public void addNewProduct(Product product) {
        if (products.contains(product)) {
            return;
        }
        products.add(product);
    }

    public String getName() {
        return name;
    }

    public void run() {
        menu.printMainMenu(name);
        while (true) {
            int userNum;

            userNum = inputsProcessor.readUserIntegerNumber();

            switch (userNum) {
                case 1:
                    printShopProducts();
                    break;
                case 2:
                    printFilterMenu();
                    break;
                case 3:
                    boolean isEndShopping = printProductBasket();
                    if (isEndShopping) {
                        return;
                    }
                    break;
                case 4: return;
            }
        }
    }

    private void printFilterMenu() {
        menu.printFilterMenu();
        int userNum = inputsProcessor.readUserIntegerNumber();
        switch (userNum) {
            case 1 -> {
                menu.printCustomMessage("Enter product name");
                String name = inputsProcessor.readUserText();
                List<Product> filteredProducts = productFilter.filterProductsByName(products, name);
                menu.printShopProducts(filteredProducts);
            }
            case 2 -> {
                menu.printCustomMessage("Enter product price");
                int price = inputsProcessor.readUserIntegerNumber();
                List<Product> filteredProducts = productFilter.filterProductsByPrice(products, price);
                menu.printShopProducts(filteredProducts);
            }
            case 3 -> {
                menu.printCustomMessage("Enter producer name");
                String name = inputsProcessor.readUserText();
                List<Product> filteredProducts = productFilter.filterProductsByProducer(products, name);
                menu.printShopProducts(filteredProducts);
            }
        }
        menu.printMainMenu(name);
    }

    private boolean printProductBasket() {
        menu.printProductBasket(productBasket);
        int userNum = inputsProcessor.readUserIntegerNumber();
        switch (userNum) {
            case 1 -> printMenuToAddProduct();
            case 2 -> menu.printMainMenu(name);
            case 3 -> {
                menu.printGoodBye();
                return true;
            }
        }
        return false;
    }

    private void printShopProducts() {
        menu.printShopProducts(products);
        int userNum = inputsProcessor.readUserIntegerNumber();
        switch (userNum) {
            case 1 -> printMenuToAddProduct();
            case 2 -> menu.printMainMenu(name);
        }
    }

    private void printMenuToAddProduct() {
        while(true) {
            int productNum;
            int productQuantity;
            String userText;

            menu.printMenuToAddProduct();

            userText = inputsProcessor.readUserText();
            if (userText.equals("end")) {
                printShopProducts();
                return;
            }
            productNum = parseUserIntegerFromText(userText);
            productQuantity = inputsProcessor.readUserIntegerNumber();

            if (productNum != 0 && productNum <= products.size() && productQuantity != 0) {
                productBasket.addProduct(products.get(productNum - 1), productQuantity);
            }
        }
    }

    private int parseUserIntegerFromText(String text) {
        return Integer.parseInt(text);
    }

}
