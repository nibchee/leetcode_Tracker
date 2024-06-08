class Solution {
    public boolean canPartition(int[] nums) {
        /**
         * The trick of this ques is a subset can be partitioned in 2 equal parts if
         * sum is even i.e can be divided in 2 halves & then just find if subset exists
         * with sum =(Totalsum/2)
         */
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % 2 == 1)
            return false;
        int n = nums.length;
        boolean[][] dp = new boolean[n][sum + 1];
        sum = sum / 2;
        for (int i = 0; i < n; i++)
            dp[i][0] = true;

        for (int j = 1; j <= sum; j++) {
            if (nums[0] == j)
                dp[0][j] = true;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= sum; j++) {
                boolean notTake = dp[i - 1][j];
                boolean Take = (j - nums[i] >= 0) ? dp[i - 1][j - nums[i]] : false;
                dp[i][j] = notTake | Take;
                // System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
        }

        return dp[n - 1][sum];
    }
}