import java.util.Scanner;

public class DynamicMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] marks = new int[2];
        int size = 0;

        System.out.print("How many marks do you want to enter? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (size == marks.length) {
                int[] newMarks = new int[marks.length * 2];

                for (int j = 0; j < size; j++) {
                    newMarks[j] = marks[j];
                }

                marks = newMarks;
            }

            System.out.print("Enter mark " + (i + 1) + ": ");
            marks[size] = sc.nextInt();
            size++;
        }

        System.out.println("\nStudent Marks:");
        for (int i = 0; i < size; i++) {
            System.out.println(marks[i]);
        }

        System.out.println("Number of students: " + size);
        System.out.println("Array capacity: " + marks.length);

        sc.close();
    }
}
