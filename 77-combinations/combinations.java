class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
         ArrayList<Integer> list=new ArrayList<>();
        helper(0,n,k,list);
        return ans;
    }

    private void helper(int idx,int n,int k,ArrayList<Integer> list){
         if(k==0){
           ans.add(new ArrayList<Integer>(list));
           return;
         }
         if(idx==n+1)
         return;
         for(int i=idx+1;i<=n;i++){
            list.add(i);
            helper(i,n,k-1,list);
            list.remove(list.size()-1);
         }

    }
}