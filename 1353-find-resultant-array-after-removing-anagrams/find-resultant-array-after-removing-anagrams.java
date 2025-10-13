class Solution {
    public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;
    int[] count = new int[26];
    for (char c : s.toCharArray()) {
        count[c - 'a']++;
    }
    for (char c : t.toCharArray()) {
        if (--count[c - 'a'] < 0) {
            return false;
        }
    }
    return true;
}
    public List<String> removeAnagrams(String[] words) {
      List<String> ans=new ArrayList();
      int n=words.length;
      for(int i=0;i<n;){
        int j=i;
        for(j=i;j<n;j++){
            if(j+1<n && isAnagram(words[j],words[j+1])==false){
                break;
            }
        }
      ans.add(words[i]);
      i=j+1;
      }   
    
    return ans;
}
}