class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int n = matrix.length;
        int dp[][] = new int[n][n];
        for (int row[] : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            min = Math.min(min, fn(matrix, 0, i,dp));
        }
        return min;
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
        dp[i][j]=matrix[i][j] + min;
        return dp[i][j];
    }
}