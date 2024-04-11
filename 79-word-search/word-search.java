class Solution {
    boolean visited[][];

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        visited = new boolean[m][n];
        boolean p = false;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(0) == board[i][j] && dfs(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length())
            return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]
                || board[i][j] != word.charAt(idx))
            return false;

        visited[i][j] = true;
        boolean found = dfs(board, i + 1, j, word, idx + 1) || dfs(board, i - 1, j, word, idx + 1)
                || dfs(board, i, j + 1, word, idx + 1) || dfs(board, i, j - 1, word, idx + 1);
        visited[i][j] = false;
        return found;
    }

}