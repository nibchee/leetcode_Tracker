class Solution {
    public int waysToSplitArray(int[] nums) {
        long totSum=0;
        for(int num:nums)
        totSum+=num;

        int ans=0;
        long leftSum=0;
        for(int i=0;i<nums.length-1;i++){
            leftSum+=nums[i];
            totSum-=nums[i];
            if(leftSum>=totSum)
            ans++;
        }
        return ans;
    }
}