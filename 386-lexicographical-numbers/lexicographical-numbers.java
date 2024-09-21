class Solution {
    public List<Integer> lexicalOrder(int n) {
      List<Integer> ans=new ArrayList<>();
      for(int s=1;s<=9;s++){
        helper(s,n,ans);
      } 
      return ans;  
    }

    private void helper(int num,int limit,List<Integer> ans){
      if(num>limit) return;
      ans.add(num);
      for(int nextDigit=0;nextDigit<=9;nextDigit++){
        int nextNum=num*10+nextDigit;
        if(nextNum>limit) break;
        helper(nextNum,limit,ans);
      }
    }
}