class Solution {
    public boolean canConstruct(String s, int k) {
        if(s.length()<k) return false;
        int freq[]=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        int e=0, o=0;
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
            if(freq[i]%2==0)
            e++;
            else
            o++;
            }
        }
      boolean ans=false;
      if(o>k)
      return false;

      
    // if(o<k && e+o<k)
    // return false;

      return true;
    }
}