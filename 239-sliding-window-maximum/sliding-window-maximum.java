class Solution {
    public int[] maxSlidingWindow(int[] input, int k) {
    ArrayDeque<Integer> deque=new ArrayDeque<>();
      int[] ans=new int[input.length-k+1];
      int start=0;

      //itertaing input & expanding window to slide if shrinks
      for(int end=0;end<input.length;end++){
          //removing elements from first
          while(!deque.isEmpty() && input[end]>deque.getLast()){
              deque.removeLast();
          }

          //adding endth ele
          deque.addLast(input[end]);

          //if window size==k , add ele in ans & shrink window by 1
          if(end-start+1==k){
              //adding ans
              ans[start]=deque.getFirst();
             //removing front ele if not needed for next subarray
             if(deque.getFirst()==input[start]){
                 deque.removeFirst();
             }
             //shrink window
             start++;
          }
      }  
        return ans;    
    }
}