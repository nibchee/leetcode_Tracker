class Solution {
    public List<String> letterCasePermutation(String s) {
     List<String> ans=new ArrayList<>();
     helper(s,ans,0);   
     return ans;     
    }

    private void helper(String s, List<String> ans,int i){
        //base case
        if(i==s.length()){
          ans.add(s);
          return;
        }
        
        char ch=s.charAt(i);
        //if alphabet
        if(ch>='a' && ch<='z'){
          String newString=s.substring(0,i)+Character.toUpperCase(ch)+s.substring(i+1);
          helper(newString,ans,i+1);
        }else if(ch>='A' && ch<='Z'){
              String newString=s.substring(0,i)+Character.toLowerCase(ch)+s.substring(i+1);
          helper(newString,ans,i+1);
        }
        
          //as to be tried always
          helper(s,ans,i+1); 
        
    }
}
