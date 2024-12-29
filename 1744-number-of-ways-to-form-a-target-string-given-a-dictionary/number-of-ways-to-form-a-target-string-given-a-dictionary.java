class Solution {
     int mod = 1_000_000_007;
    public int numWays(String[] words, String target) {
        int n = words.length;
        int m = words[0].length();
        int[][] freq = new int[26][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = words[i].charAt(j);
                freq[ch - 'a'][j] += 1;
            }
        }
        int[][] dp = new int[target.length()][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(freq, target, 0, m, -1, dp);
    }

    int helper(int[][] freq, String target, int i, int m, int last, int[][] dp) {
        if (i == target.length()) {
            return 1;
        }

        if (dp[i][last + 1] != -1) {
            return dp[i][last + 1];
        }

        char ch = target.charAt(i);
        int c = ch - 'a';
        int count = 0;

        for (int j = last + 1; j < m; j++) {
            if (freq[c][j] != 0) {
                count = (count + (int)((long)freq[c][j] * helper(freq, target, i + 1, m, j, dp) % mod)) % mod;
            }
        }
        dp[i][last + 1] = count;
        return count;
    }
}
