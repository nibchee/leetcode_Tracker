class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n=s.length();
        int i=0,j=0;
        int cost=0;
        int maxLen=0;
        while(i<n && j<n){
           cost+=Math.abs(s.charAt(j)-t.charAt(j));
            if(cost<=maxCost)
            maxLen=Math.max(maxLen,j-i+1);
             
           while(cost>maxCost){
             cost-=Math.abs(s.charAt(i)-t.charAt(i));
             i++;
           }
           j++;
        }
        return maxLen;
    }
}