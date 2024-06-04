class Solution {
    int dp[];
    private int helper(int i, int[] arr, int k) {
        if (i == arr.length)
            return 0;
            if(dp[i]!=0) return dp[i];
        int maxEle = arr[i];
        int maxVal = 0;
        for (int j = i; j < i + k && j < arr.length; j++) {
            maxEle = Math.max(maxEle, arr[j]);
            int rest = helper(j + 1, arr, k);
            maxVal = Math.max(maxVal, maxEle * (j - i + 1) + rest);
        }
        return dp[i]=maxVal;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
       dp=new int[arr.length+1];
       for(int i=arr.length-1;i>=0;i--){
        int maxEle = arr[i];
        int maxVal = 0;
        for (int j = i; j < i + k && j < arr.length; j++) {
            maxEle = Math.max(maxEle, arr[j]);
            int rest = dp[j + 1];
            maxVal = Math.max(maxVal, maxEle * (j - i + 1) + rest);
        }
         dp[i]=maxVal;
       }
        //return helper(0, arr, k);
        return dp[0];
    }
}