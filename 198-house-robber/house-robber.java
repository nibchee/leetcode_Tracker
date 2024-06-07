class Solution {
    int[] dp;
    // private int helper(int i,int[] nums){
    //     if(i==0) return dp[0]=nums[0];
    //     if(i<0) return 0;
    //     if(dp[i]!=0) return dp[i];
    //     int cost1=helper(i-1,nums);
    //     int cost2=helper(i-2,nums)+nums[i];
    //     return dp[i]=Math.max(cost1,cost2);
    // }
     public int rob(int[] nums) {
        int n=nums.length;
        dp=new int[n];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
        int cost1=dp[i-1];
        int cost2=(i-2)>=0?dp[i-2]+nums[i]:nums[i];   
        dp[i]=Math.max(cost1,cost2); 
        }
        //return helper(n-1,nums);
        return dp[n-1];
    }
}