class Solution {
    HashMap<Character,String> phoneKeys;
    List<String> ans;
    public List<String> letterCombinations(String digits) {
      phoneKeys=new HashMap<>();
         phoneKeys.put('2',"abc");
         phoneKeys.put('3',"def");
         phoneKeys.put('4',"ghi");
         phoneKeys.put('5',"jkl");
         phoneKeys.put('6',"mno");
         phoneKeys.put('7',"pqrs");
         phoneKeys.put('8',"tuv");
         phoneKeys.put('9',"wxyz");

        ans=new ArrayList<>();
        helper("",0,digits);
        return ans;
    }

    private void helper(String s,int idx,String digits){
      if(idx==digits.length()){
        if(s.length()>0)
        ans.add(s);
        return;
      }

      char ch=digits.charAt(idx);
      for(char c: phoneKeys.get(ch).toCharArray()){
      helper(s+c,idx+1,digits);
      }
    }
}