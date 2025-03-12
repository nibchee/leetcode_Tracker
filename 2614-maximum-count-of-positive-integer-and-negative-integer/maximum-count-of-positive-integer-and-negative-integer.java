class Solution {
    public int maximumCount(int[] nums) {
       int p_c=0;
       int n_c=0;
       for(int num:nums){
        if(num==0)continue;
        if(num>0)p_c++;
        if(num<0)n_c++;
       } 

       return Math.max(p_c,n_c);
    }
}