class Solution {
    int dp[][];
    private int helper(int i, int j, String word1, String word2) {
        // word1 got exhausted
        if (i < 0)
            return j + 1; // J+1 Insertion operations

        // word2 gets exhausted
        if (j < 0)
            return i + 1; // I+1 deletion operations

            if(dp[i][j]!=-1) return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j))
            return dp[i][j]=helper(i - 1, j - 1, word1, word2);

        return dp[i][j]=1 + Math.min(
                helper(i, j - 1, word1, word2), /** Insertion */
                Math.min(helper(i - 1, j, word1, word2), /** Deletion */
                        helper(i - 1, j - 1, word1, word2)/** Replace */
                ));
    }

    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        dp=new int[m][n];
        for(int[] arr:dp)
        Arrays.fill(arr,-1);
        return helper(m - 1, n - 1, word1, word2);
    }
}