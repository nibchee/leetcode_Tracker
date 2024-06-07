class Solution {
    public int helper(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        if (n == 1)
            return nums[0];
        int prev1 = nums[0];
        int prev2 = 0, curr = 0;
        for (int i = 1; i < n; i++) {
            int cost1 = prev1;
            int cost2 = prev2 + nums[i];
            curr = Math.max(cost1, cost2);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] nums1 = new int[n - 1];
        int[] nums2 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            nums1[i] = nums[i];
        }
        for (int i = 1; i < n; i++) {
            nums2[i - 1] = nums[i];
        }
        return Math.max(helper(nums1), helper(nums2));
    }
}