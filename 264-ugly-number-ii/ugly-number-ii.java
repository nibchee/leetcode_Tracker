class Solution {
    public int nthUglyNumber(int n) {
        int uglyNums[]=new int[n];
        uglyNums[0]=1;
        int p2=0,p3=0,p5=0;
        for(int i=1;i<n;i++){
            int multi_2=uglyNums[p2]*2;
            int multi_3=uglyNums[p3]*3;
            int multi_5=uglyNums[p5]*5;
            uglyNums[i]=Math.min(multi_2,Math.min(multi_3,multi_5));
            
            if(uglyNums[i]==multi_2)
                  p2++;
    
            if(uglyNums[i]==multi_3)
                  p3++;
            if(uglyNums[i]==multi_5)
                  p5++;
    
        
        }
    return uglyNums[n-1];
    }
}