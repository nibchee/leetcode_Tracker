class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 1;
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (dp[i] < dp[j] + 1) {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}