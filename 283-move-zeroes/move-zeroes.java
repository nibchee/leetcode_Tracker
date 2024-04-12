class Solution {
    public void moveZeroes(int[] nums) {
        int i=0,j=0;
        //Shifting all values from right to left
        for(i=0;i<nums.length;i++){
            if(nums[i]!=0)
            nums[j++]=nums[i];
        }

        //filling left with 0
        while(j<nums.length)
        nums[j++]=0;
    }
}