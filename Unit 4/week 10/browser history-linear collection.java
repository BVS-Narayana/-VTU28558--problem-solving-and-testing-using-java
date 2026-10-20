
import java.util.Scanner;
import java.util.Stack;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> history = new Stack<>();

        history.push("google.com");
        history.push("youtube.com");
        history.push("github.com");

        System.out.println("Current History: " + history);

        System.out.println("Press 1 to go Back, 0 to Exit.");

        while (true) {
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                if (!history.isEmpty()) {
                    String page = history.pop();
                    System.out.println("Going back from: " + page);
                    System.out.println("Remaining History: " + history);
                } else {
                    System.out.println("No history available.");
                }
            } else if (choice == 0) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

        sc.close();
    }
}
