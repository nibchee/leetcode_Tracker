class Solution {
    public int findTheLongestSubstring(String s) {
        int prefix=0;
        int[] charMap=new int[26];
        charMap['a'-'a']=1;
        charMap['e'-'a']=2;
        charMap['i'-'a']=4;
        charMap['o'-'a']=8;
        charMap['u'-'a']=16;

        int mp[]=new int[32];

        for(int i=0;i<32;i++)mp[i]=-1;

        int ans=0;

        for(int i=0;i<s.length();i++){
          prefix^=charMap[s.charAt(i)-'a'];
          if(mp[prefix]==-1 && prefix!=0)
          mp[prefix]=i;

          ans=Math.max(ans,i-mp[prefix]);
        }

        return ans;
        
    }
}