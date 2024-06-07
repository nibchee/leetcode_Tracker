class Solution {
    int dp[];

    public int fib(int n) {
        dp = new int[n+1];
        return helper(n);
    }

    private int helper(int n) {
        if (n <= 1)
            return dp[n] = n;
        if (dp[n] != 0)
            return dp[n];
        return dp[n] = helper(n - 1) + helper(n - 2);
    }
}