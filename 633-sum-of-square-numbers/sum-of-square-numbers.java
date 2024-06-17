class Solution {
    public boolean judgeSquareSum(int c) {
         int i=1;
        
        //  while(i*i<=c)
        //  i++;

         long left=0;
         long right=(long)Math.sqrt(c);
         while(left<=right){
          long res=left*left+right*right;
         // System.out.println(left+" " +right+" "+res);
          if(res==c)
          return true;
          else if(res<c)
          left++;
          else
          right--;
         }
        return false;
    }
}