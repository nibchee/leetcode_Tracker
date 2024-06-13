class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
         List<List<Integer>> ans=new ArrayList<>();
       ArrayList<Integer> indices=new ArrayList<>();
        permute(nums,indices,ans);
        return ans;
    }
    
     private void permute(int[] nums,ArrayList<Integer> indices,List<List<Integer>> ans){

       if(indices.size()==nums.length){
        ArrayList<Integer> list=new ArrayList<>();
        for(Integer i:indices){
          list.add(nums[i]);
        }
        if(!ans.contains(list))
        ans.add(list);
       }
        for(int i=0;i<nums.length;i++){
            if(indices.contains(i))
            continue;
            indices.add(i);
            permute(nums,indices,ans);
            indices.remove(indices.size()-1);
        }
    }
}