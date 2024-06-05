class Solution {
    public List<String> commonChars(String[] words) {
        int a1[] = new int[26];

        for (char ch : words[0].toCharArray())
            a1[ch - 'a']++;

        for (String s : words) {
            int a2[] = new int[26];
            for (char ch : s.toCharArray()) {
                a2[ch - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                a1[i] = Math.min(a1[i], a2[i]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < a1[i]; j++) {
                ans.add("" + (char)('a' + i));
            }
        }
        return ans;
    }
}