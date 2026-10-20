import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneContactDirectory {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<String, String> contacts = new HashMap<>();

        while (true) {
            System.out.println("\nPHONE CONTACT DIRECTORY");
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Update Phone Number");
            System.out.println("4. Display All Contacts");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter phone number: ");
                    String phone = sc.nextLine();

                    contacts.put(name, phone);
                    System.out.println("Contact saved successfully.");
                    break;

                case 2:
                    System.out.print("Enter name to search: ");
                    String searchName = sc.nextLine();

                    if (contacts.containsKey(searchName)) {
                        System.out.println("Name: " + searchName);
                        System.out.println("Phone: "
                                + contacts.get(searchName));
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter name to update: ");
                    String updateName = sc.nextLine();

                    if (contacts.containsKey(updateName)) {
                        System.out.print("Enter new phone number: ");
                        String newPhone = sc.nextLine();

                        contacts.put(updateName, newPhone);
                        System.out.println("Contact updated successfully.");
                    } else {
                        System.out.println("Contact not found.");
                    }
                    break;

                case 4:
                    if (contacts.isEmpty()) {
                        System.out.println("No contacts available.");
                    } else {
                        System.out.println("\nAll Contacts:");

                        for (Map.Entry<String, String> entry
                                : contacts.entrySet()) {
                            System.out.println(
                                entry.getKey() + " : "
                                + entry.getValue()
                            );
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting Contact Directory.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
