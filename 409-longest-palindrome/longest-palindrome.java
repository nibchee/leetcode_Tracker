class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character,Integer> m=new HashMap<>();
        for(char ch: s.toCharArray())
        {
            m.put(ch,m.getOrDefault(ch,0)+1);
        }
        int max=0;
        int count=0;
        boolean hasOdd=false;
        for(Map.Entry<Character,Integer> e:m.entrySet()){
           int v=e.getValue();
            if(v%2==0){
               count+=v;
            }else{
                count+=(v-1);
                hasOdd=true;
            }
        }
        if(hasOdd) count++;
        return count;
    }
}