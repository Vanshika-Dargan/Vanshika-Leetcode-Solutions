class Solution {
    public int cherryPickup(int[][] grid) {
        int m = grid[0].length;
        int n = grid.length;
        int dp[][][] = new int[n][m][m];
        for (int box[][] : dp) {
            for (int row[] : box) {
                Arrays.fill(row, -1);
            }
        }
        return fn(grid, 0, 0, grid[0].length - 1,dp);
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

                temp = fn(grid, i + 1, d1 + j1, d2 + j2,dp);
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