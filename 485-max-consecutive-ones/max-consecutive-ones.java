class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
       int ans=0;
       for(int i=0;i<nums.length;i++){
        if(i>0 && nums[i-1]>0 && nums[i]==1){
            nums[i]=nums[i-1]+1;
        }
        ans=Math.max(ans,nums[i]);
       }
       return ans;
    }
}