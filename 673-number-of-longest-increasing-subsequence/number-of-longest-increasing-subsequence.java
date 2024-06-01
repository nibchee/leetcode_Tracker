class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n];
        int count[] = new int[n];
        // As all can be DP so atleats having length 1
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int max_Len = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if(dp[j]+1==dp[i]){
                        count[i] += count[j];
                    }
                }
            }
            //System.out.print(dp[i] + " ");
            max_Len = Math.max(max_Len, dp[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(dp[i]==max_Len)
            ans+=count[i];
        }
        return ans;
    }
}