class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> q=new PriorityQueue<Integer>();
        for(int i=0;i<nums.length;i++){
            q.add(nums[i]);
        }
        while(k>0 ){
            int e=q.remove();
            q.add(-e);
            k--;
        }

        // if(k%2==1){
        //     int e=q.remove();
        //     q.add(-e);
        // }

        int sum=0;
        while(q.size()>0){
             sum+=q.remove();
        }
    return sum;
    }
}