class Solution {
    public int maxFreqSum(String s) {
        int[] freq=new int[26];
        int maxv=0,maxc=0;
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                maxv=Math.max(freq[ch-'a'],maxv);
            }else
            maxc=Math.max(freq[ch-'a'],maxc);

        }
        return maxc+maxv;
    }
}