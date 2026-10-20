import java.util.*;

public class Solution {
    public static List<Integer> freqQuery(int[][] queries) {
        HashMap<Integer, Integer> frequency = new HashMap<>();
        HashMap<Integer, Integer> frequencyCount = new HashMap<>();

        List<Integer> result = new ArrayList<>();

        for (int[] query : queries) {
            int operation = query[0];
            int x = query[1];

            if (operation == 1) {
                int oldFreq = frequency.getOrDefault(x, 0);
                int newFreq = oldFreq + 1;

                if (oldFreq > 0) {
                    frequencyCount.put(
                        oldFreq, frequencyCount.get(oldFreq) - 1
                    );
                }

                frequency.put(x, newFreq);
                frequencyCount.put(
                    newFreq,
                    frequencyCount.getOrDefault(newFreq, 0) + 1
                );

            } else if (operation == 2) {
                int oldFreq = frequency.getOrDefault(x, 0);

                if (oldFreq > 0) {
                    frequencyCount.put(
                        oldFreq, frequencyCount.get(oldFreq) - 1
                    );

                    int newFreq = oldFreq - 1;

                    if (newFreq == 0) {
                        frequency.remove(x);
                    } else {
                        frequency.put(x, newFreq);
                        frequencyCount.put(
                            newFreq,
                            frequencyCount.getOrDefault(newFreq, 0) + 1
                        );
                    }
                }

            } else if (operation == 3) {
                result.add(
                    frequencyCount.getOrDefault(x, 0) > 0 ? 1 : 0
                );
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int q = sc.nextInt();
        int[][] queries = new int[q][2];

        for (int i = 0; i < q; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
        }

        List<Integer> result = freqQuery(queries);

        for (int value : result) {
            System.out.println(value);
        }

        sc.close();
    }
}
