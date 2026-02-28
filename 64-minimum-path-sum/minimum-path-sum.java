class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[]= new int[n];
        // for(int row[]:dp)
        // Arrays.fill(row,-1);
        // return fn(grid,m-1,n-1,dp);
        dp[0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            int temp[]=new int[n];
            for (int j = 0; j < n; j++) {
                int up = Integer.MAX_VALUE;
                int left = Integer.MAX_VALUE;
                if(i>0)
                up = dp[j];
                if(j>0)
                left = temp[j - 1];

                temp[j] = grid[i][j];
                int min = Math.min(up, left);
                if(min!=Integer.MAX_VALUE){
                    temp[j]+=min;
                }
            }
            dp = temp;
        }
        return dp[n-1];
    }

    int fn(int[][] grid, int i, int j, int dp[][]) {
        if (i == 0 && j == 0)
            return grid[i][j];
        if (i < 0 || j < 0)
            return Integer.MAX_VALUE;
        if (dp[i][j] != -1)
            return dp[i][j];
        int up = fn(grid, i - 1, j, dp);
        int left = fn(grid, i, j - 1, dp);

        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }
}