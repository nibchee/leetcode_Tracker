class Solution {
    List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans=new ArrayList<String>();
        helper(n,0,0,"");
        return ans;
    }

    private void helper(int n,int open,int close,String curr){
        if(close==n) ans.add(new String(curr));
        if(open<n)
        helper(n,open+1,close,curr+'(');

        if(open>close)
        helper(n,open,close+1,curr+')');
    }
}