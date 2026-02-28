class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int dp[][] = new int[m][n];
        for(int row[]:dp)
        Arrays.fill(row,-1);
        return fn(grid,m-1,n-1,dp);
    }
    int fn(int[][] grid,int i, int j,int dp[][]){
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = fn(grid,i-1,j,dp);
        int left = fn(grid,i,j-1,dp);

        return dp[i][j]=grid[i][j]+Math.min(up,left);
    }
}