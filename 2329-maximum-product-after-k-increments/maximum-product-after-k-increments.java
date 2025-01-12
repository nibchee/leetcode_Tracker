class Solution {
    int MOD=1000_000_007;
    public int maximumProduct(int[] nums, int k) {
       PriorityQueue<Integer> pq=new PriorityQueue<>();
       for(int num:nums)
       pq.add(num);

       while(k!=0){
        int ele=pq.remove();
        pq.add(ele+1);
        k--;
       }

       long ans=1;
       while(!pq.isEmpty()){
        ans=(ans*pq.remove())%MOD;
       }

       return (int)ans;

    }
}