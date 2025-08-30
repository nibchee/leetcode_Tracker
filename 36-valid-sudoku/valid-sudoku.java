class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set=new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
             char ch=board[i][j];
             int boxRow=i/3;
             int boxCol=j/3;
             if(ch!='.'){
                 if(!set.contains(ch+" row "+i) && !set.contains(ch+" col "+j)&&!set.contains(ch+" boxRow "+boxRow+" boxCol "+boxCol)){
                   set.add(ch+" row "+i);
                   set.add(ch+" col "+j);
                   set.add(ch+" boxRow "+boxRow+" boxCol "+boxCol);
                //   System.out.println(set);
                 }else{
                //   System.out.println(ch+" row "+i);
                //    System.out.println(ch+" col "+j);
                //    System.out.println(ch+" boxRow "+boxRow+" boxCol "+boxCol);
                //    System.out.println(set);    
                 return false;
                 }
             }
            }
        }
        return true;
    }
}