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
    final int SHOW_ALL_SHOP_PRODUCT = 1;
    final int SHOW_FILTERED_PRODUCTS = 2;
    final int SHOW_BASKET = 3;
    final int END_SHOPPING = 4;
    public void run() {

        menu.printMainMenu(name);
        while (true) {
            int userNum;
            userNum = inputsProcessor.readUserIntegerNumber();

            switch (userNum) {
                case SHOW_ALL_SHOP_PRODUCT:
                    printShopProducts();
                    break;
                case SHOW_FILTERED_PRODUCTS:
                    printFilterMenu();
                    break;
                case SHOW_BASKET:
                    boolean isEndShopping = printProductBasket();
                    if (isEndShopping) {
                        return;
                    }
                    break;
                case END_SHOPPING: return;
            }
        }
    }
    final int FILTER_BY_PRODUCT_NAME = 1;
    final int FILTER_BY_PRODUCT_PRICE = 2;
    final int FILTER_BY_PRODUCER_NAME = 3;
    private void printFilterMenu() {
        menu.printFilterMenu();
        int userNum = inputsProcessor.readUserIntegerNumber();
        switch (userNum) {
            case FILTER_BY_PRODUCT_NAME -> {
                menu.printCustomMessage("Enter product name");
                String name = inputsProcessor.readUserText();
                List<Product> filteredProducts = productFilter.filterProductsByName(products, name);
                menu.printShopProducts(filteredProducts);
            }
            case FILTER_BY_PRODUCT_PRICE -> {
                menu.printCustomMessage("Enter product price");
                float price = inputsProcessor.readUserFloatNumber();
                List<Product> filteredProducts = productFilter.filterProductsByPrice(products, price);
                menu.printShopProducts(filteredProducts);
            }
            case FILTER_BY_PRODUCER_NAME -> {
                menu.printCustomMessage("Enter producer name");
                String name = inputsProcessor.readUserText();
                List<Product> filteredProducts = productFilter.filterProductsByProducer(products, name);
                menu.printShopProducts(filteredProducts);
            }
        }
        menu.printMainMenu(name);
    }
    final int BASKET_ADD_PRODUCT = 1;
    final int BASKET_GO_TO_MAIN_MENU = 2;
    final int BASKET_END_SHOPPING = 3;
    private boolean printProductBasket() {
        menu.printProductBasket(productBasket);
        int userNum = inputsProcessor.readUserIntegerNumber();
        switch (userNum) {
            case BASKET_ADD_PRODUCT -> printMenuToAddProduct();
            case BASKET_GO_TO_MAIN_MENU -> menu.printMainMenu(name);
            case BASKET_END_SHOPPING -> {
                menu.printGoodBye();
                return true;
            }
        }
        return false;
    }
    final int ADD_PRODUCT = 1;
    final int GO_TO_MAIN_MENU = 2;
    private void printShopProducts() {
        menu.printShopProducts(products);
        menu.printActions();
        int userNum = inputsProcessor.readUserIntegerNumber();
        switch (userNum) {
            case ADD_PRODUCT -> printMenuToAddProduct();
            case GO_TO_MAIN_MENU -> menu.printMainMenu(name);
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
