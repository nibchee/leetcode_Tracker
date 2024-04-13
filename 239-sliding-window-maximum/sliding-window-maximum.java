class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int[] ans=new int[n-k+1];
        int idx=0;
        Deque<Integer> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            //at first check peek element if <i-k as have to store max i-k
            if(!q.isEmpty() && q.peekFirst()<=i-k)
            q.removeFirst();

            //have to store in decreasing fashion so remove smaller elements than nums[i]
            while(!q.isEmpty() && nums[i]>nums[q.peekLast()])
            q.removeLast();

            //offereing current element index to q
            q.add(i);

            //start storing ans if i>=k-1
            if(i>=k-1)
            ans[idx++]=nums[q.peek()];
        }
        return ans;
    }
}