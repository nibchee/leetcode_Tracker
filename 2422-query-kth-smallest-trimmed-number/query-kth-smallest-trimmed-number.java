class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int len = nums[0].length(); 
        int n = nums.length; 
        String[][][] ds = new String[len][n][2];

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < n; j++) {
                String trimmed = nums[j].substring(len - i - 1); 
                ds[i][j][0] = trimmed; 
                ds[i][j][1] = String.valueOf(j);
            }
            Arrays.sort(ds[i], (a, b) -> {
                if (!a[0].equals(b[0])) {
                    return a[0].compareTo(b[0]); 
                }
                return Integer.compare(Integer.parseInt(a[1]), Integer.parseInt(b[1])); 
            });
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0] - 1; 
            int trim = queries[i][1] - 1;
            ans[i] = Integer.parseInt(ds[trim][k][1]);
        }
        
        return ans;
    }
}