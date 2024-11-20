class Solution {
    public int takeCharacters(String s, int k) {
        int n=s.length();
        int freq[]=new int[3];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
      }
      
      if(freq[0]<k ||freq[1]<k ||freq[2]<k )
      return -1;

      int window[]=new int[3];
      int left=0,maxWindow=0;

      for(int r=0;r<n;r++){
        window[s.charAt(r)-'a']++;
        while(left<=r && (window[0]>freq[0]-k ||freq[1]-window[1]<k || freq[2]-window[2]<k)){
            window[s.charAt(left)-'a']--;
            left++;
        }
      maxWindow=Math.max(maxWindow,r-left+1);
     
      }

      return n-maxWindow;
    }
}