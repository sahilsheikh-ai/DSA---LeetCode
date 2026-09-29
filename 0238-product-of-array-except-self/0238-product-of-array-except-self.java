class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] answer = new int[n];

        int product = 1;

        // Left product
        for (int i = 0; i < n; i++) {
            answer[i] = product;
            product *= nums[i];
        }

        product = 1;

        // Right product
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= product;
            product *= nums[i];
        }

        return answer;
    }
}