class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max_positive_sum=0;
        int max_negative_sum=0;
         int sum_so_far=0;
        for(int i=0;i<nums.length;i++){
      sum_so_far+=nums[i];
       if(sum_so_far<0)
       sum_so_far=0;
       if(max_positive_sum<sum_so_far)
       max_positive_sum=sum_so_far;
        }
        sum_so_far=0;
        for(int i=0;i<nums.length;i++){
      sum_so_far+=nums[i];
       if(sum_so_far>0)
       sum_so_far=0;
       if(max_negative_sum>sum_so_far)
       max_negative_sum=sum_so_far;
        }

        return Math.max(Math.max(max_positive_sum,-1*max_negative_sum),0);
    }
}