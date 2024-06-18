class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n=profit.length;
        int jobs[][]=new int[n][2];
        for(int i=0;i<n;i++){
          jobs[i][0]=difficulty[i];
          jobs[i][1]=profit[i];
        }

        //Sorting Jobs
        Arrays.sort(jobs,(a,b)->{
          return a[0]-b[0];
        });

        //sort worker
        Arrays.sort(worker);

        int ans=0;
        int maxP=0;
        int j=0;
        for(int i=0;i<worker.length;i++){
          int d=worker[i];
          while(j<n && d>=jobs[j][0]){
            maxP=Math.max(maxP,jobs[j][1]);
            j++;
          }
          ans+=maxP;
        }
        return ans;
    }
}