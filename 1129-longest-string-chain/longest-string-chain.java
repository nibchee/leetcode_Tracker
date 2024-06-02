class Solution {
    private boolean differByOne(String s1, String s2) {
        if (s1.length() - s2.length() != 1)
            return false;

        int i = 0, j = 0;
        while (i < s1.length()) {
            if (j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }

        if (i == s1.length() && j == s2.length())
            return true;
        return false;
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (s1, s2) -> s1.length() - s2.length());
        int n = words.length;
        // for(String s:words)
        // System.out.print(s+" ");

        int dp[] = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                // word[i].length > word[j].length
                if (differByOne(words[i], words[j]) && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}