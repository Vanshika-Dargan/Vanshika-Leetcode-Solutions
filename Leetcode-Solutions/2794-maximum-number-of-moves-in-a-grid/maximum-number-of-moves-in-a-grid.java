class Solution {
    public int maxMoves(int[][] grid) {
        int max = 0;
        for (int row = 0; row < grid.length; row++) {
            int dp[][]= new int[grid.length][grid[0].length];
           for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
            max = Math.max(max, helper(grid, row, 0,dp));
        }
        return max;
    }

    int helper(int[][] grid, int row, int col,int dp[][]) {
        if (row >= grid.length || col >= grid[0].length) return 0;

        int current = grid[row][col];
        int a = 0, b = 0, c = 0;
        if(dp[row][col] !=-1) return dp[row][col];
        if (row-1 >= 0 && col + 1 < grid[0].length && grid[row - 1][col + 1] > current) {
            a = 1+helper(grid, row - 1, col + 1,dp);
        }
        
        if (row>=0 && col + 1 < grid[0].length && grid[row][col + 1] > current) {
            b = 1+helper(grid, row, col + 1,dp);
        }

        if (row + 1 < grid.length && col + 1 < grid[0].length && grid[row + 1][col + 1] > current) {
            c = 1+helper(grid, row + 1, col + 1,dp);
        }
        dp[row][col]=Math.max(a, Math.max(b, c));
        return dp[row][col];
    }
}
