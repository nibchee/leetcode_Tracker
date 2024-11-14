class Solution {


    private boolean canDistribute(int x,int[] a,int n){
        int j=0;
        int items_left=a[j];

        for(int i=0;i<n;i++){
            if(items_left<=x){
                j++;
                if(j==a.length) return true;
                else
                items_left=a[j];
            }else{
                items_left-=x;
            }
        }
        return false;
    }

    public int minimizedMaximum(int n, int[] quantities) {
    int min=0;
      int max=0;
      for(int i=0;i<quantities.length;i++){
        max=Math.max(quantities[i],max);
      }
     
     while(min<max){
        int mid=(min+max)/2;
      //  System.out.println(min+" "+mid+" "+max);
        if(canDistribute(mid,quantities,n)){
          max=mid;
        }else{
           min=mid+1;
        }
     }
    return min;
    }
}