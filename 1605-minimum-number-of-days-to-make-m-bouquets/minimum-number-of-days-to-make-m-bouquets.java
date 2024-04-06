class Solution {
    private boolean possible(int[] bloomDay,int m,int k,int days){
        int bouquets=0;
        int i=0;
        while(i<bloomDay.length-k+1){
            boolean Kconsequetiveflowers=true;
            int j=i;
            while(j<=i+k-1){
              if(bloomDay[j]>days){
                Kconsequetiveflowers=false;
                break;
              }
              j++;
            }

            if(Kconsequetiveflowers){
               bouquets++;
               i=j; 
            }else{
                //not found consequtive
                i=j+1;
            }

            if(bouquets==m)
            return true;
        }

      return false; 
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int flowers=bloomDay.length;
        if((m*k)>flowers)
        return -1;

        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;

        for(int i=0;i<flowers;i++){
            min=Math.min(min,bloomDay[i]);
            max=Math.max(max,bloomDay[i]);
        }
        
        int ans=-1;
        while(min<=max){
            int days=min+(max-min)/2;
           // System.out.println(days+" "+min+" "+max+" "+possible(bloomDay,m,k,days));
            if(possible(bloomDay,m,k,days)){
                ans=days;
                //reduce days & try
                 max=days-1;
            }else{
                min=days+1;
            }
        }
        return ans;
    }
}