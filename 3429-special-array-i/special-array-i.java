class Solution {
    public boolean isArraySpecial(int[] nums) {
        if(nums.length==1)
            return true;
        for(int i=0;i<nums.length-1;i++){
            if(((nums[i]&1)==1 && (nums[i+1]&1)==1)||((nums[i]&1)==0 && (nums[i+1]&1)==0))
                return false;
        }
    return true;
    }
}