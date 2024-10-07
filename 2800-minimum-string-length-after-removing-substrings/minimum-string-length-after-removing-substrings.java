class Solution {
    public int minLength(String s) {
     String ans=s;
     while(ans.indexOf("AB")!=-1 || ans.indexOf("CD")!=-1){
      int s_ab=s.indexOf("AB");
      if(s_ab!=-1){
        if(s_ab==0)
        s=s.substring(s_ab+2);
        else
        s=s.substring(0,s_ab)+s.substring(s_ab+2);
      }
      int s_cd=s.indexOf("CD");
      
      if(s_cd!=-1){
        if(s_cd==0)
        s=s.substring(s_cd+2);
        else
        s=s.substring(0,s_cd)+s.substring(s_cd+2);
      }
       // System.out.println(s_ab+" "+s_cd+" "+s);
     ans=s;
     }
    return s.length();
    }
}