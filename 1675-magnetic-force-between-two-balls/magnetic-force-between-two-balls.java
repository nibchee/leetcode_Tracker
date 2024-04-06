class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n=position.length;
        int min=0;
        int max=position[n-1];
        int ans=0;
        while(min<=max){
            int mid=min+(max-min)/2;

            if(is_possible(position,m,mid)){
                ans=mid;
                min=mid+1;
            }else{
                max=mid-1;
            }
        }

        //now we have got the distance
        //now cal force
        //System.out.println(ans);
        //return force(position,ans);
        return ans;
    }

    private int force(int[] position,int dist){
        int force=Integer.MAX_VALUE;
         int last_placed=position[0];

      for(int i=1;i<position.length;i++){
        if(position[i]-last_placed>=dist){
            force=Math.min(position[i]-last_placed,force);
            last_placed=position[i];
        }
    }
    return force;
    }

    private boolean is_possible(int[] position,int m, int dist){
      //place first ball
      int last_placed=position[0];
      int balls=1;

      for(int i=1;i<position.length;i++){
        if(position[i]-last_placed>=dist){
            last_placed=position[i];
            balls++;
        }

        if(balls==m)
        return true;
        }
      return false;
      }
    


}