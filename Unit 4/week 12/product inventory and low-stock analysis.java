import java.util.*;

public class Solution {
    static class Product {
        int id;
        String name;
        int stock;
        double price;

        Product(int id, String name, int stock, double price) {
            this.id = id;
            this.name = name;
            this.stock = stock;
            this.price = price;
        }

        public String toString() {
            return "ID: " + id
                + ", Name: " + name
                + ", Stock: " + stock
                + ", Price: Rs." + price;
        }
    }

    static TreeMap<Integer, Product> inventory = new TreeMap<>();

    static void addProduct(Scanner sc) {
        System.out.print("Enter product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (inventory.containsKey(id)) {
            System.out.println("Product ID already exists.");
            return;
        }

        System.out.print("Enter product name: ");
        String name = sc.nextLine();

        System.out.print("Enter stock quantity: ");
        int stock = sc.nextInt();

        System.out.print("Enter price: ");
        double price = sc.nextDouble();

        if (stock < 0 || price < 0) {
            System.out.println("Stock and price cannot be negative.");
            return;
        }

        inventory.put(id, new Product(id, name, stock, price));
        System.out.println("Product added successfully.");
    }

    static void updateStock(Scanner sc) {
        System.out.print("Enter product ID: ");
        int id = sc.nextInt();

        Product p = inventory.get(id);

        if (p == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter quantity sold: ");
        int sold = sc.nextInt();

        if (sold < 0) {
            System.out.println("Quantity cannot be negative.");
        } else if (sold > p.stock) {
            System.out.println("Insufficient stock.");
        } else {
            p.stock -= sold;
            System.out.println("Stock updated successfully.");
            System.out.println(p);
        }
    }

    static void lowStock(Scanner sc) {
        System.out.print("Enter stock threshold: ");
        int threshold = sc.nextInt();

        System.out.println("Products below threshold:");

        boolean found = false;

        for (Product p : inventory.values()) {
            if (p.stock < threshold) {
                System.out.println(p);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No low-stock products.");
        }
    }

    static void sortByStock() {
        ArrayList<Product> products =
            new ArrayList<>(inventory.values());

        products.sort(
            Comparator.comparingInt((Product p) -> p.stock)
                      .thenComparingInt(p -> p.id)
        );

        System.out.println("Products sorted by stock:");

        for (Product p : products) {
            System.out.println(p);
        }
    }

    static void searchProduct(Scanner sc) {
        System.out.print("Enter product ID: ");
        int id = sc.nextInt();

        Product p = inventory.get(id);

        if (p != null) {
            System.out.println("Product found:");
            System.out.println(p);
        } else {
            System.out.println("Product not found.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\nPRODUCT INVENTORY SYSTEM");
            System.out.println("1. Add Product");
            System.out.println("2. Update Stock After Sales");
            System.out.println("3. Find Low-Stock Products");
            System.out.println("4. Display Products Sorted by Stock");
            System.out.println("5. Search Product by ID");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addProduct(sc);
                    break;
                case 2:
                    updateStock(sc);
                    break;
                case 3:
                    lowStock(sc);
                    break;
                case 4:
                    sortByStock();
                    break;
                case 5:
                    searchProduct(sc);
                    break;
                case 6:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
