class Solution {
  int dp[];
    public int climbStairs(int n) {
     dp=new int[n+1];
     dp[1]=1;
     if(n>1)
     dp[2]=2;

     for(int i=3;i<=n;i++)
     dp[i]=dp[i-1]+dp[i-2];
    // return f(n);  
    return dp[n]; 
    }

    private int f(int i){
       //System.out.println(i+" "+dp[i]);
      if(i<=2)
      return i;
       if(dp[i]!=0) return dp[i];
      
      return dp[i]=f(i-1)+f(i-2);
    }
}