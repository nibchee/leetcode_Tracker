class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
     for(int i=1;i<=nums.length;i++){
        int count=0;
             for(int j=0;j<nums.length;j++){
                  if(nums[j]>=i)
                  count++;
             }
        if(count==i)
        return i;
     }   
    return -1;
    }
}