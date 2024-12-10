class Solution {
    public int maximumLength(String s) {
        HashMap<Pair<Character, Integer>,Integer> freq=new HashMap<>();
        int i=0,j=0;
        int n=s.length();
        while(i<n && j<n){
            char ch=s.charAt(i);
           while(j<n && ch==s.charAt(j)){
              j++;
           }
           putSpecialStringFreq(freq,ch,i,j);
           i=j;
        }
        int ans=-1;
        for(Map.Entry<Pair<Character, Integer>,Integer> entry: freq.entrySet()){
         int l=entry.getKey().getValue();
         int count=entry.getValue();
         if(count>=3)
            ans=Math.max(ans,l);
         }
        
        return ans;
    }

    private void putSpecialStringFreq(HashMap<Pair<Character, Integer>,Integer> freq,char ch,int i,int j){
         int len=j-i;
         for(Integer k=1;k<=len;k++){
            Pair<Character, Integer> key = new Pair<>(ch,k);
           freq.put(key,freq.getOrDefault(key,0)+len-k+1);
         }
    }
}