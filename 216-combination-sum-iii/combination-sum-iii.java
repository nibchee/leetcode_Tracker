class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans=new ArrayList<>();
        helper(k,n,new ArrayList<Integer>(),1);
        return ans;
    }

    private void helper(int k,int n,ArrayList<Integer> ds,int idx){
      if(n==0){
        if(k==0)
        ans.add(new ArrayList<Integer>(ds));
        return;
      }

      for(int i=idx;i<=9;i++){
        ds.add(i);
        if(n-i>=0)
        helper(k-1,n-i,ds,i+1);
        ds.remove(ds.size()-1);
      }
    }
}