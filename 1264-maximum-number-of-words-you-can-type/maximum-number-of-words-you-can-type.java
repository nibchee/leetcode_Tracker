class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        
        int count = 0;
        for (String word : text.split(" ")) {
            boolean  valid = true;
            for (char c : brokenLetters.toCharArray()) {
                if (word.indexOf(c) != -1) {
                    valid = false;
                    break;
                }
            }
            if (valid) count++;
        }
        return count;
    }
}