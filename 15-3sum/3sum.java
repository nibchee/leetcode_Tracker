class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();

        //sort  the nums
        Arrays.sort(nums);

        //iterating sorted array
        for(int i=0;i<=nums.length-3;i++){

            int k1=nums[i];
            if(i!=0 && k1==nums[i-1]){
                continue;
            }

            int l=i+1;
            int r=nums.length-1;
               
            while(l<r){
                if(nums[l]+nums[r]+k1==0){
                    ArrayList<Integer> list=new ArrayList<>();
                    list.add(nums[l]);
                    list.add(nums[r]);
                    list.add(k1);
                    ans.add(list);
             while(l<r && nums[l]==nums[l+1]) l++;
            while(l<r && nums[r]==nums[r-1]) r--;
            
                    l++;
                    r--;
                }
             else if(nums[l]+nums[r]+k1<0){
                l++;
             }else{
                r--;
             }
            }

        }
        return ans;
    }
}