class Solution {
    static int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public boolean isValid(int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return false;
        return true;
    }

    public void dfs(int i, int j, char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        grid[i][j] = '2';
        for (int d[] : dir) {
            int new_i = d[0] + i;
            int new_j = d[1] + j;
            if (isValid(new_i, new_j, m, n) && grid[new_i][new_j] == '1') {
                dfs(new_i, new_j, grid);
            }
        }
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int island = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    dfs(i, j, grid);
                }
            }
        }
        return island;
    }
}