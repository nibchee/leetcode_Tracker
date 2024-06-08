class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums.length-1,target,nums);
    }

    private int helper(int i,int target,int[] nums){
       if(i==-1){
         if(target==0) return 1;
         else
         return 0;
       }
      
        //try +
       int plus=helper(i-1,target+nums[i],nums);
    
        //try -
        int minus=helper(i-1,target-nums[i],nums);

        return plus+minus;
    }
}