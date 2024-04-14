class Solution {
    public String convertToTitle(int columnNumber) {
      String ans="";

      while(columnNumber>0){
        columnNumber=columnNumber-1;
        char ch=(char)(columnNumber%26 +'A');
         ans=ch+ans;
        columnNumber/=26;
      }
      return ans;  
    }
}