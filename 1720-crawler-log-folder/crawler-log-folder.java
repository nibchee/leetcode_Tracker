class Solution {
    public int minOperations(String[] logs) {
        int op=0;
        for(String log:logs){
          char ch1=log.charAt(0);
          char ch2=log.charAt(1);
          
              if(ch1=='.'){
                if(ch2=='.' && op>0){
                   op--;
                }
              }else{
                op++;
              }
        }
        return (op<=0)?0:op;
    }
}