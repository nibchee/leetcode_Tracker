class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
        if(a[0]==b[0])
        return b[1]-a[1];
        return a[0]-b[0];
        });
        int count=0;
        int prev=0;
        int n=intervals.length;
        for(int curr=1;curr<n;curr++){
          if(intervals[curr][0]>=intervals[prev][0] && intervals[curr][1]<=intervals[prev][1]){
            //remove
            count++;
            //no need to change prev
          }else{
            //not covering but might be overlapping change pointers
            prev=curr;
          }
        }
        return n-count;
    }
}