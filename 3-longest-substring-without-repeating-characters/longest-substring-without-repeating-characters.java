class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();

        int ans=0;
        int i=0,j=0;

        int n=s.length();

        while(i<n && j<n){
            char ch=s.charAt(j);
            if(!set.contains(ch)){
            set.add(ch);
            j++;
            }else{
              ans=Math.max(j-i,ans);
              while(set.contains(ch)){
                set.remove(s.charAt(i));
                i++;  
              }
            }
        }
        if(i<n){
            ans=Math.max(n-i,ans);
        }

        return ans;
    }
}