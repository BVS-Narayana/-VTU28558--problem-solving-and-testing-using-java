import java.io.*;
import java.util.*;

public class Solution {

    public static List<Integer> maxSubarray(List<Integer> arr) {

        // Maximum subarray sum - Kadane's Algorithm
        int currentSum = arr.get(0);
        int maxSubarray = arr.get(0);

        // Maximum subsequence sum
        int maxSubsequence = 0;
        int largestElement = arr.get(0);

        for (int i = 0; i < arr.size(); i++) {
            int value = arr.get(i);

            // Kadane's Algorithm
            if (i > 0) {
                currentSum = Math.max(value, currentSum + value);
                maxSubarray = Math.max(maxSubarray, currentSum);
            }

            // Find largest element
            largestElement = Math.max(largestElement, value);

            // Add all positive values
            if (value > 0) {
                maxSubsequence += value;
            }
        }

        // If all elements are negative,
        // choose the largest single element.
        if (maxSubsequence == 0) {
            maxSubsequence = largestElement;
        }

        return Arrays.asList(maxSubarray, maxSubsequence);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            List<Integer> arr = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                arr.add(sc.nextInt());
            }

            List<Integer> result = maxSubarray(arr);

            System.out.println(result.get(0) + " " + result.get(1));
        }

        sc.close();
    }
}
