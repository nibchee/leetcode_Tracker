class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> s=new HashSet<>();
        for(int num:banned){
            if(num>=1 && num<=n)
            s.add(num);
        }

        int count=0;
        int sum=0;
        for(int i=1;i<=n;i++){
             if(!s.contains(i) && sum+i<=maxSum){
                count++;
                sum+=i;
             }
             if(sum+i>maxSum)
             break;
        }
        return count;
    }
}