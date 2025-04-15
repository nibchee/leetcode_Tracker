class Solution {

    public boolean isValid(int row,int col,char [][] board,char c){
     for(int i=0;i<9;i++){
        if(board[i][col]==c) return false;
        if(board[row][i]==c) return false;
        if(board[3*(row/3)+(i/3)][3*(col/3)+(i%3)]==c) return false;
     }
     return true;
    }
    public boolean helper(char[][] board){
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    for(char ch='1';ch<='9';ch++){
                        if(isValid(i,j,board,ch)){
                            board[i][j]=ch;
                            if(helper(board)) return true;
                            board[i][j]='.';
                        }
                    }
                    return false;
                }
            
            }
        }
        return true;
    }
    public void solveSudoku(char[][] board) {
         helper(board);
    }
}