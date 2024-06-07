class Solution {
    int dp[];

    public int fib(int n) {
        dp = new int[n+1];
        dp[0]=0;
        if(n==0) return 0;
        dp[1]=1;
         for(int i=2;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
         }
      //  return helper(n);
      return dp[n];
    }

    private int helper(int n) {
        if (n <= 1)
            return dp[n] = n;
        if (dp[n] != 0)
            return dp[n];
        return dp[n] = helper(n - 1) + helper(n - 2);
    }
}