class Solution {
    int dp[][];
    private int helper(int i,int j,int[] cuts){
        if(j-i==1) return 0;
        if(dp[i][j]!=0) return dp[i][j];
    int min_cost=Integer.MAX_VALUE;
        for(int idx=i+1;idx<=j-1;idx++){
          int cost=(cuts[j]-cuts[i])+helper(i,idx,cuts)+helper(idx,j,cuts);
          min_cost=Math.min(min_cost,cost);
        }
        return dp[i][j]=min_cost;
    }

    public int minCost(int n, int[] cuts) {
        int m = cuts.length;
        int[] newCuts = new int[m + 2];
        for (int i = 0; i < m; i++)
            newCuts[i] = cuts[i];
        
        newCuts[m] = n;
        Arrays.sort(newCuts);
        dp=new int[m+2][m+2];
        
        return helper(0, m + 1, newCuts);

    }
}