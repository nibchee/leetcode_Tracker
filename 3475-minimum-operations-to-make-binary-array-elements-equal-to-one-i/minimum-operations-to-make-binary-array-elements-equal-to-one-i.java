class Solution {
    public int minOperations(int[] nums) {
        Deque<Integer> dq=new ArrayDeque<>();
        int c=0;

        for(int i=0;i<nums.length;i++){
            while(!dq.isEmpty() && i>dq.peekFirst()+2){
                dq.pollFirst();
            }

            if((nums[i]+dq.size())%2==0){
                if(i+2>=nums.length){
                    return -1;
                }
                c++;
                dq.offerLast(i);
            }
        }
    return c;
    }
}