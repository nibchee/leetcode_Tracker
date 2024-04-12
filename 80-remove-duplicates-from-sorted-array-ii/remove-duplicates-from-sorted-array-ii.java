class Solution {
    public int removeDuplicates(int[] nums) {
       if(nums.length==1)
       return 1;

       int j=2;
       for(int i=2;i<nums.length;i++){
            //if not equal then replace
            if(nums[i]!=nums[j-2]){
            nums[j++]=nums[i];
            }
       }
       return j;
    }
}