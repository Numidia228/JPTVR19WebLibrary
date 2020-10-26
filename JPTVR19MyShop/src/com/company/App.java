package com.company;

import tools.saver.HistorySaver;
import tools.manager.HistoryManager;
import tools.saver.ProductSaver;
import tools.manager.HistoryManager;
import entity.Product;
import entity.History;
import entity.Customer;
import entity.User;
import java.util.Scanner;
import security.SecureManager;
import tools.manager.ProductManager;
import tools.saver.CustomerSaver;
import tools.saver.UserSaver;
import ui.ManagerUI;

public class App {
    private Product[] products = new Product[100];
    private Customer[] customers = new Customer[10];
    private History[] histories = new History[10];
    private User[] users = new User[10];

    private ProductSaver productSaver = new ProductSaver();
    private CustomerSaver customerSaver = new CustomerSaver();
    private HistorySaver historySaver = new HistorySaver();
    private SecureManager secureManager = new SecureManager();
    private UserSaver userSaver = new UserSaver();

    public static User loginedUser;

    public App() {
        products = productSaver.loadProducts();
        customers = customerSaver.loadCustomers();
        histories = historySaver.loadHistories();
        users = userSaver.loadUsers();
    }

    public void run(){
        boolean repeat = true;
        System.out.println("--- Библиотека ---");
        this.loginedUser = secureManager.checkTask(users, customers);
        ManagerUI managerUI = new ManagerUI();
        managerUI.getManagerUI(customers, users, products, histories);

    }
}