import java.util.*;

public class Solution {
    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            freq.put(num, freq.getOrDefault(num, 0) + 1);
            first.putIfAbsent(num, i);
            last.put(num, i);
        }

        int degree = 0;
        for (int count : freq.values()) {
            degree = Math.max(degree, count);
        }

        int minLength = nums.length;

        for (int num : freq.keySet()) {
            if (freq.get(num) == degree) {
                int length = last.get(num) - first.get(num) + 1;
                minLength = Math.min(minLength, length);
            }
        }

        return minLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(findShortestSubArray(nums));
        sc.close();
    }
}
