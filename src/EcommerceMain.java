import java.io.IOException;
import java.util.Scanner;

import main.Product.ProductManagement;
import main.User.UserManagement;

public class EcommerceMain {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("########  Welcome to Our E-Commerce Application!  ########");
        Login.login();

        while (true) {
            System.out.println("What would you like to do today!");
            System.out.println("1. Product Management");
            System.out.println("2. User Management");
            System.out.println("3. Quit the application");

            int option = scan.nextInt();
            if (option == 1) {
                ProductManagement.productManagement();
            } else if (option == 2) {
            	UserManagement.userManagement();

            } else if (option == 3) {
                System.out.println("Quitting the interface!");
                return;
            } else {
                System.out.println("Invalid option selected!");
            }
        }
    }

}
