class Solution {
    // int dp[];

    public int fib(int n) {
        int prev1 = 0;
        if (n == 0)
            return 0;
        int prev2 = 1;
        int curr = prev2;
        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        // return helper(n);
        return curr;
    }

    // private int helper(int n) {
    // if (n <= 1)
    // return dp[n] = n;
    // if (dp[n] != 0)
    // return dp[n];
    // return dp[n] = helper(n - 1) + helper(n - 2);
    // }
}