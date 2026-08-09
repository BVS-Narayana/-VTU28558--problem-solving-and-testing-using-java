class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            // Move left forward if the current number is already even
            if (nums[left] % 2 == 0) {
                left++;
            }
            // Move right backward if the current number is already odd
            else if (nums[right] % 2 != 0) {
                right--;
            }
            // Swap odd number at 'left' with even number at 'right'
            else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }

        return nums;
    }
}
