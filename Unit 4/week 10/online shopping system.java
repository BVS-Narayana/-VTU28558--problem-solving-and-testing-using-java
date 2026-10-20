import java.util.*;

public class OnlineShoppingSystem {
    static class Product {
        int id;
        String name;
        double price;

        Product(int id, String name, double price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public String toString() {
            return id + " - " + name + " - Rs." + price;
        }
    }

    static class Order {
        int orderId;
        int priority;
        String customer;

        Order(int orderId, String customer, int priority) {
            this.orderId = orderId;
            this.customer = customer;
            this.priority = priority;
        }

        public String toString() {
            return "Order " + orderId + ", Customer: "
                    + customer + ", Priority: " + priority;
        }
    }

    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        HashMap<Integer, Product> productMap = new HashMap<>();

        products.add(new Product(101, "Laptop", 55000));
        products.add(new Product(102, "Mobile", 20000));
        products.add(new Product(103, "Headphones", 1500));

        for (Product p : products) {
            productMap.put(p.id, p);
        }

        System.out.println("Available Products:");
        for (Product p : products) {
            System.out.println(p);
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Product ID to search: ");
        int id = sc.nextInt();

        Product found = productMap.get(id);
        if (found != null) {
            System.out.println("Product Found: " + found);
        } else {
            System.out.println("Product not found.");
        }

        PriorityQueue<Order> orders = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.priority, b.priority)
        );

        orders.add(new Order(1, "Ravi", 3));
        orders.add(new Order(2, "Arun", 1));
        orders.add(new Order(3, "Priya", 2));

        System.out.println("\nOrders by Priority:");
        while (!orders.isEmpty()) {
            System.out.println(orders.poll());
        }

        sc.close();
    }
}
