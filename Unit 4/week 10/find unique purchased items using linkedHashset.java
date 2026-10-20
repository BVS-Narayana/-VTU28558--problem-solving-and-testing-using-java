import java.util.LinkedHashSet;
import java.util.Scanner;

public class UniqueItems {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashSet<String> items = new LinkedHashSet<>();

        System.out.print("Enter number of purchased items: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter item " + (i + 1) + ": ");
            items.add(sc.nextLine());
        }

        System.out.println("\nUnique Purchased Items:");

        for (String item : items) {
            System.out.println(item);
        }

        sc.close();
    }
}
