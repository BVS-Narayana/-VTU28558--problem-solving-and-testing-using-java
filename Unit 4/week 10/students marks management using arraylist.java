import java.util.ArrayList;
import java.util.Scanner;

public class StudentMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> marks = new ArrayList<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Number of students must be positive.");
            sc.close();
            return;
        }

        for (int i = 0; i < n; i++) {
            System.out.print("Enter mark of student "
                    + (i + 1) + ": ");
            marks.add(sc.nextInt());
        }

        System.out.println("\nStudent Marks: " + marks);

        int highest = marks.get(0);
        int total = 0;

        for (int mark : marks) {
            if (mark > highest) {
                highest = mark;
            }
            total += mark;
        }

        double average = (double) total / marks.size();

        System.out.println("Highest Mark: " + highest);
        System.out.printf("Average Mark: %.2f%n", average);

        sc.close();
    }
}
