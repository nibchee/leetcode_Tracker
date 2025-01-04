class Solution {
    public int countPalindromicSubsequence(String s) {
      HashMap<Character,int[]> map =new HashMap<>();

      for(int i=0;i<s.length();i++){
        Character ch=s.charAt(i);
        int[] pair=map.getOrDefault(ch,new int[]{s.length(),-1});
        pair[0]=Math.min(pair[0],i);
        pair[1]=Math.max(pair[1],i);
        map.put(ch,pair);
      }
      
      int ans=0;
      for(Map.Entry<Character,int[]> entry:map.entrySet()){
        char key=entry.getKey();
        int[] pair=entry.getValue();
        HashSet<Character> set=new HashSet<>();
        for(int i=pair[0]+1;i<pair[1];i++){
          set.add(s.charAt(i));
        }
        ans+=set.size();
      }


return ans;
    }
}