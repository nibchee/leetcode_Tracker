class Solution {
    public int removeDuplicates(int[] nums) {
       int i=0;

       for(int j=1;j<nums.length;j++){
          //skip until same
           if(nums[j]==nums[i])
           continue;

           //as gets differnet
           i++;
           nums[i]=nums[j];
       } 
    
    //retrurn length
    return i+1;
    }
}