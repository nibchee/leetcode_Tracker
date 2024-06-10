class Solution {
    public double myPow(double x, int n) {
        boolean negativeSign = false;
        boolean isMaxMin=false;
        if(n==Integer.MIN_VALUE){
            n+=1;
            isMaxMin=true;
        }
        if (n < 0) {
            negativeSign = true;
            n = -n;
        }

        double ans = helper(x, n);
      
      if(isMaxMin){
             ans=ans*x;    
            }
        if (negativeSign)
            return 1 / ans;

            
        return ans;
    }

    private double helper(double x, int n) {
        if(n==0) return 1;
        if (n == 1)
            return x;

        double ans = helper(x, n / 2);
        ans *= ans;
        if (n % 2 == 1)
            ans = ans * x;
        return ans;
    }
}