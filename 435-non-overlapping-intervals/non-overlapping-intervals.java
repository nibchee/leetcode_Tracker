class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(int[] a, int[] b)->{
            return a[0]-b[0];
        });
        int previous=0;
        int n=intervals.length;
        int ans=0;
        for(int current=1;current<n;current++){
            //[1 5][3 6] Overlapping
            //[1 5][8 10] Non Overlapping
            //[1 5] [2 3 ]
            if(intervals[current][0]<intervals[previous][1]){
                //deleting
                ans++;
                if(intervals[current][1]<intervals[previous][1]){
                      previous=current;
                }
            }else{
                //[1 5][8 11]
                //change previos
                previous=current;
            }
        }
    return ans;
    }
}