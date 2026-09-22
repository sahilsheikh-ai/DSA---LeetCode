class Solution {
    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        // 1. Find the first decreasing element
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 2. Find element just bigger than nums[i]
        if (i >= 0) {
            int j = nums.length - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            swap(nums, i, j);
        }

        // 3. Reverse the remaining part
        reverse(nums, i + 1, nums.length - 1);
    }

    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void reverse(int[] nums, int left, int right) {
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}