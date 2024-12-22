import java.util.*;

class Solution {
    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int m = heights.length;
        int n = queries.length;
        int[] ans = new int[n];

        List<int[]>[] queryOrder = new ArrayList[m];
        List<Integer> maximas = new ArrayList<>();

        // Initialize queryOrder lists
        for (int i = 0; i < m; i++) {
            queryOrder[i] = new ArrayList<>();
        }

        // Process each query
        for (int i = 0; i < n; i++) {
            int x = queries[i][0];
            int y = queries[i][1];

            // Ensure x <= y
            if (x > y) {
                int temp = x;
                x = y;
                y = temp;
            }

            if (y == x) {
                ans[i] = x;
            } else if (heights[y] > heights[x]) {
                ans[i] = y;
            } else {
                queryOrder[y].add(new int[] { heights[x], i });
            }
        }

        // Process queries from right to left
        for (int i = m - 1; i >= 0; i--) {
            if (queryOrder[i] != null) {
                List<int[]> toProcess = queryOrder[i];

                for (int[] current : toProcess) {
                    int res = binarySearch(current[0], maximas, heights);
                    if (res >= 0 && res < maximas.size()) {
                        ans[current[1]] = maximas.get(res);
                    } else {
                        ans[current[1]] = -1;
                    }
                }

                // Update maximas
                while (!maximas.isEmpty() && heights[maximas.get(maximas.size() - 1)] < heights[i]) {
                    maximas.remove(maximas.size() - 1);
                }

                maximas.add(i);
            }
        }

        return ans;
    }

    private int binarySearch(int key, List<Integer> arr, int[] heights) {
        int low = 0;
        int high = arr.size() - 1;
        int ans = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (heights[arr.get(mid)] <= key) {
                high = mid - 1;
            } else {
                ans = mid;
                low = mid + 1;
            }
        }

        return ans;
    }
}
