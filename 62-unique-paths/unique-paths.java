class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m + 1][n + 1];
        dp[m - 1][n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if(i==m-1 && j==n-1) continue;
                int right = dp[i + 1][j];
                int down = dp[i][j + 1];
                dp[i][j] = right + down;
            }
        }
        return dp[0][0];
        // return fn(0,0,m,n,dp);
    }

    int fn(int i, int j, int m, int n, int[][] dp) {
        if (i == m - 1 && j == n - 1)
            return 1;
        if (i >= m || j >= n)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int right = fn(i + 1, j, m, n, dp);
        int down = fn(i, j + 1, m, n, dp);
        return dp[i][j] = right + down;
    }
}