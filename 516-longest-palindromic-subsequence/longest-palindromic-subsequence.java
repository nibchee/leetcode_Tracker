class Solution {
    private String rev(String s){
        String res="";
        for(int i=s.length()-1;i>=0;i--){
           res+=s.charAt(i);
        } 
        return res;  
         }
    public int longestPalindromeSubseq(String s) {
        String r=rev(s);
        int m=s.length();
        int n=r.length();
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++)
        dp[i][0]=0;
        for(int j=0;j<=n;j++)
        dp[0][j]=0;

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==r.charAt(j-1))
                dp[i][j]=1+dp[i-1][j-1];
                else
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
           //     System.out.print(dp[i][j]+" ");
            }
            //System.out.println();
        }


        // for(int i=0;i<m+1;i++){
        //     for(int j=0;j<n+1;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }

        
    return dp[m][n];
    }
}