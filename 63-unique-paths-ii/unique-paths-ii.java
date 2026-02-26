class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        if(grid[m-1][n-1]==1) return 0;
        return fn(0,0,m,n,grid,dp);
    }
        int fn(int i, int j, int m, int n, int[][] grid,int[][] dp) {
        if (i == m - 1 && j == n - 1)
            return 1;
        if (i >= m || j >= n || grid[i][j]==1)
            return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int right = fn(i + 1, j, m, n, grid,dp);
        int down = fn(i, j + 1, m, n, grid,dp);
        return dp[i][j]=right + down;
    }
}

// class Solution {
//     public int uniquePaths(int m, int n) {
//         int dp[]=new int[n];
//         Arrays.fill(dp,1);
//         for (int i = m - 2; i >= 0; i--) {
//             int temp[]=new int[n+1];
//             temp[n-1]=1;
//             for (int j = n - 2; j >= 0; j--) {
//                 int right = temp[j+1];
//                 int down = dp[j];
//                 temp[j] = right + down;
//             }
//             dp = temp.clone();
//         }
//         return dp[0];
//         // return fn(0,0,m,n,dp);
//     }


// }