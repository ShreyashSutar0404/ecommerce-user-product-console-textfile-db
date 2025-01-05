package main.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductManagement {
    public static void productManagement() throws IOException {
    	System.out.println("Welcome to Product Management");
        Scanner scan = new Scanner(System.in);
        ArrayList<Product> productList = new ArrayList<>();
        String filePath = "C:\\java\\Day_24_Read_Write_Product_User_txtFilee\\src\\main\\Product\\Product.txt";
        File file = new File(filePath);

        if (file.exists()) {
            FileReader fileReader = new FileReader(file);
            BufferedReader br = new BufferedReader(fileReader);
            String line;
            while ((line = br.readLine()) != null) {
                String productArray[] = line.split(",");
                if (productArray.length == 3) {
                    Product product = new Product();
                    product.productName = productArray[0].trim();
                    product.price = productArray[1].trim();
                    product.productQuantity = productArray[2].trim();
                    productList.add(product);
                }
            }
            br.close();
            fileReader.close();
        }

        while (true) {
            System.out.println("What would you like to do!");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Search Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Print Saved Products");
            System.out.println("9. Quit Product Management");
            int option = scan.nextInt();

            if (option == 1) {
                Product product = new Product();
                System.out.println("Add Product Details:");
                System.out.print("Product Name: ");
                product.productName = scan.next();
                System.out.print("Product Price: ");
                product.price = scan.next();
                System.out.print("Product Quantity: ");
                product.productQuantity = scan.next();
                productList.add(product);

            } else if (option == 2) {
                System.out.print("Enter the product name to update: ");
                String updateName = scan.next();
                boolean found = false;

                for (Product product : productList) {
                    if (product.productName.equals(updateName)) {
                        System.out.print("Enter new price: ");
                        product.price = scan.next();
                        System.out.print("Enter new quantity: ");
                        product.productQuantity = scan.next();
                        found = true;
                        System.out.println("Product updated successfully!");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Product not found!");
                }

            } else if (option == 3) {
                System.out.print("Enter the product name to search: ");
                String searchName = scan.next();
                boolean found = false;

                for (Product product : productList) {
                    if (product.productName.equals(searchName)) {
                        System.out.println("Product Found:");
                        System.out.println("Name: " + product.productName);
                        System.out.println("Price: " + product.price);
                        System.out.println("Quantity: " + product.productQuantity);
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Product not found!");
                }

            } else if (option == 4) {
                System.out.print("Enter the product name to delete: ");
                String deleteName = scan.next();
                boolean found = false;

                for (int i = 0; i < productList.size(); i++) {
                    Product product = productList.get(i);
                    if (product.productName.equals(deleteName)) {
                        productList.remove(i);
                        found = true;
                        System.out.println("Product removed successfully!");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Product not found!");
                }

            } else if (option == 5) {
                if (productList.isEmpty()) {
                    System.out.println("No products available.");
                } else {
                    for (Product product : productList) {
                        System.out.println("Name: " + product.productName);
                        System.out.println("Price: " + product.price);
                        System.out.println("Quantity: " + product.productQuantity);
                        System.out.println("-------------------------");
                    }
                }

            } else if (option == 9) {
                System.out.println("Quitting Product Management!");

                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                for (Product product : productList) {
                    bufferedWriter.write(product.productName + "," + product.price + "," + product.productQuantity);
                    bufferedWriter.newLine();
                }

                bufferedWriter.close();
                fileWriter.close();
                break;

            } else {
                System.out.println("Invalid Option selected!");
            }
        }
    }
}


