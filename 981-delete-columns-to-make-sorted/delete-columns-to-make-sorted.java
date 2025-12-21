class Solution {
    public int minDeletionSize(String[] strs) {
        int count=0;
       for(int j=0;j<strs[0].length();j++){
         String s="";
        for(int i=0;i<strs.length;i++){
           s+=strs[i].charAt(j);
           }

           for(int k=0;k<s.length()-1;k++){
              if(s.charAt(k)>s.charAt(k+1))
              {
                count++;
                break;
              }          
           }
       }


       return count;
    }
}