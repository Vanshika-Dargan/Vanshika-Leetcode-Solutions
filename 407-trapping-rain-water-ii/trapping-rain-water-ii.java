import java.util.PriorityQueue;

class Solution {
    int dir[][] = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) {
            return 0;
        }

        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Pair> pq = new PriorityQueue<>();

        // Add all boundary cells to the priority queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    pq.offer(new Pair(heightMap[i][j], i, j));
                    visited[i][j] = true;
                }
            }
        }

        int ans = 0;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();

            for (int[] d : dir) {
                int new_i = curr.i + d[0];
                int new_j = curr.j + d[1];

                if (new_i >= 0 && new_i < m && new_j >= 0 && new_j < n && !visited[new_i][new_j]) {
                    visited[new_i][new_j] = true;
                    // Calculate water trapped
                    ans += Math.max(0, curr.height - heightMap[new_i][new_j]);
                    // Update height to the maximum of current height or neighbor height
                    pq.offer(new Pair(Math.max(curr.height, heightMap[new_i][new_j]), new_i, new_j));
                }
            }
        }

        return ans;
    }

    class Pair implements Comparable<Pair> {
        int height;
        int i;
        int j;

        Pair(int height, int i, int j) {
            this.height = height;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(Pair other) {
            return this.height - other.height;
        }
    }
}
