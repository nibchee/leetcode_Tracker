class Solution {
    public int[] singleNumber(int[] nums) {
        int XOR=0;
        for(int num: nums) XOR=XOR^num;
        //now XOR contains XOR of 2 elements=> a^b
        //so find leftmost first set bit
        int numRightMostSet=1;
        while((XOR&1)!=1){
           numRightMostSet=numRightMostSet<<1;
           XOR=XOR>>1;
        }
        //System.out.println(numRightMostSet);
        //found bit set number
        //create 2 buckets
        int b1=0,b2=0;
        //keep adding all numbers with anding with 1
        for(int num:nums){
            //System.out.println(num +" "+(num&numRightMostSet));
            if((num&numRightMostSet)>0)
            b1=b1^num;
            else
            b2=b2^num;
        }
    return new int[]{b1,b2};
    }
}