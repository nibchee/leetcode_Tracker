class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int ans[] = new int[n];
        if (k == 0) {
            Arrays.fill(ans, 0);
        } else if (k < 0) {
            k = -k;
            int prefix_sum[] = new int[n];
            for (int i = 0; i < k; i++)
                prefix_sum[0] += code[(n - i - 1) % n];

            for (int i = 1; i < n; i++)
                prefix_sum[i] = prefix_sum[i - 1] + code[i - 1] - code[(n+i-k-1) % n];

            for (int i = 0; i < n; i++) {
                ans[i] = prefix_sum[i];
            }
        } else {
            int suffix_sum[] = new int[n];
            for (int i = 0; i < k; i++)
                suffix_sum[0] += code[i % n];

            for (int i = 1; i < n; i++) {
                suffix_sum[i] = suffix_sum[i - 1] - code[i - 1] + code[(i + k - 1) % n];
            }

            for (int i = 0; i < n; i++) {
                ans[i] = suffix_sum[(i + 1) % n];
            }
        }
        return ans;
    }
}