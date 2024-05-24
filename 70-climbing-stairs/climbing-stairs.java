class Solution {
int[]dp;
    public int climbStairs(int n) {
        dp=new int[n+1];
        Arrays.fill(dp,-1);
        int ans= helper(n);
        //System.out.println(dp.toString());
        return dp[n];
    }

    public int helper(int n){
    
  if(dp[n]!=-1)
        return dp[n];
      
        if(n==0||n==1){
dp[n]=1;
return dp[n];
        }
         
        int left=helper(n-1);
        int right=helper(n-2);
        dp[n]=left+right;
        return dp[n];
    }
}