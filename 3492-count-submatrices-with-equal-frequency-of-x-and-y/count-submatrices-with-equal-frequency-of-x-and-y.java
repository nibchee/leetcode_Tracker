class Solution {
  public int numberOfSubmatrices(char[][] grid) {
    int m = grid.length;
    int n = grid[0].length;

    int countX_till_ij[][] = new int[m][n];
    int countY_till_ij[][] = new int[m][n];

    if (grid[0][0] == 'X')
      countX_till_ij[0][0] = 1;

    if (grid[0][0] == 'Y')
      countY_till_ij[0][0] = 1;

    // fill first Row
    for (int j = 1; j < n; j++) {
      countX_till_ij[0][j] = countX_till_ij[0][j - 1];
      if (grid[0][j] == 'X')
        countX_till_ij[0][j] += 1;

      countY_till_ij[0][j] = countY_till_ij[0][j - 1];
      if (grid[0][j] == 'Y')
        countY_till_ij[0][j] += 1;
    }

    // first column
    for (int i = 1; i < m; i++) {
      countX_till_ij[i][0] = countX_till_ij[i - 1][0];
      if (grid[i][0] == 'X')
        countX_till_ij[i][0] += 1;

      countY_till_ij[i][0] = countY_till_ij[i - 1][0];
      if (grid[i][0] == 'Y')
        countY_till_ij[i][0] += 1;
    }

    // now filling rest
    for (int i = 1; i < m; i++) {
      for (int j = 1; j < n; j++) {
        countX_till_ij[i][j] = countX_till_ij[i][j - 1] + countX_till_ij[i - 1][j] - countX_till_ij[i - 1][j - 1];
        if (grid[i][j] == 'X')
          countX_till_ij[i][j] += 1;

        countY_till_ij[i][j] = countY_till_ij[i][j - 1] + countY_till_ij[i - 1][j] - countY_till_ij[i - 1][j - 1];
        if (grid[i][j] == 'Y')
          countY_till_ij[i][j] += 1;

      }
    }

    // Finding ans
    int ans = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (countX_till_ij[i][j] > 0) {
          if (countX_till_ij[i][j] == countY_till_ij[i][j])
            ans++;
        }
    //     System.out.print(countX_till_ij[i][j]+""+countY_till_ij[i][j]+" ");
      }
    //   System.out.println();
    }
    return ans;
  }
}