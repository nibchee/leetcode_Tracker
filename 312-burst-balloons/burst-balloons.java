class Solution {
    public int maxCoins(int[] nums) {
       int m = nums.length;

        int dp[][]=new int[m][m];

        for(int g =0;g<m;g++)
        {
            for(int i=0 ,j=g;j<m; i++ , j++)
            {
                int max =Integer.MIN_VALUE;
                
                for(int k =i;k<=j;k++)
                {
                    int left = k==i?0:dp[i][k-1];
                    int right =k==j?0:dp[k+1][j];
                    int val = (i==0?1:nums[i-1])*nums[k]*(j==nums.length-1?1:nums[j+1]);
                    int total = left +right + val;

                    if( total > max)
                    {
                        max = total;
                    }
                }
                dp[i][j] = max;
            }
        }
        return dp[0][m-1];
    }
            }
