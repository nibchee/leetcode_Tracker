class Solution {
    public int[] plusOne(int[] digits) {
        int n=digits.length;
        int r=1;
        for(int i=n-1;i>=0;i--){
                 int s=digits[i]+r;
                 r=s/10;
                 digits[i]=s%10;
        }
        int ans[]=(r==1)?new int[n+1]:new int[n];
        if(r==1){
          ans[0]=1;
          for(int i=1;i<=n;i++)
          ans[i]=digits[i-1];
        }else{
          for(int i=0;i<n;i++)
          ans[i]=digits[i];
        }

        return ans;
    }
}