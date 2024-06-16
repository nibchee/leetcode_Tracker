class Solution {
  int dp[];
    public int climbStairs(int n) {
     dp=new int[n+1];
     return f(n);   
    }

    private int f(int i){
       //System.out.println(i+" "+dp[i]);
      if(i<=2)
      return i;
       if(dp[i]!=0) return dp[i];
      
      return dp[i]=f(i-1)+f(i-2);
    }
}