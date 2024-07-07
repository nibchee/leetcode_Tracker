class Solution {
public:
    int numberOfSubmatrices(vector<vector<char>>& grid) {
        int m = grid.size();
        int n = grid[0].size();

        vector<vector<int>> countX_till_ij(m, vector<int>(n, 0));
        vector<vector<int>> countY_till_ij(m, vector<int>(n, 0));

        if (grid[0][0] == 'X')
            countX_till_ij[0][0] = 1;

        if (grid[0][0] == 'Y')
            countY_till_ij[0][0] = 1;

        // Fill first row
        for (int j = 1; j < n; j++) {
            countX_till_ij[0][j] = countX_till_ij[0][j - 1];
            if (grid[0][j] == 'X')
                countX_till_ij[0][j] += 1;

            countY_till_ij[0][j] = countY_till_ij[0][j - 1];
            if (grid[0][j] == 'Y')
                countY_till_ij[0][j] += 1;
        }

        // Fill first column
        for (int i = 1; i < m; i++) {
            countX_till_ij[i][0] = countX_till_ij[i - 1][0];
            if (grid[i][0] == 'X')
                countX_till_ij[i][0] += 1;

            countY_till_ij[i][0] = countY_till_ij[i - 1][0];
            if (grid[i][0] == 'Y')
                countY_till_ij[i][0] += 1;
        }
         //filling rest
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

        //now counting
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (countX_till_ij[i][j] > 0) {
                    if (countX_till_ij[i][j] == countY_till_ij[i][j])
                        ans++;
                }
            }
        }

        return ans;
    }
};