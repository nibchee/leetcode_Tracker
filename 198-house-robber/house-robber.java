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
        if(n==1) return nums[0];
         int prev1=nums[0];
         int prev2=0,curr=0;
        for(int i=1;i<n;i++){
        int cost1=prev1;
        int cost2=prev2+nums[i];   
        curr=Math.max(cost1,cost2);
        prev2=prev1;
        prev1=curr; 
        }
        //return helper(n-1,nums);
       // return dp[n-1];
       return curr;
    }
}