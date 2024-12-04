class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int l1=str1.length();
        int l2=str2.length();
        int i=0,j=0;
        while(i<l1 && j<l2){
              if (str1.charAt(i) == str2.charAt(j) ||
                (str1.charAt(i) + 1 == str2.charAt(j)) ||
                (str1.charAt(i) - 25 == str2.charAt(j))) {
                j++;
            }
        i++;
        }
     return j==l2;
    }
}