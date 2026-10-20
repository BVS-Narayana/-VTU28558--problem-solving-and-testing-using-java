import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        TreeMap<String, Integer> frequency = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String hashtag = sc.nextLine();
            frequency.put(
                hashtag,
                frequency.getOrDefault(hashtag, 0) + 1
            );
        }

        for (Map.Entry<String, Integer> entry
                : frequency.entrySet()) {
            System.out.println(
                entry.getKey() + " " + entry.getValue()
            );
        }

        sc.close();
    }
}
