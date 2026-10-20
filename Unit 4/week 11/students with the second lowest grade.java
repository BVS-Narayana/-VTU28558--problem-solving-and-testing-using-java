import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        List<List<Object>> students = new ArrayList<>();
        TreeSet<Double> grades = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            double grade = sc.nextDouble();
            sc.nextLine();

            List<Object> student = new ArrayList<>();
            student.add(name);
            student.add(grade);

            students.add(student);
            grades.add(grade);
        }

        double secondLowest = grades.higher(grades.first());

        List<String> names = new ArrayList<>();

        for (List<Object> student : students) {
            String name = (String) student.get(0);
            double grade = (Double) student.get(1);

            if (grade == secondLowest) {
                names.add(name);
            }
        }

        Collections.sort(names);

        for (String name : names) {
            System.out.println(name);
        }

        sc.close();
    }
}
