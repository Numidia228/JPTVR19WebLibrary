package tools.manager;

import entity.Customer;
import entity.User;

import java.util.Scanner;

public class UserManager {
    private Scanner scanner = new Scanner(System.in);

    public User createUser() {
        CustomerManager customerManager = new CustomerManager();
        Customer customer = customerManager.createCustomer();
        User user = new User();
        System.out.println("--- Создание пользователя ---");
        System.out.print("Введите логин: ");
        user.setLogin(scanner.nextLine());
        System.out.print("Введите пароль: ");
        user.setPassword(scanner.nextLine());
        user.setCustomer(customer);
        System.out.println("Пользователь создан: "+user.toString());
        return user;
    }

    public void addUserToArray(User user, User[] users) {
        for (int i = 0; i < users.length; i++) {
            if(users[i] == null){
                users[i] = user;
                break;
            }
        }
    }

    public void printListUsers(User[] users) {
        for (int i = 0; i < users.length; i++) {
            if(users[i] != null){
                System.out.println(i+1+". " + users[i].toString());
            }
        }
    }

}
