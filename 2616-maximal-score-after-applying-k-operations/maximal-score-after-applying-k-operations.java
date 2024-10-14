class Solution {
    public long maxKelements(int[] nums, int k) {
     PriorityQueue<Integer> q=new PriorityQueue<Integer>(Collections.reverseOrder());
     for(int i=0;i<nums.length;i++){
      q.add(nums[i]);
     }
     long ans=0;
     for(int i=0;i<k;i++){
      int ele=q.remove();
      int newEle=(int)Math.ceil((double)ele/3);
      ans+=ele;
      q.add(newEle);
     } 
    return ans;
    }
}