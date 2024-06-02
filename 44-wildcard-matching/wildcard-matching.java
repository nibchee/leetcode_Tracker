class Solution {
   Boolean dp[][];
    private boolean helper(int i,int j,String s,String p){
        if(i==-1 && j==-1)
        return true;
        if(i==-1){
            if(p.charAt(j)=='*')
            return helper(i,j-1,s,p);
            else
            return false;
        }
        if(j==-1) return false;
        if(dp[i][j]!=null)
        return dp[i][j];
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')
        return dp[i][j]=helper(i-1,j-1,s,p);

        if(p.charAt(j)=='*')
        return dp[i][j]=helper(i,j-1,s,p)||helper(i-1,j,s,p)||helper(i-1,j-1,s,p);

//no match
return false;
    }
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();
        dp=new Boolean[m][n];
        return helper(m-1,n-1,s,p);
    }
}