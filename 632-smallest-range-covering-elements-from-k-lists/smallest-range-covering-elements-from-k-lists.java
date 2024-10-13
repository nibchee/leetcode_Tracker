class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        Queue<int[]> q=new PriorityQueue<>((int[] a,int[] b)->{
          return a[0]-b[0];
        });

       for(int i=0;i<nums.size();i++){
        for(int j=0;j<nums.get(i).size();j++){
          int arr[]={nums.get(i).get(j),i};
          q.add(arr);
        //  System.out.println(nums.get(i).get(j)+" "+i);
        }
       }
      //  System.out.println(q.size());
        int queue_size=q.size();
       int arr[][]=new int[q.size()][2];
       for(int i=0;i<queue_size;i++){
         int a[]=q.remove();
         arr[i][0]=a[0];
         arr[i][1]=a[1];
      //  System.out.println("("+arr[i][0]+","+arr[i][1]+")");
       }

       int i=0,j=0;
       int n=arr.length;
        HashMap<Integer,Integer> m=new HashMap<>();
        int ans[]=new int[2];
        ans[0]=Integer.MAX_VALUE;
       while(i<n && j<n){
            m.put(arr[j][1],m.getOrDefault(arr[j][1],0)+1);
           // System.out.println(i+"--"+j+" Map size "+m.size()+" "+arr[j][0]+" "+arr[j][1]);
            while(m.size()==nums.size()){
                int start=arr[i][0];
                int end=arr[j][0];
                //System.out.println(arr[i][0]+"- "+arr[j][0]);
                if(start<ans[0]|| (end-start)<(ans[1]-ans[0])){
                  ans[0]=start;
                  ans[1]=end;
                }
                m.put(arr[i][1],m.get(arr[i][1])-1);
                if(m.get(arr[i][1])==0)
                m.remove(arr[i][1]);
                i++;
            }
         j++;
       }
       
             return ans;
    }
}