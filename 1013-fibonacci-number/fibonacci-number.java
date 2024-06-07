class Solution {
    public int fib(int n) {
        return helper(n);
    }
    private int helper(int n){
       if(n<=1) return n;
        return helper(n-1)+helper(n-2);
    }
}