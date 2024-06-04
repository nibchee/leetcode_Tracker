class Solution {
    int []dp;
    private boolean isPallindrome(int i,int j,String s){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
            return false;
            i++;
            j--;
        }
        return true;
    }
    private int helper(int i,String s){
      if(i==s.length()) return 0;
      if(dp[i]!=0) return dp[i];
       int min_cuts=Integer.MAX_VALUE;
        for(int j=i;j<s.length();j++){
            if(isPallindrome(i,j,s)){
              int cuts=1+helper(j+1,s);
              min_cuts=Math.min(min_cuts,cuts);
            }
        }
        return dp[i]= min_cuts;
    }
    public int minCut(String s) {
        int n=s.length();
        dp=new int[n];
        return helper(0,s)-1;
    }
}