class Solution {
    public int sum(int[] a){
      int s=0;
      for(int i:a)
      s+=i;
      return s;
    }
    public int minimumBoxes(int[] apple, int[] capacity) {
        int total_apples=sum(apple);
        Arrays.sort(capacity);
        int cap=0;
        int n=capacity.length-1;
        while(cap<total_apples){
            cap+=capacity[n];
            n--;
        }
    return capacity.length-n-1;
    }
}