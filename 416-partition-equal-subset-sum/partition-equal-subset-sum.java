class Solution {
    int dp[][];
    private int helper(int idx,int sum,int nums[]){
       if(sum<0 || idx<0) return 0;
       if(sum==0) return 1;
       if(idx==0) return (nums[idx]==sum)?1:0;

       if(dp[idx-1][sum-1]!=-1) return dp[idx-1][sum-1];


       return dp[idx-1][sum-1]=(helper(idx-1,sum,nums)==1)||(helper(idx-1,sum-nums[idx],nums)==1)?1:0;
    }
    public boolean canPartition(int[] nums) {
        /** The trick of this ques is a subset can be partitioned in 2 equal parts if
        sum is even i.e can be divided in 2 halves & then just find if subset exists with sum =(Totalsum/2)*/
        int sum =0;
        for(int i=0;i<nums.length;i++)
        sum+=nums[i];

        if(sum%2==1)return false;
       int n=nums.length-1;
       dp=new int[n][sum];
       for(int[] arr:dp){
        Arrays.fill(arr,-1);
       }
       return  helper(n-1,sum/2,nums)==1?true:false;  
    }
}