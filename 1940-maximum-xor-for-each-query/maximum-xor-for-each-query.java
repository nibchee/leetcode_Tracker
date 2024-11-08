class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
         int n=nums.length;
        int prefix_xor[]=new int[n];
         prefix_xor[n-1]=nums[0];
        for(int i=nums.length-2;i>=0;i--){
prefix_xor[i]=prefix_xor[i+1]^nums[n-i-1];
        }

        for(int i=0;i<n;i++){
            prefix_xor[i]=prefix_xor[i]^((1<<maximumBit)-1);
        }

        return prefix_xor;
    }
}