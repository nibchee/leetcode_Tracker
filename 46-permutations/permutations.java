class Solution {
    
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<Integer> temp=new ArrayList<>();
        List<List<Integer>> ans=new ArrayList<>();
        permute(temp,nums,ans);
     return ans;
    }

    private void permute(ArrayList<Integer> temp,int[] nums,List<List<Integer>> ans){
        if(temp.size()==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(temp.contains(nums[i]))
            continue;
            
            temp.add(nums[i]);
            permute(temp,nums,ans);
            temp.remove(temp.size()-1);
        }
    }
}