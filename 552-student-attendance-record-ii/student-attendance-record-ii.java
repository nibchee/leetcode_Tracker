class Solution {
    int dp[][][];
    private final int MOD = 1000000007;
    private int helper(int n,int absence,int lates){
        if(absence>=2||lates>=3)
        return 0;

        if(n==0)
        return 1;

        if(dp[n][absence][lates]!=-1)
        return dp[n][absence][lates];

      return dp[n][absence][lates]=((((helper(n-1,absence,0)%MOD)+(helper(n-1,absence+1,0)%MOD))%MOD)+helper(n-1,absence,lates+1)%MOD)%MOD;
    }
    public int checkRecord(int n) {
        dp=new int[n+1][2][3];
        for(int i=0;i<n+1;i++){
            for(int[] arr: dp[i]){
                Arrays.fill(arr,-1);
            }
        }

        return helper(n,0,0);
    }
}