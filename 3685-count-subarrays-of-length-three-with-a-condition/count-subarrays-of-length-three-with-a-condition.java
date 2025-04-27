class Solution {
    public int countSubarrays(int[] nums) {
        int count=0;
        
        for(int i=0;i<nums.length-2;i++){
            int a=nums[i];
            int b=nums[i+1];
            int c=nums[i+2];
            //System.out.println(a+" "+b+" "+c);
            if(((double)b/2)==(a+c))
                count++;
        }
        return count;
    }
}