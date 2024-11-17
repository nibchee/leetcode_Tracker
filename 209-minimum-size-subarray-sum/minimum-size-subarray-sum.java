class Solution {
    public int minSubArrayLen(int k, int[] nums) {
         int i=0,j=0;
      int n=nums.length;
      int sum=0;
      int ans=Integer.MAX_VALUE;
      while(i<n && j<n){
         sum+=nums[j];
         while(sum>=k){
         ans=Math.min(ans,j-i+1);
         sum=sum-nums[i];
         i++;
         }
         j++;
      }  
      return ans==Integer.MAX_VALUE?0:ans;
 
    }
}