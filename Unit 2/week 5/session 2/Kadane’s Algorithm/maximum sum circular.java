class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int curMax = 0, maxSum = nums[0];
        int curMin = 0, minSum = nums[0];

        for (int num : nums) {
            // Kadane's algorithm for max subarray sum
            curMax = Math.max(num, curMax + num);
            maxSum = Math.max(maxSum, curMax);

            // Kadane's algorithm for min subarray sum
            curMin = Math.min(num, curMin + num);
            minSum = Math.min(minSum, curMin);

            totalSum += num;
        }

        // If all numbers are negative, maxSum will be negative
        if (maxSum < 0) {
            return maxSum;
        }

        return Math.max(maxSum, totalSum - minSum);
    }
}
