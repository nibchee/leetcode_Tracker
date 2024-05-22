class Solution {
    List<List<String>> ans;
    public List<List<String>> partition(String s) {
        ans=new ArrayList<>();
        helper(s,new ArrayList<>());
        return ans;
    }

    public void helper(String s,ArrayList<String> myCurrentPartitions){
        if(s.length()==0){
            ans.add(new ArrayList<>(myCurrentPartitions));
        }
        for(int i=1;i<=s.length();i++){
            String prefix=s.substring(0,i);
            String remaining=s.substring(i);
            if(isPallindrome(prefix)){
                myCurrentPartitions.add(prefix);
                helper(remaining,myCurrentPartitions);
                 myCurrentPartitions.removeLast();
            }
        }
    }


    public boolean isPallindrome(String s){
        int l=0,r=s.length()-1;
        while(l<=r){
            if(s.charAt(l)!=s.charAt(r)){
                return false;
            }
        l++;
        r--;
        }
return true;
    }
}