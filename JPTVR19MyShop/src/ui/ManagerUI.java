package ui;

import entity.Customer;
import entity.History;
import entity.Product;
import entity.User;
import tools.manager.CustomerManager;
import tools.manager.HistoryManager;
import tools.manager.ProductManager;
import tools.saver.CustomerSaver;
import tools.saver.HistorySaver;
import tools.saver.ProductSaver;

import java.util.Scanner;

public class ManagerUI {
    private Product[] products = new Product[10];
    private Customer[] customers = new Customer[10];
    private History[] histories = new History[10];
    private ProductManager productManager = new ProductManager();
    private CustomerManager customerManager = new CustomerManager();
    private HistoryManager historyManager = new HistoryManager();
    private ProductSaver productSaver = new ProductSaver();
    private CustomerSaver customerSaver = new CustomerSaver();
    private HistorySaver historySaver = new HistorySaver();

    public ManagerUI() {
        products = ProductSaver.loadProducts();
    }

    public void getManagerUI(Customer[] customers, User[] users, Product[] products, History[] histories) {
        System.out.println();
        System.out.println("Добро пожаловать");
        System.out.println("============================================");
        System.out.println("LapShop | магазин ноутбуков");
        System.out.println("============================================");
        boolean repeat = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("Выберите программу: ");
            System.out.println();
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить товар");
            System.out.println("2. Список товаров");
            System.out.println("3. Добавить пользователя");
            System.out.println("4. Список пользователей");
            System.out.println("5. Купить товар");
            System.out.print("Выберите задачу: ");
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println();
                    System.out.println("--------------------------------");
                    System.out.println("Выбрана задача: 0. Выйти из программы");
                    System.out.println("--------------------------------");
                    System.out.println();
                    System.out.println("--- Конец программы ---");
                    break;
                case "1":
                    System.out.println();
                    System.out.println("--------------------------------");
                    System.out.println("Выбрана задача: 1. Добавить товар");
                    System.out.println("--------------------------------");

                    Product product = ProductManager.createProduct();
                    productManager.addProductToArray(product, products);
                    ProductSaver.saveProducts(products);

                    System.out.println();
                    break;
                case "2":
                    System.out.println();
                    System.out.println("--------------------------------");
                    System.out.println("Выбрана задача: 2. Список товаров");
                    System.out.println("--------------------------------");

                    productManager.printListProducts(products);

                    System.out.println();
                    break;
                case "3":
                    System.out.println();
                    System.out.println("--------------------------------");
                    System.out.println("Выбрана задача: 3. Добавить пользователя");
                    System.out.println("--------------------------------");

                    Customer customer = customerManager.createCustomer();
                    customerManager.addCustomerToArray(customer, customers);
                    customerSaver.saveCustomers(customers);

                    System.out.println();
                    break;
                case "4":
                    System.out.println();
                    System.out.println("--------------------------------");
                    System.out.println("Выбрана задача: 4. Список пользователей");
                    System.out.println("--------------------------------");
                    System.out.println();

                    customerManager.printListCustomers(customers);

                    break;
                case "5":
                    System.out.println();
                    System.out.println("--------------------------------");
                    System.out.println("Выбрана задача: 5. Купить товар");
                    System.out.println("--------------------------------");

                    History history = historyManager.takeOnProduct(products, customers);
                    historyManager.addHistoryToArray(history,histories);
                    historySaver.saveHistories(histories);

                    System.out.println();
                    break;
            }
        } while(repeat);
    }
}
