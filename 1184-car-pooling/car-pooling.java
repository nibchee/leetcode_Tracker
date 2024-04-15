class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
     int min_stop=1000;
     int max_stop=0;
     for(int [] trip:trips){
        min_stop=Math.min(min_stop,trip[1]);
        max_stop=Math.max(max_stop,trip[2]);
     }


     for(int i=min_stop;i<=max_stop-1;i++){
        int s=i;
        int d=s+1;
        int c=0;
       
        for(int [] trip:trips){
            if(s>=trip[1] && d<=trip[2])
            c+=trip[0];
               if(c>capacity)
               return false;
        }
        // System.out.println(s+"->"+d+" Capacity="+c);
     }

    return true;
    }
}