class Solution {
    public boolean isValid(int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return false;
        return true;
    }

    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        LinkedList<int[]> q = new LinkedList<>();
        int dir[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int island = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    island++;
                    grid[i][j] = '2';
                    q.offer(new int[] { i, j });
                    while (!q.isEmpty()) {
                        int node[] = q.poll();
                        for (int d[] : dir) {
                            if (isValid(node[0] + d[0], node[1] + d[1], m, n) && grid[node[0] + d[0]][node[1] + d[1]] == '1'){
                                grid[node[0] + d[0]][node[1] + d[1]]='2';
                                q.offer(new int[] { node[0] + d[0], node[1] + d[1] });
                            }
                        }
                    }
                }
            }
        }
        return island;
    }
}