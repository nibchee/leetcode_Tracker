class Solution {
    public String reverseWords(String s) {
     int space=0;
     s=s.trim();
     s+=" ";

     int i=0;
     String ans="";
     while(i<s.length()){
        //getting space
        while(s.charAt(space)!=' '){
            space++;
        }

        //adding reverse in ans
        for(int j=space;j>=i;j--){
            ans+=s.charAt(j);
        }
    
        //changing i to next word first letter & space to non space char 
        i=space+1;
        space++;
     }   
     
     return ans.trim();
    }
}