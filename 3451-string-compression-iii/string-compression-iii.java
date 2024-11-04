class Solution {
    public String compressedString(String word) {
        String cmp="";
        int i=0,j=0;
        int n=word.length();
        while(i<n){
            int c=0;
            char ch=word.charAt(i);
            while(j<n && word.charAt(j)==ch){
                c++;
                j++;
            }
           int r=c%9;
           int d=c/9;
           while(d>0){
            cmp=cmp+"9"+ch;
            d--;
           }
           if(r!=0)
           cmp=cmp+(char)('0'+r)+ch;
           i=j;
          // System.out.println(cmp+" "+i+" "+j);
        }
        return cmp;
    }
}