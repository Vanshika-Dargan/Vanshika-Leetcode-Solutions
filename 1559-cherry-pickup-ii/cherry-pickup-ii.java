class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int front[][]=new int[m][m];
        for (int j1 = 0; j1 < m; j1++) {
            for (int j2 = 0; j2 < m; j2++) {
                if (j1 == j2)
                    front[j1][j2] = grid[n - 1][j1];
                else
                    front[j1][j2] = grid[n - 1][j1] + grid[n - 1][j2];
            }
        }

        for (int i = n - 2; i >= 0; i--) {
            int curr[][]=new int[m][m];
            for (int j1 = m - 1; j1 >= 0; j1--) {
                for (int j2 = m - 1; j2 >= 0; j2--) {
                    int max = Integer.MIN_VALUE;
                    for (int d1 = -1; d1 <= 1; d1++) {
                        int temp = Integer.MIN_VALUE;
                        for (int d2 = -1; d2 <= 1; d2++) {
                            if (j1 + d1 < 0 || j1 + d1 >= m || j2 + d2 < 0 || j2 + d2 >= m)
                                continue;
                            temp = front[d1 + j1][d2 + j2];
                            if (temp == Integer.MIN_VALUE)
                                continue;
                            temp += grid[i][j1];
                            if (j1 != j2) {
                                temp += grid[i][j2];
                            }
                            max = Math.max(max, temp);
                        }
                    }
                    curr[j1][j2] = max;
                }
            }
            front = curr;
        }
        return front[0][m - 1];
    }

    int fn(int[][] grid, int i, int j1, int j2, int dp[][][]) {
        int m = grid[0].length;
        int n = grid.length;
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m)
            return Integer.MIN_VALUE;
        if (i == n - 1 && j1 == j2)
            return grid[i][j1];
        if (i == n - 1 && j1 != j2)
            return grid[i][j1] + grid[i][j2];
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];
        int max = Integer.MIN_VALUE;
        for (int d1 = -1; d1 <= 1; d1++) {
            int temp = Integer.MIN_VALUE;
            for (int d2 = -1; d2 <= 1; d2++) {

                temp = fn(grid, i + 1, d1 + j1, d2 + j2, dp);
                if (temp == Integer.MIN_VALUE)
                    continue;
                temp += grid[i][j1];
                if (j1 != j2) {
                    temp += grid[i][j2];
                }
                max = Math.max(max, temp);
            }
        }
        dp[i][j1][j2] = max;
        return max;
    }
}