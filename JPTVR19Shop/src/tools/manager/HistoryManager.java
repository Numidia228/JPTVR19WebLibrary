package tools.manager;

import entity.Product;
import entity.History;
import entity.Customer;
import entity.User;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import com.company.App;

public class HistoryManager {
    private Scanner scanner = new Scanner(System.in);
    private CustomerManager customerManager = new CustomerManager();
    private ProductManager productManager = new ProductManager();

    public History takeOnProduct(Product[] products, Customer[] customers) {
        History history = new History();
        User loggedInUser = App.loginedUser;
        Customer customer = null;
        System.out.println("--- Список  ---");
        System.out.println();

        System.out.print("Выберите номер товара: ");
        int bookNumber = scanner.nextInt();
        scanner.nextLine();
        Product product = products[bookNumber-1];
        history.setProduct(product);
        Calendar calendar = new GregorianCalendar();
        history.setPurchaseDate(calendar.getTime());
        this.printHistory(history);
        return history;
    }

    public void returnBook(History[] histories) {
        System.out.println("--- Список товаров ---");
        for (int i = 0; i < histories.length; i++) {
            if (histories[i] != null) {
                System.out.printf("%d. Товар %s %s%n"
                        , i + 1
                        , histories[i].getProduct().getName()
                );
            }
            if (histories[i] != null
                    && histories[i].getCustomer().equals(App.loginedUser.getCustomer())
                    && histories[i].getPurchaseDate() == null) {
                System.out.printf("%d. Товар %s %s%n"
                        , i + 1
                        , histories[i].getProduct().getName()
                );
            }
        }
    }

    public void addHistoryToArray(History history, History[] histories) {
        for (int i = 0; i < histories.length; i++) {
            if (histories[i] == null) {
                histories[i] = history;
                break;
            }
        }
    }

    private void printHistory(History history) {
        System.out.printf("Товар \"%s\" %s%n"
                , history.getProduct().getName()
                , history.getProduct().getName()
                , history.getCustomer().getLastname());
    }

    public void printListReadBooks(History[] histories) {
        for (int i = 0; i < histories.length; i++) {
            if(histories[i] != null){
                System.out.printf("Товар %s %s%n"
                        ,i+1
                        ,histories[i].getProduct().getName());
            }
        }
    }
}