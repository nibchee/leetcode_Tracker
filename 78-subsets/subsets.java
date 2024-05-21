class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets=new ArrayList<>();

        for(int i=0;i<Math.pow(2,nums.length);i++){
            int number=i;
            ArrayList<Integer> set=new ArrayList<>();
            int k=0;
            while(number!=0){
                if((number&1)==1){
                set.add(nums[k]);
                }
                number=number>>1;
                k++;
            }
          subsets.add(set);
        }
    return subsets;
    }
}