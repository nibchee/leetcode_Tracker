class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans=0l;
        Arrays.sort(happiness);
        int turn=0;
        for(int i=happiness.length-1;i>=0 && turn<k;i--){
            ans+=Math.max(happiness[i]-turn,0);
            turn++;
        }
    return ans;
    }
}