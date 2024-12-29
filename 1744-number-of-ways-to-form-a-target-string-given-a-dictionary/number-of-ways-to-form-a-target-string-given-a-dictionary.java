import java.util.Arrays;

class Solution {
    public int numWays(String[] words, String target) {
        int n = words.length;
        int m = words[0].length();
        int mod = 1_000_000_007;

        int[][] freq = new int[26][m];

        // Build frequency matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                char ch = words[i].charAt(j);
                freq[ch - 'a'][j] += 1;
            }
        }

        // Initialize DP array
        int[][] dp = new int[target.length()][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        // Call helper function
        return helper(freq, target, 0, m, -1, mod, dp);
    }

    int helper(int[][] freq, String target, int i, int m, int last, int mod, int[][] dp) {
        // Base case: all characters in the target are processed
        if (i == target.length()) {
            return 1;
        }

        // Memoization check
        if (dp[i][last + 1] != -1) {
            return dp[i][last + 1];
        }

        char ch = target.charAt(i);
        int c = ch - 'a';
        int count = 0;

        // Try all positions from last + 1 to m for the current character
        for (int j = last + 1; j < m; j++) {
            if (freq[c][j] != 0) {
                // Multiply frequency and recursively calculate for the next character
                count = (count + (int)((long)freq[c][j] * helper(freq, target, i + 1, m, j, mod, dp) % mod)) % mod;
            }
        }

        // Store result in DP array
        dp[i][last + 1] = count;
        return count;
    }
}
