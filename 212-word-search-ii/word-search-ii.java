
class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWordEnd;
    String word;

    public TrieNode() {
        isWordEnd = false;
        word = "";
    }
}
class Solution {
    TrieNode root=new TrieNode();
     List<String> result;
    public List<String> findWords(char[][] board, String[] words) {
          int row=board.length;
          int col=board[0].length;

          for(String i:words){
            insert(i);
          }

         result=new ArrayList<>();

          for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                search(board,i,j,root,result);
            }
          }
    return result;
    }

    public void insert(String word) {
    TrieNode temp=root;
    for(int i=0;i<word.length();i++){
        int index=word.charAt(i)-'a';
        if(temp.children[index]==null){
            temp.children[index]=new TrieNode();
        }
        temp=temp.children[index];
    }
    temp.isWordEnd=true;
    temp.word=word;
    }


    public void search(char[][] board,int r,int c,TrieNode root,List<String> result){
        if(r<0 || c<0 || r>=board.length||c>=board[0].length)
        return;

        if(board[r][c]=='$'){
            return;
        }

        int index=board[r][c]-'a';
        if(root.children[index]==null)
        return;

        root=root.children[index];

        if(root.isWordEnd){
            result.add(root.word);
            root.isWordEnd=false;
        }

        char store=board[r][c];
        board[r][c]='$';

        search(board,r+1,c,root,result);
        search(board,r-1,c,root,result);
        search(board,r,c+1,root,result);
        search(board,r,c-1,root,result);

        board[r][c]=store;

    }
}