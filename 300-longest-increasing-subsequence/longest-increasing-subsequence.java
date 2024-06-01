class Solution {
    int dp[][];
    //as prev_idx can be -1 so storing +1
    private int helper(int nums[],int idx,int prev_idx){
      //Base cases
      if(idx==nums.length) return 0;
      if(dp[idx+1][prev_idx+1]!=-1) return dp[idx+1][prev_idx+1];
        //not take
        int notTakeLength=helper(nums,idx+1,prev_idx);
        int takeLength=0;
        //take when cur is greater than prev || prev_idx is -1
        if(prev_idx==-1 || nums[idx]>nums[prev_idx]){
            takeLength=1+helper(nums,idx+1,idx);
        }
        return dp[idx+1][prev_idx+1]=Math.max(notTakeLength,takeLength);
    }
    public int lengthOfLIS(int[] nums) {
         int n=nums.length;
        
        dp=new int[n+1][n+1];
        for(int[] arr:dp)
        Arrays.fill(arr,-1); 
        return helper(nums,0,-1);
    }
}