class Solution {
    public int shipWithinDays(int[] weights, int days) {
     //  Arrays.sort(weights);
       int max=find_max(weights);
       int s=0;
       for(int i=0;i<weights.length;i++){
       s+=weights[i]; 
       }

       int l=max;
       int h=s;

       int ans=h;
       while(l<=h){
           int m=l+(h-l)/2;

           int day=pack_wt(weights,m);
       //   System.out.println(l+" "+m+" "+h+" "+day);
              if(day<=days){
                //assume this can be ans
                  ans=m;
                 h=m-1;
              }else{
                l=m+1;
              }                         
       }
    
    return ans;
    }

    public static int find_max(int piles[]){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++){
            if(max<piles[i])
            max=piles[i];
        }
        return max;
    }

    public int pack_wt(int []weights,int wt){
     int count=0;
     int box_capacity=wt;
     int days=1;
     int i=0;
     while(i<weights.length){
        if(box_capacity-weights[i]>=0){
        box_capacity=box_capacity-weights[i];
        i++;
        }else{
            //box is full so assignt new & increment count
            days++;
            box_capacity=wt;
        }
     }
     return days;
    }
}