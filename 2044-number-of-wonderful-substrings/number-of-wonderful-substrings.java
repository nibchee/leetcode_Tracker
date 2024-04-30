class Solution {
    public long wonderfulSubstrings(String word) {
        int n=word.length();

        Map<Integer,Integer> freq=new HashMap<>();

        freq.put(0,1);
        int mask=0;

        long res=0l;

        for(int i=0;i<n;i++){
            char c=word.charAt(i);
            int bit=c-'a';
            mask=mask^(1<<bit);
            res+=freq.getOrDefault(mask,0);
            freq.put(mask,freq.getOrDefault(mask,0)+1);

            for(int b=0;b<10;b++){
                res+=freq.getOrDefault(mask^(1<<b),0);
            }
        }
return res;
    }
}