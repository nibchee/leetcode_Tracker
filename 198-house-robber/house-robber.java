class Solution {
  int dp[];

  public int rob(int[] nums) {
    int n = nums.length;
    if(n==1) return nums[0];
    dp = new int[n];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < n; i++) {
      int prev = dp[i - 1];
      int lastPrev =dp[i - 2] + nums[i];
      dp[i] = Math.max(prev, lastPrev);
    }
    return dp[n-1];
    // return helper(n-1,nums);

  }

  private int helper(int i, int nums[]) {
    if (i < 0) {
      return 0;
    }
    if (dp[i] != 0)
      return dp[i];
    int prev = helper(i - 1, nums);
    int lastPrev = helper(i - 2, nums) + nums[i];
    return dp[i] = Math.max(prev, lastPrev);
  }
}