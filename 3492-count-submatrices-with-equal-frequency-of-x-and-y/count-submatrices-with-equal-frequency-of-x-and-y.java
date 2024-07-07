class Solution {
  public int numberOfSubmatrices(char[][] grid) {
    int m = grid.length;
        int n = grid[0].length;

        // Initialize prefix sums
        int[][] prefixX = new int[m + 1][n + 1];
        int[][] prefixY = new int[m + 1][n + 1];

        // Fill prefix sums
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                prefixX[i + 1][j + 1] = prefixX[i + 1][j] + prefixX[i][j + 1] - prefixX[i][j] + (grid[i][j] == 'X' ? 1 : 0);
                prefixY[i + 1][j + 1] = prefixY[i + 1][j] + prefixY[i][j + 1] - prefixY[i][j] + (grid[i][j] == 'Y' ? 1 : 0);
            }
        }

        int count = 0;

        // Iterate over all possible bottom-right corners of submatrices starting from (0,0)
        for (int r2 = 0; r2 < m; r2++) {
            for (int c2 = 0; c2 < n; c2++) {
                if (r2 == 0 && c2 == 0) continue; // Skip the case where the submatrix is just the top-left cell

                // Calculate the number of 'X' and 'Y' in the submatrix (0,0) to (r2,c2)
                int xCount = prefixX[r2 + 1][c2 + 1];
                int yCount = prefixY[r2 + 1][c2 + 1];

                // Check if the submatrix has an equal number of 'X' and 'Y' and contains at least one 'X'
                if (xCount == yCount && xCount > 0) {
                    count++;
                }
            }
        }

        return count;
  }
}