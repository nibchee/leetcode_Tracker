class Solution {
    boolean visited[][];
    public boolean exist(char[][] board, String word) {
        boolean found=false;
         char start_letter=word.charAt(0);
         visited=new boolean[board.length][board[0].length];
         for(int i=0;i<board.length;i++){
             for(int j=0;j<board[i].length;j++){
                 if(board[i][j]==start_letter){
                     visited[i][j]=true;
                     if(search_word(i,j,board,word.substring(1),""))
                     {
                         found=true;
                         break;
                     }
                     visited[i][j]=false;
                 }
                 if(found)
                 break;
             }
         }  
        return found; 
    }

    public boolean search_word(int x,int y,char[][] board, String word,String path){
       //   System.out.println("Word-"+word);
      if(word.length()==0){
      //    System.out.println("Path "+path);
          return true;
      }
         char start_letter=word.charAt(0);
         //Move Left
         if(y-1>=0 && !visited[x][y-1] && board[x][y-1]==start_letter){
             visited[x][y-1]=true;
            if(search_word(x,y-1,board,word.substring(1),path+"L")){
                 return true;
            }
             visited[x][y-1]=false; 
         }

         //Move Right
          if(y+1<board[0].length && !visited[x][y+1] && board[x][y+1]==start_letter){
             visited[x][y+1]=true;
             if(search_word(x,y+1,board,word.substring(1),path+"R")){
                 return true;
             }
             visited[x][y+1]=false; 
         }
         //Move Up
      if(x-1>=0 && !visited[x-1][y] && board[x-1][y]==start_letter){
             visited[x-1][y]=true;
             if(search_word(x-1,y,board,word.substring(1),path+"U")){
                 return true;
             }
             visited[x-1][y]=false; 
         }
         //Move Down
         if(x+1<board.length && !visited[x+1][y] && board[x+1][y]==start_letter){
             visited[x+1][y]=true;
             if(search_word(x+1,y,board,word.substring(1),path+"D")){
                 return true;
             }
             visited[x+1][y]=false; 
            }
      return false;

    }

}