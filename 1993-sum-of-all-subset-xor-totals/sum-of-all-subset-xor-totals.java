class Solution {
    public int subsetXORSum(int[] nums) {
        int n=nums.length;
        int total=(int)Math.pow(2,n);
         int totSum=0;
        for(int i=0;i<total;i++){
            int num=i;
            int xor=0;
            int count=0;
            while(num!=0){
                if((num&1)==1)
               xor=xor^(nums[count]);
               num=num>>1;
               count++;
            }
            totSum+=xor;
        }
    return totSum;
    }
}