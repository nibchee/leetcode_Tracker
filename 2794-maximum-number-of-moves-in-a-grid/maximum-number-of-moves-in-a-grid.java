class Solution {
    int ans = 0;
    int[][] memo;   
    public int maxMoves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        memo = new int[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            Arrays.fill(memo[i], -1);
        }
        
        for (int i = 0; i < rows; i++) {
            ans = Math.max(ans, try_allWays(grid, i, 0));
        }
        return ans;
    }

    private int try_allWays(int[][] grid, int row, int col) {
        if (memo[row][col] != -1) {
            return memo[row][col];
        }
        
        int moves = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        if (row - 1 >= 0 && col + 1 < cols && grid[row - 1][col + 1] > grid[row][col]) {
            moves = Math.max(moves, 1 + try_allWays(grid, row - 1, col + 1));
        }
        if (col + 1 < cols && grid[row][col + 1] > grid[row][col]) {
            moves = Math.max(moves, 1 + try_allWays(grid, row, col + 1));
        }
        if (row + 1 < rows && col + 1 < cols && grid[row + 1][col + 1] > grid[row][col]) {
            moves = Math.max(moves, 1 + try_allWays(grid, row + 1, col + 1));
        }

        memo[row][col] = moves;
        return moves;
    }
}
