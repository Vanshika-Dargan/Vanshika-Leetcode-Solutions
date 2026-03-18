class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();
        int prev[] = new int[m + 1];

            prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                char c1 = s.charAt(i - 1);
                char c2 = t.charAt(j - 1);
                int not_take = prev[j];
                int take = 0;
                if (c1 == c2) {
                    take = prev[j - 1];
                }
                prev[j] = take + not_take;
            }
        }

        return prev[m];
    }

    int fn(String s, String t, int i, int j, int[][] dp) {
        if (j < 0)
            return 1;
        if (i < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        char c1 = s.charAt(i);
        char c2 = t.charAt(j);
        int not_take = fn(s, t, i - 1, j, dp);
        int take = 0;
        if (c1 == c2) {
            take = fn(s, t, i - 1, j - 1, dp);
        }
        dp[i][j] = take + not_take;
        return dp[i][j];
    }
}