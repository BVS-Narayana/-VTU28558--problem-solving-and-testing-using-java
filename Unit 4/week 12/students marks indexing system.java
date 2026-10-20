import java.util.*;

public class Solution {
    static class Student {
        String name;
        double marks;

        Student(String name, double marks) {
            this.name = name;
            this.marks = marks;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Student> students = new HashMap<>();

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter student name: ");
            String name = sc.nextLine();

            System.out.print("Enter marks: ");
            double marks = sc.nextDouble();
            sc.nextLine();

            students.put(id, new Student(name, marks));
        }

        System.out.print("Enter number of queries: ");
        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            System.out.print("Enter student ID to search: ");
            int id = sc.nextInt();

            Student student = students.get(id);

            if (student != null) {
                System.out.println("Name: " + student.name);
                System.out.println("Marks: " + student.marks);
            } else {
                System.out.println("Student not found.");
            }
        }

        sc.close();
    }
}
