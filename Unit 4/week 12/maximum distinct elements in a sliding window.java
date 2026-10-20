
import java.util.*;

public class Solution {
    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> {
            int compare = Integer.compare(
                frequency.get(b), frequency.get(a)
            );

            if (compare != 0) {
                return compare;
            }

            return a.compareTo(b);
        });

        pq.addAll(frequency.keySet());

        List<String> result = new ArrayList<>();

        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            result.add(pq.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = sc.next();
        }

        int k = sc.nextInt();

        if (k < 1 || k > new HashSet<>(Arrays.asList(words)).size()) {
            System.out.println("Invalid K");
        } else {
            System.out.println(topKFrequent(words, k));
        }

        sc.close();
    }
}
