class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];

        Queue<int[]> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    dist[i][j] = 0;
                    q.add(new int[] { i, j });
                } else {
                    dist[i][j] = -1;
                }
            }
        }

        int[][] dir = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!q.isEmpty()) {
            int[] popped = q.poll();
            int x = popped[0];
            int y = popped[1];

            for (int i = 0; i < 4; i++) {
                int dx = x + dir[i][0];
                int dy = y + dir[i][1];

                if (dx >= 0 && dy >= 0 && dx < m && dy < n && dist[dx][dy] == -1) {
                    dist[dx][dy] = 1 + dist[x][y];
                    q.add(new int[] { dx, dy });
                }
            }
        }
        return dist;
    }

}