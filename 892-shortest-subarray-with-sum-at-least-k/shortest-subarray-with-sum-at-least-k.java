class Solution {
    public int shortestSubarray(int[] nums, int k) {
     int n=nums.length;
     int ans=n+1;
     long sum=0;

     PriorityQueue<Pair<Long,Integer>> prefix=new PriorityQueue<>((a,b)->Long.compare(a.getKey(),b.getKey()));

     for(int i=0;i<n;i++){
        sum+=nums[i];

        if(sum>=k){
            ans=Math.min(ans,i+1);
        }

        while(!prefix.isEmpty() && sum-prefix.peek().getKey()>=k){
            ans=Math.min(ans,i-prefix.poll().getValue());
        }
        prefix.offer(new Pair<>(sum,i));
     }

     return ans==n+1?-1:ans;   
    }
}