class Solution {
    public String rev(String s){
         String rev="";
         for(int i=s.length()-1;i>=0;i--){
            rev=rev+s.charAt(i);
         }
         return rev;
    }
    public boolean isSubstringPresent(String s) {
        String rev=rev(s);
        for(int i=0;i<s.length()-1;i++){
            String substr=""+s.charAt(i)+s.charAt(i+1);
            if(rev.indexOf(substr)>=0)
            return true;
        }
    return false;
    }
}