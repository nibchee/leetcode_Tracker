class Solution {
    public String getHint(String secret, String guess) {
       HashMap<Character,Integer> map=new HashMap<>();
      int cows=0;
      int bulls=0;
    
       for(int i=0;i<secret.length();i++){
        char ch=secret.charAt(i);
        if(ch==guess.charAt(i))
        bulls++;
        else{
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
       }
        
       for(int i=0;i<guess.length();i++){
        char ch=guess.charAt(i);
        if(secret.charAt(i)==ch)
        continue;
        if(map.containsKey(ch) && map.get(ch)>0){
            cows++;
            if(map.get(ch)-1==0){
                map.remove(ch);
            }else{
                map.put(ch,map.get(ch)-1);
            }
        }
        
       }
       return Integer.toString(bulls)+'A'+Integer.toString(cows)+'B';
    }
}