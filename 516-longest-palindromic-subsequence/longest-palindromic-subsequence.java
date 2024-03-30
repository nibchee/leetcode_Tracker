class Solution {
    private String rev(String s){
        String rev="";
        for(int i=s.length()-1;i>=0;i--){
            rev+=s.charAt(i);
        }
        return rev;
    }
    public int longestPalindromeSubseq(String s) {
        String r=rev(s);
        int l=s.length();
        int dp[][]=new int[l+1][l+1];

        for(int i=1;i<l+1;i++){
            for(int j=1;j<l+1;j++){
              if(s.charAt(i-1)==r.charAt(j-1))
              dp[i][j]=dp[i-1][j-1]+1;
              else
              dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
    return dp[l][l];
    }
}