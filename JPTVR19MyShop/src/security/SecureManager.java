package security;

import entity.Customer;
import entity.User;
import java.util.Scanner;
import tools.manager.CustomerManager;
import tools.manager.UserManager;
import tools.saver.CustomerSaver;
import tools.saver.UserSaver;

public class SecureManager {

    private Scanner scanner = new Scanner(System.in);

    public User checkTask(User[] users, Customer[] customers) {
        do{
            String task = this.printCheckTasks();
            switch (task) {
                case "0":
                    System.out.println("Выход из программы...");
                    System.exit(0);
                    break;
                case "1":
                    this.registration(users, customers);
                    break;
                case "2":
                    return this.checkInUser(users);

                default:
                    System.out.println("Выберите указанные задачи.");;
            }
        }while(true);

    }
    private String printCheckTasks(){
        System.out.println();
        System.out.println("--- Вход в систему ---");
        System.out.println("0. Выйти из программы");
        System.out.println("1. Регистрация");
        System.out.println("2. Вход в систему");
        System.out.print("Выберите номер задачи: ");
        String numTask = scanner.nextLine();
        return numTask;
    }

    private void registration(User[] users, Customer[] customers) {
        UserManager userManager = new UserManager();
        User user = userManager.createUser();
        userManager.addUserToArray(user, users);
        CustomerManager customerManager = new CustomerManager();
        customerManager.addCustomerToArray(user.getCustomer(), customers);
        CustomerSaver customerSaver = new CustomerSaver();
        customerSaver.saveCustomers(customers);
        UserSaver userSaver = new UserSaver();
        userSaver.saveUsers(users);
    }

    private User checkInUser(User[] users) {
        System.out.println("--- Вход в систему ---");
        System.out.println("Введите логин: ");
        String login = scanner.nextLine();
        System.out.println("Введите пароль: ");
        String password = scanner.nextLine();
        for (int i = 0; i < users.length; i++) {
            User user = users[i];
            if(user == null) continue;
            if(login.equals(user.getLogin())){//Authetication
                for (int j = 0; j < 2; j++) {
                    if(password.equals(user.getPassword())){//Authorization
                        return user;
                    }else{
                        System.out.print("Попробуй еще раз: ");
                        password = scanner.nextLine();
                    }
                }
                System.out.println("У вас нет доступа.");
                System.exit(0);
            }
        }
        System.out.println("У вас нет доступа. Зарегистрируйтесь.");
        System.exit(0);
        return null;
    }

}