import java.util.ArrayList;
import java.util.Scanner;

public class CommonSubjects {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> student1 = new ArrayList<>();
        ArrayList<String> student2 = new ArrayList<>();

        System.out.print("Enter number of subjects for Student 1: ");
        int n1 = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n1; i++) {
            System.out.print("Enter subject: ");
            student1.add(sc.nextLine());
        }

        System.out.print("Enter number of subjects for Student 2: ");
        int n2 = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n2; i++) {
            System.out.print("Enter subject: ");
            student2.add(sc.nextLine());
        }

        student1.retainAll(student2);

        System.out.println("\nCommon Subjects:");

        if (student1.isEmpty()) {
            System.out.println("No common subjects.");
        } else {
            for (String subject : student1) {
                System.out.println(subject);
            }
        }

        sc.close();
    }
}
