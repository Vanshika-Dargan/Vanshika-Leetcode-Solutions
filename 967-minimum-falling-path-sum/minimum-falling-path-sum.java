class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int n = matrix.length;
        int dp[][] = new int[n][n];
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int a = Integer.MAX_VALUE;
                int b = Integer.MAX_VALUE;
                int c = Integer.MAX_VALUE;
                if (j - 1 >= 0)
                    a = dp[i - 1][j - 1];
                b = dp[i - 1][j];
                if (j + 1 < n)
                    c = dp[i - 1][j + 1];
                 min = Math.min(a, Math.min(b, c));
                dp[i][j] = matrix[i][j] + min;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            ans = Math.min(ans,dp[n-1][i]);
        }
        return ans;
    }

    int fn(int[][] matrix, int i, int j, int dp[][]) {
        if (j < 0 || j >= matrix.length)
            return Integer.MAX_VALUE;
        if (i == matrix.length - 1)
            return matrix[i][j];
        if (dp[i][j] != Integer.MAX_VALUE)
            return dp[i][j];
        int a = fn(matrix, i + 1, j - 1, dp);
        int b = fn(matrix, i + 1, j, dp);
        int c = fn(matrix, i + 1, j + 1, dp);
        int min = Math.min(a, Math.min(b, c));
        if (min == Integer.MAX_VALUE)
            dp[i][j] = Integer.MAX_VALUE;
        dp[i][j] = matrix[i][j] + min;
        return dp[i][j];
    }
}